package gui.jan.sinus;

import java.util.ArrayList;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

public class SinusView
{
    private SinusPresenter presenter;

    private VBox vbox;

    private Pane pane;

    private Label math;

    private Slider zoom, amplitude, frequency, phase;

    public SinusView(SinusPresenter presenter)
    {
        this.presenter = presenter;
    }

    public void initView()
    {
        vbox = new VBox();
        pane = new Pane();
        math = new Label("PLACEHOLDER");

        pane.setPrefSize(700, 500);
        vbox.getChildren().add(math);
        vbox.getChildren().add(pane);

        zoom = new Slider(10, 350, 20);
        amplitude = new Slider(-6, 6, 0);
        frequency = new Slider(0, 40, 10);
        phase = new Slider(-10, 10, 0);

        zoom.setId("zoom");
        amplitude.setId("amplitude");
        frequency.setId("frequency");
        phase.setId("phase");

        vbox.getChildren().add(new Label("zoom"));
        vbox.getChildren().add(zoom);
        vbox.getChildren().add(new Label("amplitude"));
        vbox.getChildren().add(amplitude);
        vbox.getChildren().add(new Label("frequency"));
        vbox.getChildren().add(frequency);
        vbox.getChildren().add(new Label("phase"));
        vbox.getChildren().add(phase);

        // presenter.handle(zoom.getValue(),amplitude.getValue(),frequency.getValue(),phase.getValue());

        zoom.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            presenter.handle((double) newValue, amplitude.getValue(), frequency.getValue(), phase.getValue());
        });

        amplitude.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            presenter.handle(zoom.getValue(), (double) newValue, frequency.getValue(), phase.getValue());
        });
        frequency.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            presenter.handle(zoom.getValue(), amplitude.getValue(), (double) newValue, phase.getValue());
        });
        phase.valueProperty().addListener((observable, oldValue, newValue) ->
        {
            presenter.handle(zoom.getValue(), amplitude.getValue(), frequency.getValue(), (double) newValue);
        });

        drawPane(pane, presenter.getData(), zoom.getValue());

    }

    public VBox getUI()
    {
        return vbox;
    }

    public void drawPane(Pane root, ArrayList<double[]> data, double zoomValue)
    {
        System.out.println(zoomValue);
        // Weltkoordinaten
        double translationX = 350;
        double translationY = 250;
        double scalingFactorX = 350 / zoomValue;
        double scalingFactorY = 100;

        // Setze das Koordinatensystem in Weltkoordinaten
        root.getChildren().add(new Line(-350 + translationX, 0 + translationY, 350 + translationX, 0 + translationY));
        root.getChildren().add(new Line(0 + translationX, -250 + translationY, 0 + translationX, 250 + translationY));

        // Jetzt brauchen wir ein lokales Koordiantensystem in den
        // Weltkoordinaten
        for (int i = 0; i < data.size() - 2; i++)
        {

            root.getChildren().add(new Line(data.get(i)[0] * scalingFactorX + translationX, data.get(i)[1] * scalingFactorY + translationY, data.get(i + 1)[0] * scalingFactorX + translationX, data.get(i + 1)[1] * scalingFactorY + translationY));

        }
        System.out.println((data.get(0)[0] * scalingFactorX) + " " + (data.get(0)[1] * scalingFactorY + translationY));

    }

    public void akutaliesieren()
    {
        pane.getChildren().clear();
        drawPane(pane, presenter.getData(), zoom.getValue());

    }

}
