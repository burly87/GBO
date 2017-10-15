package gui.uebungen;

public interface Role1
{

    public void play();

}

class Hallo implements Role1
{
    public void play()
    {
        System.out.println("hallo");
    }

}

class ByeRole implements Role1
{
    public void play()
    {
        System.out.println("tschüss");
    }
}

class GeneralRole implements Role1
{
    private String message;

    public GeneralRole(String message)
    {
        this.message = message;
    }

    public void play()
    {
        System.out.println(message);
    }

}
