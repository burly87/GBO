package gui.mvp.login;

import static org.junit.Assert.*;
import org.junit.*;

public class PresenterTest
{
    private Presenter presenter;
    private MockModel model;
    private MockView view;
    
    @Before
    public void init()
    {
        presenter = new Presenter();
        model = new MockModel();
        view = new MockView(presenter);
        presenter.setModel(model);
        presenter.setView(view);
    }

    @Test
    public void testMissingInput()
    {
        presenter.login("", "abc");
        assertTrue(model.getOkayCalls() == 0 &&
                   view.getResetInputCalls() == 0 &&
                   view.getShowInputErrorCalls() == 1 &&
                   view.getShowLoginErrorCalls() == 0 &&
                   view.getShowOkayMessageCalls() == 0);
    }

    @Test
    public void testBadInput()
    {
        model.setReturnValue(false);
        presenter.login("abc", "def");
        assertTrue(model.getOkayCalls() == 1 &&
                   view.getResetInputCalls() == 0 &&
                   view.getShowInputErrorCalls() == 0 &&
                   view.getShowLoginErrorCalls() == 1 &&
                   view.getShowOkayMessageCalls() == 0);
    }

    @Test
    public void testCorrectInput()
    {
        model.setReturnValue(true);
        presenter.login("abc", "def");
        assertTrue(model.getOkayCalls() == 1 &&
                   view.getResetInputCalls() == 1 &&
                   view.getShowInputErrorCalls() == 0 &&
                   view.getShowLoginErrorCalls() == 0 &&
                   view.getShowOkayMessageCalls() == 1);
    }
}
