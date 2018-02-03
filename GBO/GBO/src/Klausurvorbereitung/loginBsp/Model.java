package Klausurvorbereitung.loginBsp;

import java.util.HashMap;

public class Model
{
    private HashMap<String, String> userList;

    public Model()
    {
        userList = new HashMap<>();
        userList.put("Tobias", "test");
        userList.put("Naddy", "sweety");
    }

    public boolean isOk(String name, String password)
    {
        return password.equals(userList.get(name));
    }

}
