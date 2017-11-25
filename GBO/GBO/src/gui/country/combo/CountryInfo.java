package gui.country.combo;

import java.text.DecimalFormat;

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

    private ObservableList<Country> countries;

    private ComboBox<Country> cEnum;

    /* in Boxes */
    private Label countryName1;

    private Label capital1;

    private Label population1;

    private Label area1;

    private Label density1;

    private Label countryName;

    private Label capital;

    private Label population;

    private Label area;

    private Label density;

    private TextField countryField;

    private TextField capitalField;

    private TextField populationField;

    private TextField areaField;

    private CheckBox checkBox;

    private Button add;

    private Button delete;

    @Override
    public void start(Stage primaryStage) throws Exception
    { /* Surface */
        GridPane root = new GridPane();

        countries = FXCollections.observableArrayList();
        cEnum = new ComboBox<>(countries);

        countries.add(new Country("Deutschland", "Berlin", 8916800, 1000000));
        countries.add(new Country("Luxembourg", "Luxembourg", 5118, 3600));
        countries.add(new Country("Test2", "test2", 36163, 2));
        countries.add(new Country("Test", "test", 36942, 160));
        countries.add(new Country("Kanada", "Ottawa", 34278406, 9984670));
        countries.add(new Country("Belgien", "Bruessel", 11000230, 31001));

        VBox vboxLeft = new VBox(5);
        VBox vboxRight = new VBox(5);
        HBox hBox = new HBox(2);

        root.add(vboxLeft, 0, 2);
        root.add(vboxRight, 1, 2);
        root.add(hBox, 0, 3, 5, 1);

        /* in Boxes */
        countryName1 = new Label("Land:");
        capital1 = new Label("Hauptstadt:");
        population1 = new Label("Einwohner:");
        area1 = new Label("Fl\u00e4che (in qkm):");
        density1 = new Label("Bev\u00f6lkerungsdichte (in Personen pro qkm):");

        countryName = new Label();
        capital = new Label();
        population = new Label();
        area = new Label();
        density = new Label();

        countryField = new TextField();
        capitalField = new TextField();
        populationField = new TextField();
        areaField = new TextField();

        countryField.setPromptText("Land");
        capitalField.setPromptText("Hauptstadt");
        populationField.setPromptText("Einwohner");
        areaField.setPromptText("Fl\u00e4che");

        /* CheckBox */
        checkBox = new CheckBox("exakte Angaben");

        add = new Button("Hinzuf\u00fcgen");

        delete = new Button("L\u00f6schen");

        /* Zeichnen */
        root.getChildren().add(cEnum);
        root.add(checkBox, 0, 1);
        vboxLeft.getChildren().addAll(countryName1, capital1, population1, area1, density1);
        vboxRight.getChildren().addAll(countryName, capital, population, area, density);
        hBox.getChildren().addAll(countryField, capitalField, populationField, areaField, add, delete);

        /* Ids */
        checkBox.setId("exactValues");
        countryName.setId("countryName");
        capital.setId("capital");
        population.setId("population");
        area.setId("area");
        density.setId("density");

        countryField.setId("countryField");
        capitalField.setId("capitalField");
        populationField.setId("populationField");
        areaField.setId("areaField");

        add.setId("add");
        delete.setId("delete");

        cEnum.setId("countrySelector");
        cEnum.setEditable(false);

        cEnum.setPromptText("Keine L\u00e4nder vorhanden");
        cEnum.getSelectionModel().selectFirst();
        ausgabe();

        cEnum.setOnAction((e) -> ausgabe());

        checkBox.setOnAction(new EventHandler<ActionEvent>()
        {

            @Override
            public void handle(ActionEvent event)
            {
                Country name = cEnum.getSelectionModel().getSelectedItem();
                population.setText("" + roundOff(name.getPeople()));
                area.setText("" + roundOff(name.getArea()));
            }
        });

        /* ButtonListener */
        add.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                String strCountry = countryField.getText();
                String strCapital = capitalField.getText();
                String strPopulation = populationField.getText();
                String strArea = areaField.getText();
                long lPopulation = Long.parseLong(strPopulation);
                long lArea = Long.parseLong(strArea);

                if (!"".equals(countryField.getText()) && (!"".equals(capitalField.getText())))
                {
                    countries.add(new Country(strCountry, strCapital, lPopulation, lArea));
                }
                countryField.clear();
                capitalField.clear();
                populationField.clear();
                areaField.clear();
            }
        });

        delete.setOnAction(new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    if (countries != null)
                    {
                        Country selected = cEnum.getSelectionModel().getSelectedItem();
                        cEnum.getItems().remove(selected);
                        countries.get(cEnum.getSelectionModel().getSelectedIndex());
                    }
                }
                catch (ArrayIndexOutOfBoundsException e)
                {
                    if (cEnum.getSelectionModel().getSelectedIndex() == -1)
                    {
                        cEnum.getSelectionModel().select(0);
                    }
                    System.out.println("Liste ist -1");
                }
            }
        });

        Scene scene = new Scene(root, 600, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("L\u00e4nder-Informationen");
        primaryStage.show();
    }

    private void ausgabe()
    {
        try
        {
            Country name = cEnum.getSelectionModel().getSelectedItem();

            countryName.setText(name.getName());
            capital.setText(name.getCapital());
            population.setText("" + roundOff(name.getPeople()));
            area.setText("" + roundOff(name.getArea()));
            density.setText("" + roundOff(name.getDensity()));
            // density.setText("" + roundOff(name.getPeople() /
            // name.getArea()));
        }
        catch (NullPointerException e)
        {
            System.out.println("caught " + e);
        }

    }

    private String decimalFormat(long var)
    {
        DecimalFormat n = new DecimalFormat("###,###,###");
        return n.format(var);
    }

    public String roundOff(long var)
    {
        /* ANSATZ */
        if (var >= 1000000 && !checkBox.isSelected())
        {
            return decimalFormat(Math.round(var / 1000000.0)) + " Mill.";
        }
        else if (var >= 1000 && !checkBox.isSelected())
        {
            return decimalFormat(Math.round(var / 1000.0) * 1000);
        }
        return decimalFormat(var);
        //
        // if (var >= 1000000l && var <= 999999999999l &&
        // !checkBox.isSelected())
        // {
        // long temp = (var / 100000l) % 10;
        // if (temp >= 5)
        // {
        // temp = (var / 1000000l) + 1;
        // str = Long.toString(temp) + " Mill.";
        // }
        // else
        // {
        // temp = (var / 1000000l);
        // str = Long.toString(temp) + " Mill.";
        // }
        // }
        // else if (var >= 1000l && var <= 999999l && !checkBox.isSelected())
        // {
        // long temp = (var / 100l) % 10;
        // if (temp >= 5)
        // {
        // temp = (var / 1000l) + 1;
        // str = Long.toString(temp) + ".000";
        // }
        // else
        // {
        // temp = (var / 1000l);
        // str = Long.toString(temp) + ".000";
        // }
        // }
        // // else if (var >= 100 && var <= 999 && !checkBox.isSelected())
        // // {
        // // long temp = var;
        // // if (densityTemp % (long) densityTemp > 0)
        // // {
        // // temp = var + 1;
        // // str = Long.toString(temp);
        // // }
        // // else
        // // {
        // // temp = var;
        // // str = Long.toString(temp);
        // // }
        // // }
        // else
        // {
        // str = decimalFormat(var);
        // }
        // return str;

    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
