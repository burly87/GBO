package LoginBeispiel;

import java.util.HashMap;

public class Model {
	
	private HashMap<String, String> map;

	public Model()
	{
		map = new HashMap<>();
		map.put("Test", "fall");
	}
	
	public boolean isOK(String name,String pw) {
		return pw.equals(map.get(name));
				
	}
	
}
