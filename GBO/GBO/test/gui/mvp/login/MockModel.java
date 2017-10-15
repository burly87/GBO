package gui.mvp.login;

public class MockModel extends Model
{
    private boolean returnValue;
    private int okayCalls;
    
    @Override
    public boolean isOkay(String loginName, String password)
    {
        okayCalls++;
        return returnValue;
    }

    public void setReturnValue(boolean b)
    {
        returnValue = b;
    }

    public int getOkayCalls()
    {
        return okayCalls;
    }
}
