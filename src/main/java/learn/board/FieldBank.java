package learn.board;

import javafx.scene.layout.GridPane;


public class FieldBank {


    public Field fieldOfNoMove(GameController gameController, GridPane grid) {
        String emptyField = getClass().getResource("/End_Turn.png").toString();
        Field fieldOfNoMove = new Field(emptyField, 8, 2, gameController, grid);
        return fieldOfNoMove;
    }
    public Field fieldOfStartDice(GameController gameController, GridPane grid) {
        String diceField = getClass().getResource("/Dice_Roll_1.png").toString();
        Field fieldOfNoStartDice = new Field(diceField, 10, 2, gameController, grid);
        return fieldOfNoStartDice;
    }
    public Field fieldOfRedPawn0(GameController gameController, GridPane grid) {
        String diceField = getClass().getResource("/Red_Pawn.png").toString();
        Field fieldOfNoStartDice = new Field(diceField, 0, 8, gameController, grid);
        return fieldOfNoStartDice;
    }
    public Field fieldOfRedPawn1(GameController gameController, GridPane grid) {
        String fieldOfRedPawn2String = getClass().getResource("/Red_Pawn.png").toString();
        Field fieldOfRedPawn2 = new Field(fieldOfRedPawn2String, 1, 8, gameController, grid);
        return fieldOfRedPawn2;
    }
    public Field fieldOfRedPawn2(GameController gameController, GridPane grid) {
        String fieldOfRedPawn3String = getClass().getResource("/Red_Pawn.png").toString();
        Field fieldOfRedPawn3 = new Field(fieldOfRedPawn3String, 2, 8, gameController, grid);
        return fieldOfRedPawn3;
    }
    public Field fieldOfGreenPawn0(GameController gameController, GridPane grid) {
        String fieldOfGreenPawn0String = getClass().getResource("/Green_Pawn.png").toString();
        Field fieldOfGreenPawn0 = new Field(fieldOfGreenPawn0String, 8, 8, gameController, grid);
        return fieldOfGreenPawn0;
    }
    public Field fieldOfGreenPawn1(GameController gameController, GridPane grid) {
        String fieldOfGreenPawn1String = getClass().getResource("/Green_Pawn.png").toString();
        Field fieldOfGreenPawn1 = new Field(fieldOfGreenPawn1String, 9, 8, gameController, grid);
        return fieldOfGreenPawn1;
    }
    public Field fieldOfGreenPawn2(GameController gameController, GridPane grid) {
        String fieldOfGreenPawn2String = getClass().getResource("/Green_Pawn.png").toString();
        Field fieldOfGreenPawn2 = new Field(fieldOfGreenPawn2String, 10, 8, gameController, grid);
        return fieldOfGreenPawn2;
    }




}
