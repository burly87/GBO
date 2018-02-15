package Date1502.TableView.ExtraDialogs;

import java.util.*;

public class UndoRedoManager
{
    private List<AnimalInterface> actions;
    private int currentPosition;

    public UndoRedoManager()
    {
        actions = new ArrayList<>();
        currentPosition = 0;
    }

    public void addAction(AnimalInterface action)
    {
        for(int i = actions.size() - 1; i >= currentPosition; i--)
        {
            actions.remove(i);
        }
        actions.add(action);
        currentPosition++;
    }
    
    public void undo()
    {
        if(currentPosition > 0)
        {
            currentPosition--;
            actions.get(currentPosition).undo();
        }
    }
    
    public void redo()
    {
        if(currentPosition < actions.size())
        {
            actions.get(currentPosition).redo();
            currentPosition++;
        }
    }
 
    
}
