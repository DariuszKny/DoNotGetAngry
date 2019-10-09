package learn.board;

import javafx.scene.layout.GridPane;

public class TurnChanger  {

    public void setTurnChangeGreen(GameController gameController, GridPane grid){
        Field GreenTurn = new Field(("/Green_Turn.png"),9,2,gameController,grid);
        grid.add(GreenTurn, GreenTurn.getColumn(), GreenTurn.getRow());
    }
    public void setTurnChangeRed(GameController gameController, GridPane grid){
        Field RedTurn = new Field(("Red_Turn.png"),9,2,gameController,grid);
        grid.add(RedTurn, RedTurn.getColumn(), RedTurn.getRow());
    }
}
