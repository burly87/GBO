package gui.jan;

import java.text.DecimalFormat;

import gui.country.combo.Country;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class CountryInfo extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {

        Label countryName = new Label("");
        countryName.setId("countryName");
        Label captial = new Label("");
        captial.setId("capital");
        Label population = new Label("");
        population.setId("population");
        Label area = new Label("");
        area.setId("area");
        Label density = new Label("");
        density.setId("density");
        CheckBox exactValues = new CheckBox();
        exactValues.setId("exactValues");
        TextField countryField = new TextField();
        countryField.setId("countryField");
        TextField capitalField = new TextField();
        capitalField.setId("capitalField");
        TextField populationField = new TextField();
        populationField.setId("populationField");
        TextField areaField = new TextField();
        areaField.setId("areaField");
        Button add = new Button("Hinzuf\u00fcgen");
        add.setId("add");
        Button delete = new Button("L\u00f6schen");
        delete.setId("delete");

        countryField.setPromptText("Land");
        capitalField.setPromptText("Hauptstadt");
        populationField.setPromptText("Einwohner");
        areaField.setPromptText("Fl\u00e4che");

        exactValues.setText("exakte Angaben");

        Country test = new Country("Deutschland", "Berlin", 82670000, 357376);
        Country testtest = (new Country("Test", "test", 36942, 160));
        Country test2 = new Country("Frankreich", "Paris", 66991000, 643801);

        ObservableList<Country> options = FXCollections.observableArrayList(test);
        options.add(test2);
        options.add(testtest);

        ComboBox<Country> comboBox = new ComboBox<Country>(options);
        comboBox.setId("countrySelector");
        comboBox.setPromptText("Keine L\u00e4nder vorhanden");

        comboBox.getSelectionModel().select(0);
        Country temp = (Country) comboBox.getSelectionModel().getSelectedItem();
        countryName.setText(temp.toString());
        captial.setText(temp.getCapital());
        population.setText(formatter(temp.getPeople()));
        area.setText(formatter(temp.getArea()));
        density.setText(Long.toString(temp.getDensity()));

        exactValues.setOnAction((event) ->
        {

            DecimalFormat nf = new DecimalFormat();
            Country selectedCountry = (Country) comboBox.getSelectionModel().getSelectedItem();
            if (exactValues.isSelected())
            {
                population.setText(nf.format(selectedCountry.getPeople()));
                area.setText(nf.format(selectedCountry.getArea()));
                density.setText(nf.format(selectedCountry.getDensity()));
            }
            else
            {
                population.setText(formatter(selectedCountry.getPeople()));
                area.setText(formatter(selectedCountry.getArea()));
                density.setText(formatter(selectedCountry.getDensity()));
            }

        });

        comboBox.setOnAction((event) ->
        {
            DecimalFormat nf = new DecimalFormat();
            if (comboBox.getSelectionModel().getSelectedIndex() == -1)
            {
                comboBox.getSelectionModel().select(0);

            }

            Country selectedCountry = (Country) comboBox.getSelectionModel().getSelectedItem();

            try
            {

                countryName.setText(selectedCountry.toString());
                captial.setText(selectedCountry.getCapital());

                if (exactValues.isSelected())
                {
                    population.setText(nf.format(selectedCountry.getPeople()));
                    area.setText(nf.format(selectedCountry.getArea()));
                    density.setText(nf.format(selectedCountry.getDensity()));
                }
                else
                {
                    population.setText(formatter(selectedCountry.getPeople()));
                    area.setText(formatter(selectedCountry.getArea()));
                    density.setText(formatter(selectedCountry.getDensity()));
                }

            }
            catch (NullPointerException e)
            {
                countryName.setText("");
                population.setText("");
                area.setText("");
                density.setText("");
                captial.setText("");

                System.out.println("caught you");
            }

        });

        add.setOnAction((event) ->
        {
            try
            {
                options.add(new Country(countryField.getText(), capitalField.getText(), Long.parseLong(populationField.getText()), Long.parseLong(areaField.getText())));
            }
            catch (NumberFormatException e)
            {
                System.out.println("Keine gultige Eingabe");
            }
            catch (Exception e)
            {
                System.out.println("Konstruktor blew up");
            }
            countryField.clear();
            capitalField.clear();
            populationField.clear();
            areaField.clear();
            comboBox.getSelectionModel().select(options.size() - 1);
        });

        delete.setOnAction((event) ->
        {

            try
            {
                options.remove(comboBox.getSelectionModel().getSelectedIndex());
                System.out.println(comboBox.getSelectionModel().getSelectedIndex());
            }
            catch (Exception e)
            {
                System.out.println("Liste ist -1");
            }

        });

        GridPane gridpane = new GridPane();
        gridpane.setHgap(5);
        gridpane.setVgap(5);

        gridpane.add(comboBox, 0, 0);
        gridpane.add(exactValues, 0, 1);

        gridpane.add(new Label("Land: "), 0, 2);
        gridpane.add(countryName, 2, 2);

        gridpane.add(new Label("Hauptstadt: "), 0, 3);
        gridpane.add(captial, 2, 3);

        gridpane.add(new Label("Einwohner: "), 0, 4);
        gridpane.add(population, 2, 4);

        gridpane.add(new Label("Flaeche: "), 0, 5);
        gridpane.add(area, 2, 5);

        gridpane.add(new Label("Dichte: "), 0, 6);
        gridpane.add(density, 2, 6);

        gridpane.add(countryField, 0, 7);
        gridpane.add(capitalField, 1, 7);
        gridpane.add(populationField, 2, 7);
        gridpane.add(areaField, 3, 7);

        gridpane.add(add, 0, 8);
        gridpane.add(delete, 1, 8);

        Scene scene = new Scene(gridpane, 500, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("L\u00e4nder-Informationen");
        primaryStage.show();

    }

    public String formatter(long zahl)
    {

        DecimalFormat nf = new DecimalFormat();

        String toRet = "";
        if (zahl >= 1000000 && zahl <= 9999999)
        {
            long temp = (zahl / 100000) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000000) + 1;
                toRet = Long.toString(temp);
                toRet += " Mill.";
            }
            else
            {
                temp = (zahl / 1000000);
                toRet = Long.toString(temp);
                toRet += " Mill.";
            }

        }
        else if (zahl >= 10000000 && zahl <= 99999999)
        {
            long temp = (zahl / 100000) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000000) + 1;
                toRet = Long.toString(temp);
                toRet += " Mill.";
            }
            else
            {
                temp = (zahl / 1000000);
                toRet = Long.toString(temp);
                toRet += " Mill.";
            }

        }

        else if (zahl >= 100000000 && zahl <= 999999999)
        {
            long temp = (zahl / 100000) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000000) + 1;
                toRet = Long.toString(temp);
                toRet += " Mill.";
            }
            else
            {
                temp = (zahl / 1000000);
                toRet = Long.toString(temp);
                toRet += " Mill.";
            }

        }
        else if (zahl >= 1000000000)
        {
            long temp = (zahl / 1000000) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000000) + 1;
                toRet = nf.format(temp);
                toRet += " Mill.";
            }
            else
            {
                temp = (zahl / 1000000);
                toRet = nf.format(temp);
                toRet += " Mill.";
            }

        }

        else if (zahl >= 1000 && zahl <= 9999)
        {
            long temp = (zahl / 100) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000) + 1;
                toRet = Long.toString(temp);
                toRet += ".000";
            }
            else
            {
                temp = (zahl / 1000);
                toRet = Long.toString(temp);
                toRet += ".000";
            }

        }
        else if (zahl >= 10000 && zahl <= 99999)
        {
            long temp = (zahl / 100) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000) + 1;
                toRet = Long.toString(temp);
                toRet += ".000";
            }
            else
            {
                temp = (zahl / 1000);
                toRet = Long.toString(temp);
                toRet += ".000";
            }

        }
        else if (zahl >= 100000 && zahl <= 999999)
        {
            long temp = (zahl / 100) % 10;
            if (temp >= 5)
            {
                temp = (zahl / 1000) + 1;
                toRet = Long.toString(temp);
                toRet += ".000";
            }
            else
            {
                temp = (zahl / 1000);
                toRet = Long.toString(temp);
                toRet += ".000";
            }

        }
        else
        {
            toRet = nf.format(zahl);
        }

        return toRet;
    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
