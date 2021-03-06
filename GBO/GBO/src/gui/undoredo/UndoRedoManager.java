package gui.undoredo;

import java.util.ArrayList;
import java.util.List;

public class UndoRedoManager
{
    private List<UndoableRedoableAction> actions;

    private int currentPosition;

    public UndoRedoManager()
    {
        actions = new ArrayList<>();
        currentPosition = 0;
    }

    public void addAction(UndoableRedoableAction action)
    {
        for (int i = actions.size() - 1; i >= currentPosition; i--)
        {
            actions.remove(i);
        }
        actions.add(action);
        currentPosition++;
    }

    public boolean canUndo()
    {
        return currentPosition > 0;
    }

    public void undo()
    {
        if (canUndo())
        {
            currentPosition--;
            actions.get(currentPosition).undo();
        }
    }

    public boolean canRedo()
    {
        return currentPosition < actions.size();
    }

    public void redo()
    {
        if (canRedo())
        {
            actions.get(currentPosition).redo();
            currentPosition++;
        }
    }

    public static void main(String[] args)
    {
        UndoRedoManager manager = new UndoRedoManager();
        for (int i = 1; i <= 10; i++)
        {
            manager.addAction(new SampleAction("action" + i));
        }
        for (int i = 1; i <= 5; i++)
        {
            manager.redo();
        }
        for (int i = 1; i <= 15; i++)
        {
            manager.undo();
        }
        for (int i = 1; i <= 15; i++)
        {
            manager.redo();
        }
        for (int i = 1; i <= 5; i++)
        {
            manager.undo();
        }
        manager.addAction(new SampleAction("new action" + 1));
        manager.addAction(new SampleAction("new action" + 2));
        for (int i = 1; i <= 15; i++)
        {
            manager.undo();
        }
        for (int i = 1; i <= 15; i++)
        {
            manager.redo();
        }
    }
}

class SampleAction implements UndoableRedoableAction
{
    private String name;

    public SampleAction(String name)
    {
        super();
        this.name = name;
    }

    @Override
    public void undo()
    {
        System.out.println("undo " + name);
    }

    @Override
    public void redo()
    {
        System.out.println("redo " + name);
    }

}
