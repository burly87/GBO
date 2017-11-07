package gui.Ubeung4;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;

/*
4. Aufgabe: Wenn Sie das Beispiel aus der Vorlesung zu GridPane größer ziehen, wird das Gitter
nicht größer.
a) Finden Sie heraus, was Sie tun müssen, damit das Gitter wächst, wenn das Fenster größer wird!
b) Entfernen Sie die Anweisungen zur Festlegung der maximalen Breite und Höhe der Buttons! Wenn
Sie nun das Fenster größer ziehen, können Sie sehen, an welcher Stelle innerhalb eines Gitterfelds
sich die Buttons jeweils befinden. Veranlassen Sie, dass die unterschiedlichen Buttons an
unterschiedlichen Positionen ihres jeweiligen Gitterfeldes zu liegen kommen!
 */

public class Aufgabe4 extends Application
{

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        GridPane root = new GridPane();

        // just Gaps etc.
        root.setVgap(10);
        root.setHgap(10);
        Insets ins = new Insets(10);
        root.setPadding(ins);

        // Aufgabenteil a)
        ColumnConstraints colum1 = new ColumnConstraints(100, 100, Double.MAX_VALUE);
        colum1.setHgrow(Priority.ALWAYS);
        root.getColumnConstraints().add(colum1);

        RowConstraints row1 = new RowConstraints(100, 100, Double.MAX_VALUE);
        row1.setVgrow(Priority.ALWAYS);
        root.getRowConstraints().add(row1);

        /* generieren von Buttons */
        for (int i = 1; i <= 5; i++)
        {
            for (int j = 1; j <= 5; j++)
            {
                if (i < 3 || j < 3)
                {
                    Button b = new Button("Button " + i + "/" + j);
                    b.setAlignment(Pos.TOP_CENTER);// grad keine Lust mehr XD
                    System.out.println(b.getAlignment());
                    root.add(b, i - 1, j - 1);
                }
            }
        }

        // Aufgabenteil b)
        Button b;
        b = new Button("Button 6/*");
        // b.setMaxHeight(Double.MAX_VALUE);
        root.add(b, 5, 0, 1, 4);

        b = new Button("Button */6");
        // b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 0, 5, 3, 1);

        b = new Button("Button 3/3");
        // b.setMaxHeight(Double.MAX_VALUE);
        // b.setMaxWidth(Double.MAX_VALUE);
        root.add(b, 2, 2, 3, 3);
        /* END: generieren von Buttons */

        root.setGridLinesVisible(true);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Aufgabe 4");
        primaryStage.show();

    }

    public static void main(String[] args)
    {
        launch(args);
    }

}
