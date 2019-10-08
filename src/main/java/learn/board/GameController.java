package learn.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import static learn.board.FieldState.EMPTY;
import static learn.board.RollTheDice.rollTheDice;

public class GameController {

    private boolean diceRolled = false;
    private boolean redMove = false;
    private boolean greenMove = true;
    private int rolledDice = 0;
    private int redPawnsOnFinish = 0;
    private int greenPawnsOnFinish = 0;

    FieldBank fieldBank = new FieldBank();
    TurnChanger turnChanger = new TurnChanger();

    private Map<Coordinates, Field> fields = new HashMap<>();

    public void addFieldMap(GridPane grid) {
        fields.put(new Coordinates(0, 8), fieldBank.fieldOfRedPawn0(this, grid));
        fields.put(new Coordinates(1, 8), fieldBank.fieldOfRedPawn1(this, grid));
        fields.put(new Coordinates(2, 8), fieldBank.fieldOfRedPawn2(this, grid));
        fields.put(new Coordinates(8, 8), fieldBank.fieldOfGreenPawn0(this, grid));
        fields.put(new Coordinates(9, 8), fieldBank.fieldOfGreenPawn1(this, grid));
        fields.put(new Coordinates(10, 8), fieldBank.fieldOfGreenPawn2(this, grid));
    }
    RedFieldMap redFieldMap = new RedFieldMap();
    ArrayList<Coordinates> redMap = redFieldMap.loadRedMap();
    GreenFieldMap greenFieldMap = new GreenFieldMap();
    ArrayList<Coordinates> greenMap = greenFieldMap.loadGreenMap();

