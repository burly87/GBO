package WS1516;

import java.util.ArrayList;
import java.util.List;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class View extends GridPane
{

    private ArrayList<CheckBox> cb;

    private Label max, total;

    private Presenter p;

    private double percentage;

    private double aktuell;

    private Pane right;

    public View()
    {
        this.aktuell = 0;
        this.percentage = 0;
    }

    public void init(List<String> itemNames, List<Double> itemWeights, double maxWeight)
    {
        BorderPane left = new BorderPane();

        VBox top = new VBox();
        max = new Label("Maximalgewicht: " + maxWeight + " kg");
        total = new Label("Gesamtgewicht: " + aktuell + " kg");
        top.getChildren().addAll(max, total);

        VBox center = new VBox();
        cb = new ArrayList<>();
        CheckBox c;

        for (int i = 0; i < itemNames.size(); i++)
        {
            c = new CheckBox(itemNames.get(i) + "(" + itemWeights.get(i) + " kg)");
            c.selectedProperty().addListener(new ChangeListener<Boolean>()
            {

                @Override
                public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue)
                {
                    updateTotal();
                    updateEnabled(maxWeight);
                    System.out.println(aktuell);
                    percentage = aktuell / maxWeight;
                    updateStatus();
                }
            });
            center.getChildren().add(c);
            cb.add(c);
        }

        right = new Pane();
        right.setRotate(180);
        right.setMinSize(80, 200);
        Rectangle border = new Rectangle(100, 200);
        border.setStroke(Color.BLUE);
        border.setFill(null);
        border.setStrokeWidth(4);
        right.getChildren().add(border);

        left.setTop(top);
        left.setCenter(center);
        this.add(left, 0, 0);
        this.add(right, 1, 0);
        this.setPadding(new Insets(10));
    }

    public void setPresenter(Presenter p)
    {
        this.p = p;
    }

    public void updateStatus()
    {
        right.getChildren().remove(1, right.getChildren().size());
        Rectangle status = new Rectangle(100, 200);
        if (percentage <= 1)
        {
            status.setHeight(percentage * 200);
        }
        status.setFill(Color.BLUE);
        right.getChildren().add(status);
    }

    public void updateTotal()
    {
        aktuell = 0;
        for (int i = 0; i < cb.size(); i++)
        {
            if (cb.get(i).isSelected())
            {
                aktuell += p.getWeights().get(i);
            }
        }
        total.setText("Gesamtgewicht: " + aktuell + " kg");
    }

    public void updateEnabled(double maxWeight)
    {
        for (int i = 0; i < cb.size(); i++)
        {
            if (p.getWeights().get(i) > maxWeight - aktuell && !cb.get(i).isSelected())
            {
                cb.get(i).setDisable(true);
            }
            else
            {
                cb.get(i).setDisable(false);
            }
        }
    }

}
