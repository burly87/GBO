package gui.graphics.sinus;

import java.util.ArrayList;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;
import javafx.scene.text.Font;

public class SinusView
{
    private SinusPresenter presenter;

    private Pane coordSystemPane;

    private GridPane sliderPane;

    private VBox root;

    private Label resultLabel;

    private ArrayList<double[]> data;

    private double reshapeX = 20;

    private double reshapeY = 1;

    private double phaseX = 400;

    private double phaseY = 175;

    public SinusView(SinusPresenter sinusPresenter)
    {
        this.presenter = sinusPresenter;
    }

    public void setPresenter(SinusPresenter presenter)
    {
        this.presenter = presenter;
    }

    public void initView()
    {
        root = new VBox();
        resultLabel = new Label("0.57* sin(2.09 * x)");
        coordSystemPane = new Pane();
        sliderPane = new GridPane();

        Slider amp = new Slider(-100, 100, 0);
        Slider frequ = new Slider(0, 40, 5);
        Slider phase = new Slider(-10, 10, 0);
        Slider zoom = new Slider(0, 70, 0);

        amp.setPrefSize(600, 1);
        amp.setShowTickMarks(true);
        amp.setShowTickLabels(true);
        amp.setMajorTickUnit(20);

        frequ.setShowTickLabels(true);
        frequ.setShowTickMarks(true);
        frequ.setMajorTickUnit(5);

        phase.setShowTickLabels(true);
        phase.setShowTickMarks(true);
        phase.setMajorTickUnit(2);

        zoom.setShowTickLabels(true);
        zoom.setShowTickMarks(true);
        zoom.setMajorTickUnit(25);

        // Ids

        amp.setId("amplitude");
        frequ.setId("frequency");
        phase.setId("phase");
        zoom.setId("zoom");

        amp.valueProperty().addListener(new ChangeListener<Number>()
        {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                reset();
                reshapeY = (double) newValue;
                presenter.setAmpValue(reshapeY);
            }
        });

        frequ.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                reset();
                reshapeX = (double) newValue;
                presenter.setFrequValue(reshapeX);
            }
        });

        phase.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                reset();
                phaseX = (double) newValue * 10;
                presenter.setPhaseValue(phaseX);

            }
        });

        zoom.valueProperty().addListener(new ChangeListener<Number>()
        {

            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue)
            {
                reset();
                reshapeY = (double) newValue;
                reshapeX = (double) newValue;
                presenter.setZoomValue(reshapeX, reshapeY);
            }
        });

        // Lables
        Label ampLabel = new Label("Amplitude:"); // h\u00f6chsterPkt
        Label frequLabel = new Label("Frequenz:"); // stauchen/strecken
        Label phaseLabel = new Label("Phase:"); // verschieben des Ursprungs
        Label zoomLabel = new Label("Zoom:"); // ....

        ampLabel.setFont(Font.font(20));
        frequLabel.setFont(Font.font(20));
        phaseLabel.setFont(Font.font(20));
        zoomLabel.setFont(Font.font(20));

        // in Pane zeichnen
        sliderPane.add(ampLabel, 0, 0);
        sliderPane.add(amp, 1, 0);
        sliderPane.add(frequLabel, 0, 1);
        sliderPane.add(frequ, 1, 1);
        sliderPane.add(phaseLabel, 0, 2);
        sliderPane.add(phase, 1, 2);
        sliderPane.add(zoomLabel, 0, 3);
        sliderPane.add(zoom, 1, 3);

        data = presenter.getData();

        root.getChildren().addAll(resultLabel, coordSystemPane, sliderPane);
        drawPane();
    }

    public void drawPane()// Pane pane, SinusPresenter presenter
    {

        coordSystemPane.setPrefSize(root.getMaxWidth(), 350);
        coordSystemPane.getChildren().add(new Line(0, 175, 800, 175)); // X-Achse
        coordSystemPane.getChildren().add(new Line(400, 0, 400, 350));// Y-Achse
        for (int i = 0; i < data.size() - 2; i++)
        {
            // xStart, yStart, xEnd,yEnd
            coordSystemPane.getChildren().add(new Line(data.get(i)[0] * reshapeX + phaseX, data.get(i)[1] * (reshapeY) + phaseY, data.get(i + 1)[0] * reshapeX + phaseX, data.get(i + 1)[1] * (reshapeY) + phaseY));
        }
    }

    public Pane getUI()
    {
        return root;
    }

    public void reset()
    {
        coordSystemPane.getChildren().clear();
        drawPane();
    }

}
