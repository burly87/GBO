package gui.pizza;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Pizza extends Application
{
    private static Configuration bezeichner;

    private String[] toppingNames;

    private String[] sizeNames;

    private CheckBox[] toppingBoxes; // Array mit Checkboxes zur isSelected()
                                     // abfrage

    private RadioButton[] sizeButtons;// Array mit RadioButtons zur isSelected()
                                      // abfrage

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        bezeichner = ParameterConverter.createConfiguration(getParameters().getNamed());

        toppingNames = bezeichner.getToppingNames();
        sizeNames = bezeichner.getSizeNames();

        /* Checkboxes und RadioButtons */
        CheckBox[] toppingBoxes2 = new CheckBox[bezeichner.getToppingNames().length];
        this.toppingBoxes = toppingBoxes2;
        RadioButton[] sizeButtons2 = new RadioButton[bezeichner.getSizeNames().length];
        this.sizeButtons = sizeButtons2;

        ToggleGroup sizeGroup = new ToggleGroup();

        VBox root = new VBox(5);

        /* Zutaten Auswaehlen */
        for (int i = 0; i < toppingNames.length && toppingNames[i] != null; i++)
        {
            toppingBoxes2[i] = new CheckBox(toppingNames[i]);
            root.getChildren().add(toppingBoxes2[i]);
        }

        /* Size Auswaehlen */
        for (int i = 0; i < sizeNames.length && toppingNames[i] != null; i++)
        {
            sizeButtons2[i] = new RadioButton(sizeNames[i]);
            sizeButtons2[i].setToggleGroup(sizeGroup);
            root.getChildren().add(sizeButtons2[i]);

            if (i == 1)
            {
                sizeButtons2[i].setSelected(true);
            }
        }

        /* disable Auswahl fuer defaultZutaten */
        int setDefault = bezeichner.getNumberOfDefaultToppings();

        for (int i = 0; i < setDefault; i++)
        {
            toppingBoxes2[i].setSelected(true);
            toppingBoxes2[i].setDisable(true);
        }

        /* Bestelltext Ausgabe */
        TextArea txtOut = new TextArea();
        txtOut.setEditable(false);
        txtOut.setId("bestelltext");
        txtOut.setText("\n");

        /* Bestellbutton */
        Button btnOrder = new Button("Bestellen!");
        btnOrder.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                txtOut.setText(fillText());
            }

        });

        root.getChildren().add(btnOrder);
        root.getChildren().add(txtOut);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("KNOBLAUCHPizza-BestellAutomat");
        primaryStage.show();

    }

    private String fillText()
    {
        double price = 0;
        int priceToppings[] = bezeichner.getToppingPrices();
        int priceSize[] = bezeichner.getSizePrices();

        String bestelltext = "Bestellung aufgenommen.\nZutaten: ";

        for (int i = 0; i < toppingNames.length; i++)
        {
            if (toppingBoxes[i].isSelected())
            {
                bestelltext += toppingBoxes[i].getText() + " ";
                price += priceToppings[i];
            }
        }
        bestelltext += "\nGroesse: ";

        for (int i = 0; i < sizeNames.length; i++)
        {
            if (sizeButtons[i].isSelected())
            {
                bestelltext += sizeButtons[i].getText() + " ";
                price += priceSize[i];
            }
        }
        bestelltext += "\nKosten: " + price / 100 + "0 EUR\n";
        bestelltext += "Vielen Dank fuer Ihre Bestellung";

        return bestelltext;
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
