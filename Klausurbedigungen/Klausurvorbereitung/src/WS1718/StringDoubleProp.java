package WS1718;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class StringDoubleProp
{

	private SimpleStringProperty s;
	private SimpleDoubleProperty d;
	
	public StringDoubleProp(String string, double e)
	{
		this.s = new SimpleStringProperty(string);
		this.d = new SimpleDoubleProperty(e);
	}
	public String getString()
	{
		return s.get();
	}
	public void setS(SimpleStringProperty s)
	{
		this.s = s;
	}
	public Double getDouble()
	{
		return d.get();
	}
	public void setD(SimpleDoubleProperty d)
	{
		this.d = d;
	}
	
	@Override
	public String toString()
	{
		return s + " - " + d;
	}
	
}
