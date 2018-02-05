package TabelViewPlayer;

public class Player
{
	private String vorName, nachName, position;
	private int games;

	public Player(String vorName, String nachName, String position, int games)
	{
		this.vorName = vorName;
		this.nachName = nachName;
		this.position = position;
		this.games = games;
	}

	public String getVorName()
	{
		return vorName;
	}

	public void setVorName(String vorName)
	{
		this.vorName = vorName;
	}

	public String getNachName()
	{
		return nachName;
	}

	public void setNachName(String nachName)
	{
		this.nachName = nachName;
	}

	public String getPosition()
	{
		return position;
	}

	public void setPosition(String position)
	{
		this.position = position;
	}

	public int getGames()
	{
		return games;
	}

	public void setGames(int games)
	{
		this.games = games;
	}

	@Override
	public String toString()
	{
		return vorName;
	}

}
