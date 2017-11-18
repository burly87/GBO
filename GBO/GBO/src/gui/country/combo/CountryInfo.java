package gui.country.combo;

import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CountryInfo extends Application
{
    private static List<Country> list = new ArrayList<Country>();

    private ObservableList<Country> countrys = FXCollections.observableArrayList(list);

    private ComboBox<Country> cEnum = new ComboBox<>(countrys);

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        VBox vboxLeft = new VBox(5);
        VBox vboxRight = new VBox(5);
        root.add(new VBox(vboxLeft), 0, 2);
        root.add(new VBox(vboxRight), 1, 2);

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

        /* ComboBox anlegen mit entsprechendem Listener */
        cEnum.setId("countrySeletor");
        // cEnum.setValue(countrys.get(0));

        cEnum.setEditable(false);

        cEnum.setOnAction((e) ->
        {
            Country name = cEnum.getSelectionModel().getSelectedItem();
            cEnum.setPromptText(name.getName());
            countryOut.setText(name.getName());
            capitalOut.setText(name.getCapital());
            populationOut.setText("" + name.getPeople());
            areaOut.setText("" + name.getArea());
            densityOut.setText("" + (name.getPeople()) / (name.getArea()));
        });

        /* CheckBox */
        CheckBox checkBox = new CheckBox("exakte Angaben");
        checkBox.setId("exactValues");

        checkBox.setOnAction((e) ->
        {
            roundOff();
        });

        /* Zeichnen */
        root.getChildren().add(cEnum);
        root.add(checkBox, 0, 1);

        vboxLeft.getChildren().addAll(countryName, capital, population, area, density);
        vboxRight.getChildren().addAll(countryOut, capitalOut, populationOut, areaOut, densityOut);

        Scene scene = new Scene(root, 400, 250);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Länder-Informationen");
        primaryStage.show();

    }

    public void roundOff()
    {
        Country erg = cEnum.getSelectionModel().getSelectedItem();
        long rounded = erg.getPeople();

        if (rounded >= 999999)
        {
            rounded /= 1000000;
            System.out.println(rounded);
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
