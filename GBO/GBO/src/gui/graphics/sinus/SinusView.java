package gui.graphics.sinus;

import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SinusView
{
    SinusPresenter presenter;

    SinusModel model;

    Pane coordSystemPane;

    GridPane sliderPane;

    Label resultLabel;

    public SinusView()
    {
        VBox root = new VBox();
        resultLabel = new Label("0.57* sin(2.09 * x)");
        coordSystemPane = new Pane();

        root.getChildren().addAll(resultLabel, coordSystemPane, sliderPane);

        Slider amp = new Slider();
        Slider frequ = new Slider();
        Slider phase = new Slider();
        Slider zoom = new Slider();

        Label ampLabel = new Label("Amplitude:");
        Label frequLabel = new Label("Frequenz:");
        Label phaseLabel = new Label("Phase:");
        Label zoomLabel = new Label("Zoom:");

        ampLabel.setFont(Font.font(20));
        frequLabel.setFont(Font.font(20));
        phaseLabel.setFont(Font.font(20));
        zoomLabel.setFont(Font.font(20));

        sliderPane.add(ampLabel, 0, 0);
        sliderPane.add(amp, 0, 1);
        sliderPane.add(frequLabel, 1, 0);
        sliderPane.add(frequ, 1, 1);
        sliderPane.add(phaseLabel, 2, 0);
        sliderPane.add(phase, 2, 0);
        sliderPane.add(zoomLabel, 3, 0);
        sliderPane.add(zoom, 3, 0);
    }

    public void setPresenter(SinusPresenter presenter)
    {
        this.presenter = presenter;
    }

}
