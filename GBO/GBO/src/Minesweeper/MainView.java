package Minesweeper;

import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class MainView
{
    private Presenter presenter;

    private Pane root;

    private GridPane minesField;

    private VBox menue;

    public MainView(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void setPresenter(Presenter presenter)
    {
        this.presenter = presenter;
    }

    public void initView()
    {
        root = new GridPane();
        minesField = new GridPane();
        menue = new VBox();

        int minesCount = 10;

        // MinesField
        for (int i = 0; i < minesCount; i++)
        {
            for (int j = 0; j < minesCount; j++)
            {
                Button mine = new Button(" ");
                minesField.add(mine, j, i);
            }

        }

        root.getChildren().addAll(minesField, menue);

    }

    public Pane getUi()
    {
        return root;
    }

}
