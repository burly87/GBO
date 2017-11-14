package gui.Ubeung4.calculator;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

public class Calculator extends Application
{

    private TextField ausgabe = new TextField();

    private Button clear = new Button("CLEAR");

    private Button delete = new Button("DELETE");

    private Button punkt = new Button(".");

    private Button is = new Button("=");

    private Button klammerAuf = new Button("(");

    private Button klammerZu = new Button(")");

    private String text = "";

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        // just Gaps etc.
        root.setVgap(10);
        root.setHgap(10);
        Insets ins = new Insets(10);
        root.setPadding(ins);

        ColumnConstraints colum1 = new ColumnConstraints(50, 50, Double.MAX_VALUE);
        colum1.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(colum1);

        RowConstraints row1 = new RowConstraints(40, 40, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(row1);

        /* Buttons */

        ausgabe.setEditable(false);

        ausgabe.setMaxWidth(Double.MAX_VALUE);
        ausgabe.setMaxHeight(Double.MAX_VALUE);

        clear.setMaxWidth(Double.MAX_VALUE);
        clear.setMaxHeight(Double.MAX_VALUE);

        delete.setMaxWidth(Double.MAX_VALUE);
        delete.setMaxHeight(Double.MAX_VALUE);

        punkt.setMaxWidth(Double.MAX_VALUE);
        punkt.setMaxHeight(Double.MAX_VALUE);

        is.setMaxHeight(Double.MAX_VALUE);
        is.setMaxWidth(Double.MAX_VALUE);

        klammerAuf.setMaxWidth(Double.MAX_VALUE);
        klammerAuf.setMaxHeight(Double.MAX_VALUE);

        klammerZu.setMaxWidth(Double.MAX_VALUE);
        klammerZu.setMaxHeight(Double.MAX_VALUE);

        root.add(ausgabe, 0, 0, 4, 1);
        root.add(clear, 0, 1, 2, 1);// child, column, row, colspan, rowspan
        root.add(delete, 2, 1, 2, 1);
        root.add(punkt, 0, 2);
        root.add(is, 1, 2);
        root.add(klammerAuf, 2, 2);
        root.add(klammerZu, 3, 2);
        root.add(new Button("+"), 3, 3);
        root.add(new Button("-"), 3, 4);
        root.add(new Button("*"), 3, 5);
        root.add(new Button("/"), 3, 6);
        root.add(new Button("0"), 0, 6, 3, 1);

        /* widerlich */
        int help = 0;
        int help1 = 0;
        int help2 = 0;
        for (int i = 1; i < 10; i++)
        {
            Button zahlen = new Button("" + i);
            if (i <= 3)
            {
                root.add(zahlen, help, 5);
                help++;
            }

            if (i > 3 && i <= 6)
            {
                root.add(zahlen, help1, 4);
                help1++;
            }

            if (i > 6)
            {
                root.add(zahlen, help2, 3);
                help2++;
            }
        }

        // root.setGridLinesVisible(true);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Taschenrechner");
        primaryStage.show();
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
