package gui.graphics.sinus;

import java.util.ArrayList;

public class SinusPresenter
{

    private SinusView view;

    private SinusModel model;

    private double ampValue, frequValue, phaseValue, zoomValueX, zoomVlaueY;

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

    public void setAmpValue(double ampV)
    {
        this.ampValue = ampV;
    }

    public void setZoomValue(double reshapeX, double reshapeY)
    {
        this.zoomValueX = reshapeX;
        this.zoomVlaueY = reshapeY;
    }

    public void setPhaseValue(double phaseX)
    {
        this.phaseValue = phaseX;

    }

    public void setFrequValue(double reshapeX)
    {
        this.frequValue = reshapeX;
    }

    /* nur fuer dich leiber ASB */
    public double getZoomValueX()
    {
        return zoomValueX;
    }

    public double getZoomVlaueY()
    {
        return zoomVlaueY;
    }

    public SinusView getView()
    {
        return view;
    }

    public double getAmpValue()
    {
        return ampValue;
    }

    public double getFrequValue()
    {
        return frequValue;
    }

    public double getPhaseValue()
    {
        return phaseValue;
    }

}
