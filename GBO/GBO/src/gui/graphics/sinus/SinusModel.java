package gui.graphics.sinus;

import java.util.ArrayList;

public class SinusModel
{

    private ArrayList<double[]> data;

    // Void Only
    public SinusModel()
    {
        data = new ArrayList<double[]>();

        for (float i = -10.0f; i < 10.1f; i += 0.1f)
        {
            data.add(new double[]
            { i, getY(i) });
        }
    }

    public double getY(double x)
    {
        return Math.sin(x);
    }

    public ArrayList<double[]> getData()
    {
        return data;
    }

}
