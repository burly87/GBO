package gui.country.combo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountryInfo extends Application
{
    private static List<Country> list = new ArrayList<Country>();

    private ObservableList<Country> countrys = FXCollections.observableArrayList(list);

    private ComboBox<Country> cEnum = new ComboBox<>(countrys);

    @Override
    public void start(Stage primaryStage) throws Exception
    { /* Surface */
        GridPane root = new GridPane();

        VBox vboxLeft = new VBox(5);
        VBox vboxRight = new VBox(5);
        HBox hBox = new HBox(2);

        root.add(vboxLeft, 0, 2);
        root.add(vboxRight, 1, 2);
        root.add(hBox, 0, 3, 5, 1);

        /* in Boxes */
        Label countryName = new Label("Land:");
        Label capital = new Label("Hauptstadt:");
        Label population = new Label("Einwohner:");
        Label area = new Label("Flaeche (in qkm):");
        Label density = new Label("Bevoelkerungsdichte (in Personen pro qkm):");

        Label countryOut = new Label();
        Label capitalOut = new Label();
        Label populationOut = new Label();
        Label areaOut = new Label();
        Label densityOut = new Label();

        TextField tfCountry = new TextField("Land");
        TextField tfCapital = new TextField("Hauptstadt");
        TextField tfPopulation = new TextField("Einwohner");
        TextField tfArea = new TextField("Flaeche");

        Button add = new Button("Hinzufuegen");
        Button delete = new Button("Loeschen");

        /* ComboBox anlegen mit entsprechendem Listener */
        cEnum.setId("countrySeletor");
        // cEnum.setValue(countrys.get(0));
        cEnum.setEditable(false);

        cEnum.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Country name = cEnum.getSelectionModel().getSelectedItem();
                cEnum.setPromptText(name.toString());
                countryOut.setText(name.getName());
                capitalOut.setText(name.getCapital());
                populationOut.setText("" + name.getPeople());
                areaOut.setText("" + name.getArea());
                densityOut.setText("" + (name.getPeople()) / (name.getArea()));

                long roundedPop = name.getPeople();
                long roundedArea = name.getArea();

                if (roundedPop >= 999999)
                {
                    populationOut.setText("" + name.getPeople() / 1000000 + " Mill.");
                }
                if (roundedArea >= 999999)
                {
                    areaOut.setText("" + name.getArea() / 1000000 + " Mill.");
                }

            }
        });

        /* CheckBox */
        CheckBox checkBox = new CheckBox("exakte Angaben");
        checkBox.setId("exactValues");

        checkBox.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                Country name = cEnum.getSelectionModel().getSelectedItem();
                populationOut.setText("" + name.getPeople());
                areaOut.setText("" + name.getArea());

                long roundedPop = name.getPeople();
                long roundedArea = name.getArea();

                if (roundedPop >= 999999 && !checkBox.isSelected())
                {
                    populationOut.setText("" + name.getPeople() / 1000000 + " Mill.");
                }
                if (roundedArea >= 999999 && !checkBox.isSelected())
                {
                    areaOut.setText("" + name.getArea() / 1000000 + " Mill.");
                }

            }
        });

        /* ButtonListener */
        add.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String strCountry = tfCountry.getText();
                String strCapital = tfCapital.getText();
                String strPopulation = tfPopulation.getText();
                String strArea = tfArea.getText();
                long lPopulation = Long.parseLong(strPopulation);
                long lArea = Long.parseLong(strArea);

                if (!"".equals(tfCountry.getText()) && (!"".equals(tfCapital.getText())))
                {
                    cEnum.getItems().add(new Country(strCountry, strCapital, lPopulation, lArea));
                }

            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                Country selected = cEnum.getSelectionModel().getSelectedItem();
                cEnum.getItems().remove(selected);

                if (!"".equals(cEnum.getItems()))
                {
                    cEnum.setPromptText("Keine Laender vorhanden");
                }
            }
        });

        /* Zeichnen */
        root.getChildren().add(cEnum);
        root.add(checkBox, 0, 1);
        vboxLeft.getChildren().addAll(countryName, capital, population, area, density);
        vboxRight.getChildren().addAll(countryOut, capitalOut, populationOut, areaOut, densityOut);
        hBox.getChildren().addAll(tfCountry, tfCapital, tfPopulation, tfArea, add, delete);

        Scene scene = new Scene(root, 600, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("L�nder-Informationen");
        primaryStage.show();

    }

    public void roundOff()
    {
        Country erg = cEnum.getSelectionModel().getSelectedItem();

        long rounded = erg.getPeople();

        if (rounded >= 999999)
        {
            rounded /= 1000000;
        }

    }

    public static void main(String[] args)
    {
        list.add(new Country("Deutschland", "Berlin", 89168, 1000));
        list.add(new Country("Luxembourg", "Luxembourg", 511840, 3000));
        list.add(new Country("Kanada", "Ottawa", 34278406, 9984670));
        list.add(new Country("Belgien", "Bruessel", 11000000, 31000));
        launch(args);
    }
}
