package gui.jan.sinus;

import java.util.ArrayList;

public class SinusPresenter
{
    private SinusView view;

    private SinusModel model;

    public SinusPresenter()
    {
    }

    public void setView(SinusView view)
    {
        this.view = view;
    }

    public void setModel(SinusModel model)
    {
        this.model = model;
    }

    public ArrayList<double[]> getData()
    {
        return model.getData();
    }

    public void handle(double value1, double value, double value2, double value3)
    {
        model.aktualisierData(value1, value, value2, value3);
        view.akutaliesieren();

    }

}
