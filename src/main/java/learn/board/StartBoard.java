package learn.board;

import javafx.scene.layout.GridPane;

public class StartBoard {

    FieldBank fieldBank = new FieldBank();

    public void startField(GameController gameController, GridPane grid) {

        for (int col = 0; col < 12; col++) {
            for (int row = 0; row < 12; row++) {
                Field field  = new Field(getClass().getResource("/Empty.png").toString(), col, row, gameController, grid);
                grid.add(field, col, row, 1, 1);
            }
        }
        Field fieldOfNoMove = fieldBank.fieldOfNoMove(gameController, grid);
        grid.add(fieldOfNoMove, fieldOfNoMove.getColumn(), fieldOfNoMove.getRow(), 1, 1);

        Field startDice = fieldBank.fieldOfStartDice(gameController, grid);
        grid.add(startDice, startDice.getColumn(), startDice.getRow(), 1, 1);

        Field redPawn0 = fieldBank.fieldOfRedPawn0(gameController, grid);
        grid.add(redPawn0, redPawn0.getColumn(), redPawn0.getRow(), 1, 1);

        Field redPawn1 = fieldBank.fieldOfRedPawn1(gameController, grid);
        grid.add(redPawn1, redPawn1.getColumn(), redPawn1.getRow(), 1, 1);

        Field redPawn2 = fieldBank.fieldOfRedPawn2(gameController, grid);
        grid.add(redPawn2, redPawn2.getColumn(), redPawn2.getRow(), 1, 1);

        Field greenPawn0 = fieldBank.fieldOfGreenPawn0(gameController, grid);
        grid.add(greenPawn0, greenPawn0.getColumn(), greenPawn0.getRow(), 1, 1);

        Field greenPawn1 = fieldBank.fieldOfGreenPawn1(gameController, grid);
        grid.add(greenPawn1, greenPawn1.getColumn(), greenPawn1.getRow(), 1, 1);

        Field greenPawn2 = fieldBank.fieldOfGreenPawn2(gameController, grid);
        grid.add(greenPawn2, greenPawn2.getColumn(), greenPawn2.getRow(), 1, 1);
    }
}
