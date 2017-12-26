package gui.jan.sinus;

import java.util.ArrayList;

public class SinusModel
{

    private ArrayList<double[]> data = new ArrayList<double[]>();

    public SinusModel()
    {

        for (double i = -20; i < 20.1; i += 0.1)
        {

            data.add(new double[]
            { i, Math.sin(i) });

        }
    }

    public ArrayList<double[]> getData()
    {
        return data;
    }

    public void aktualisierData(double zoom, double amplitude, double frequenzy, double phase)
    {
        data.clear();
        for (double i = -zoom; i < zoom + 0.1; i += 0.1)
        {
            double[] temp =
            { i, amplitude * Math.sin(frequenzy * i + phase) };
            data.add(temp);

        }

    }

}