    public void handleOnMouseClicked(Field field, GridPane grid) {

        if (field.getFieldState() == FieldState.PASS_MOVE && diceRolled ) {
            diceRolled = false;
            if(greenMove && !redMove){
                turnChanger.setTurnChangeRed(this, grid);
                redMove = true;
                greenMove = false;
            } else {
                turnChanger.setTurnChangeGreen(this, grid);
                redMove = false;
                greenMove = true;
            }
        }
        if (diceRolled && field.getFieldState() == FieldState.DICE) {
            ErrorBox.display("Dice is already rolled", "Dice is already rolled, Please choose your pawn, or skip move");
        }
        if (field.getFieldState() == FieldState.DICE && !diceRolled ) {
            rolledDice = rollTheDice();
            if (rolledDice == 1) {
                field.setImage(new Image(getClass().getResource("/Dice_Roll_1.png").toString()));
                field.setFieldState(FieldState.DICE);
                diceRolled = true;
            } else if (rolledDice == 2) {
                field.setImage(new Image(getClass().getResource("/DICEROLL2.png").toString()));
                field.setFieldState(FieldState.DICE);
                diceRolled = true;
            } else if (rolledDice == 3) {
                field.setImage(new Image(getClass().getResource("/DICEROLL3.png").toString()));
                field.setFieldState(FieldState.DICE);
                diceRolled = true;
            } else if (rolledDice == 4) {
                field.setImage(new Image(getClass().getResource("/DICEROLL4.png").toString()));
                field.setFieldState(FieldState.DICE);
                diceRolled = true;
            } else if (rolledDice == 5) {
                field.setImage(new Image(getClass().getResource("/DICEROLL5.png").toString()));
                field.setFieldState(FieldState.DICE);
                diceRolled = true;
            } else if (rolledDice == 6) {
                field.setImage(new Image(getClass().getResource("/DICEROLL6.png").toString()));
                field.setFieldState(FieldState.DICE);
                diceRolled = true;
            }
        }
        if (!diceRolled && field.getFieldState() == FieldState.RED) {
            ErrorBox.display("Roll the dice!", "Please roll the dice first!");
        }
        if (diceRolled && field.getFieldState() == FieldState.RED && redMove) {

            int IndexOfChoosenPawn = redMap.indexOf(new Coordinates(field.getColumn(), field.getRow()));
            int movedIndex;

            if(IndexOfChoosenPawn <= 2 && rolledDice==6){
                movedIndex = 3;
            } else if(IndexOfChoosenPawn<=2 && rolledDice<6) {
                movedIndex = IndexOfChoosenPawn;
            }   else {
                movedIndex = IndexOfChoosenPawn + rolledDice;
            }

            if (movedIndex <= redMap.size() - 1) {

                Coordinates coordinates = redMap.get(movedIndex);
                int column = coordinates.getCol();
                int row = coordinates.getRow();

                Field fieldRed = new Field((getClass().getResource("/Red_Pawn.png").toString()), column, row, this, grid);
                Field greenField = new Field((getClass().getResource("/Green_Pawn.png").toString()), column, row, this, grid);
                Field fieldToGo = fields.get(coordinates);

                if (!fields.containsKey(new Coordinates(column, row)) ) {

                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));
                    System.out.println(" removed col: " + field.getColumn() + "row" + field.getRow());
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeGreen(this, grid);
                    redMove = false;
                    greenMove = true;

                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(0, 8))) {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(1, 8))) {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(2, 8))) {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(8, 8))) {
                    fieldToGo.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));

                    grid.add(new Field((getClass().getResource("/Green_Pawn.png").toString()), 8, 8, this, grid), 8,8,1,1);
                    fields.put(new Coordinates(8, 8), (new Field((getClass().getResource("/Green_Pawn.png").toString()), 8, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeGreen(this, grid);
                    redMove = false;
                    greenMove = true;

                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(9, 8))) {
                    fieldToGo.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/Green_Pawn.png").toString()), 9, 8, this, grid), 9,8,1,1);
                    fields.put(new Coordinates(9, 8), (new Field((getClass().getResource("/Green_Pawn.png").toString()), 9, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeGreen(this, grid);
                    redMove = false;
                    greenMove = true;

                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(10, 8))){
                    fieldToGo.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/Green_Pawn.png").toString()), 10, 8, this, grid), 10,8,1,1);
                    fields.put(new Coordinates(10, 8), (new Field((getClass().getResource("/Green_Pawn.png").toString()), 10, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeGreen(this, grid);
                    redMove = false;
                    greenMove = true;

                } else {
                ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
            }
                if (movedIndex >= redMap.size() - 3 + redPawnsOnFinish) {
                    redPawnsOnFinish++;
                    redMap.remove(movedIndex);
                    fieldRed.setFieldState(EMPTY);
                }
            } else {
                ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                }

        }
        if (!diceRolled && field.getFieldState() == FieldState.GREEN) {
            ErrorBox.display("Roll the dice!", "Please roll the dice first!");
        }
        if (diceRolled && field.getFieldState() == FieldState.GREEN && greenMove) {

            int lol = greenMap.indexOf(new Coordinates(field.getColumn(), field.getRow()));
            int movedIndex;

            if(lol <= 2 && rolledDice==6){
                movedIndex = 3;
            } else if(lol<=2 && rolledDice<6) {
                movedIndex = lol;
            }   else {
                movedIndex = lol + rolledDice;
            }
            if (movedIndex <= greenMap.size() - 1) {

                Coordinates coordinates = greenMap.get(movedIndex);
                int column = coordinates.getCol();
                int row = coordinates.getRow();
                Field greenField = new Field((getClass().getResource("/Green_Pawn.png").toString()), column, row, this, grid);
                Field fieldToGo = fields.get(coordinates);

                if (!fields.containsKey(new Coordinates(column, row))) {

                    grid.add(greenField, column, row, 1, 1);

                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));
                    System.out.println(" removed col: " + field.getColumn() + "row" + field.getRow());
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeRed(this, grid);
                    redMove = true;
                    greenMove = false;
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(0, 8))) {

                    fieldToGo.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    grid.add(greenField, column, row, 1, 1);
                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));

                    grid.add(new Field((getClass().getResource("/Red_Pawn.png").toString()), 0, 8, this, grid), 0,8,1,1);
                    fields.put(new Coordinates(0, 8), (new Field((getClass().getResource("/Red_Pawn.png").toString()), 0, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeRed(this, grid);
                    redMove = true;
                    greenMove = false;

                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(1, 8))) {

                    fieldToGo.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    grid.add(greenField, column, row, 1, 1);
                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));

                    grid.add(new Field((getClass().getResource("/Red_Pawn.png").toString()), 1, 8, this, grid), 1,8,1,1);
                    fields.put(new Coordinates(1, 8), (new Field((getClass().getResource("/Red_Pawn.png").toString()), 1, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeRed(this, grid);
                    redMove = true;
                    greenMove = false;
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(2, 8))) {

                    fieldToGo.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    grid.add(greenField, column, row, 1, 1);
                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));

                    grid.add(new Field((getClass().getResource("/Red_Pawn.png").toString()), 2, 8, this, grid), 2,8,1,1);
                    fields.put(new Coordinates(2, 8), (new Field((getClass().getResource("/Red_Pawn.png").toString()), 2, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/Empty.png").toString()));
                    diceRolled = false;

                    turnChanger.setTurnChangeRed(this, grid);
                    redMove = true;
                    greenMove = false;
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(8, 8))) {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(9, 8))) {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                } else if (fields.containsKey(new Coordinates(column, row)) && fieldToGo.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(10, 8))) {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                } else {
                    ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
                }
                if (movedIndex >= greenMap.size() - 3 + greenPawnsOnFinish) {
                    greenPawnsOnFinish++;
                    greenMap.remove(movedIndex);
                    greenField.setFieldState(EMPTY);
                }
            } else {
                ErrorBox.display("Wrong Move", "Please try to choose enother pawn or skip move");
            }
        }
        if(greenPawnsOnFinish==3) {
            EndGame.endGame("Game is over", "The winner is GREEN");
        } else if(redPawnsOnFinish==3) {
            EndGame.endGame("Game is over", "The winner is RED");
        }
    }
}





