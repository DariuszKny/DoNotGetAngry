package learn.board;

import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

public class Field extends ImageView {

    String redPawn1 = getClass().getResource("/Red_Pawn.png").toString();
    String greenPawn1 = getClass().getResource("/Green_Pawn.png").toString();
    String emptyField = getClass().getResource("/empty.png").toString();
    String passChoice = getClass().getResource("/End_Turn.png").toString();
    String diceField = getClass().getResource("/Dice_Roll_1.png").toString();

    private GameController gameController;
    private int column;
    private int row;
    private FieldState fieldState;

    public Field(String url, int column, int row, GameController gameController,GridPane grid) {
        super(url);
        this.fieldState = checkFieldState(url);
        this.gameController = gameController;
        this.column = column;
        this.row = row;

        setOnMouseClicked(event -> gameController.handleOnMouseClicked(this,grid));
    }

    private FieldState checkFieldState(String url) {
        if (url.equals(redPawn1)) {
            return FieldState.RED;
        } else if (url.equals(greenPawn1)) {
            return FieldState.GREEN;
        } else if (url.equals(passChoice)) {
            return FieldState.PASS_MOVE;
        } else if (url.equals(diceField)) {
            return FieldState.DICE;
        } else {
            return FieldState.EMPTY;
        }
    }

    public String getRedPawn1() {
        return redPawn1;
    }

    public String getGreenPawn1() {
        return greenPawn1;
    }

    public String getEmptyField() {
        return emptyField;
    }

    public GameController getGameController() {
        return gameController;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public FieldState getFieldState() {
        return fieldState;
    }

    public void setFieldState(FieldState fieldState) {
        this.fieldState = fieldState;
    }


}

