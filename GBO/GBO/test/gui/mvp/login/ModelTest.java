package gui.mvp.login;

import static org.junit.Assert.*;
import org.junit.*;

public class ModelTest
{
    private Model model;
    
    @Before
    public void init()
    {
        model = new Model();
    }
    
    @Test
    public void testCorrectNameAndPassword()
    {
        assertTrue("Test f�r erfolgreiches Login", model.isOkay("wolf", "password4"));
    }

    
    @Test
    public void testWrongName()
    {
        assertFalse("Test f�r falschen Namen", model.isOkay("xxxwolf", "password4"));
    }
    
    @Test
    public void testWrongPassword()
    {
        assertFalse("Test f�r falsches Passwort", model.isOkay("wolf", "password1"));
    }
}
