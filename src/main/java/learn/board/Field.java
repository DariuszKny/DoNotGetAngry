package learn.board;

import javafx.scene.image.ImageView;

public class Field extends ImageView {

    String redPawn1 = getClass().getResource("/REDPAWN1.png").toString();
    String greenPawn1 = getClass().getResource("/GREENPAWN1.png").toString();
    String emptyField = getClass().getResource("/DICEROLL1.png").toString();

    private GameController gameController;
    private int column;
    private int row;
    private FieldState fieldState;

    public Field(String url, int column, int row, GameController gameController) {
        super(url);
        this.fieldState = checkFieldState(url);
        this.gameController = gameController;
        this.column = column;
        this.row = row;

        setOnMouseClicked(event -> gameController.handleOnMouseClicked(this));
    }

    private FieldState checkFieldState(String url) {
        if(url.equals(redPawn1)){
            return FieldState.RED;
        }
        else if(url.equals(greenPawn1)){
            return FieldState.GREEN;
        }
        else{
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

