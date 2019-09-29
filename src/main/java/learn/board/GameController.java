package learn.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import learn.GreenFieldMap;

import static learn.board.FieldState.EMPTY;
import static learn.board.RollTheDice.rollTheDice;

public class GameController {

    private Map<Coordinates, Field> fields = new HashMap<>();

    public void startField(GridPane grid) {


        Field startDice = new Field(getClass().getResource("/DICEROLL1.png").toString(), 10, 2, this, grid);
        grid.add(startDice, 10, 2, 1, 1);


        Field field1 = new Field(getClass().getResource("/REDPAWN1.png").toString(), 0, 8, this, grid);
        grid.add(field1, 0, 8, 1, 1);
        Field field2 = new Field(getClass().getResource("/REDPAWN1.png").toString(), 1, 8, this, grid);
        grid.add(field2, 1, 8, 1, 1);
        Field field3 = new Field(getClass().getResource("/REDPAWN1.png").toString(), 2, 8, this, grid);
        grid.add(field3, 2, 8, 1, 1);

        Field green1 = new Field(getClass().getResource("/GREENPAWN2.png").toString(), 8, 8, this, grid);
        grid.add(green1, 8, 8, 1, 1);
        Field green2 = new Field(getClass().getResource("/GREENPAWN2.png").toString(), 9, 8, this, grid);
        grid.add(green2, 9, 8, 1, 1);
        Field green3 = new Field(getClass().getResource("/GREENPAWN2.png").toString(), 10, 8, this, grid);
        grid.add(green3, 10, 8, 1, 1);
    }


    public void addField(Coordinates coordinates, Field field) {
        fields.put(coordinates, field);

    }


    boolean diceRolled = false;
    boolean movePawn = false;
    int rolledDice = 0;


    RedFieldMap redFieldMap = new RedFieldMap();
    ArrayList<Coordinates> redMap = redFieldMap.loadRedMap();

    GreenFieldMap greenFieldMap = new GreenFieldMap();
    ArrayList<Coordinates> greenMap = greenFieldMap.loadGreenMap();

    int redPawnsOnFinish = 0;
    int greenPawnsOnFinish = 0;

    public void handleOnMouseClicked(Field field, GridPane grid) {


        System.out.println("Clicked element col " + field.getColumn() + " row " + field.getRow() + " state " + field.getFieldState());

        if (field.getFieldState() == FieldState.DICE && !diceRolled) {
            rolledDice = rollTheDice();


            System.out.println("wynik rzutu kostką = " + rolledDice);
            if (rolledDice == 1) {
                field.setImage(new Image(getClass().getResource("/DICEROLL1.png").toString()));
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

        if (diceRolled) {
            System.out.println("DICE IS ROLLED");
        } else {
            System.out.println("Please roll a DICE!!!");
        }


        if (diceRolled && field.getFieldState() == FieldState.RED) {


            int lol = redMap.indexOf(new Coordinates(field.getColumn(), field.getRow()));
            System.out.println("indeks wybranego pionka : " + lol);
            int movedIndex = lol + rolledDice;
            System.out.println("indeks nowego pionka " + movedIndex);


            if (movedIndex <= redMap.size() - 1) {

                Coordinates coordinates = redMap.get(movedIndex);


                int column = coordinates.getCol();
                int row = coordinates.getRow();
                System.out.println(" coordynate pionka col: " + column + "row : " + row + " moved index = " + movedIndex);


                Field fieldRed = new Field((getClass().getResource("/REDPAWN1.png").toString()), column, row, this, grid);
                field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                grid.add(fieldRed, column, row, 1, 1);

                if (movedIndex >= redMap.size() - 3 + redPawnsOnFinish) {
                    redPawnsOnFinish++;
                    redMap.remove(movedIndex);
                    fieldRed.setFieldState(EMPTY);
                    for (Coordinates x : redMap) {
                        System.out.println(redMap.indexOf(x));
                    }
                }

                diceRolled = false;

            } else {
                System.out.println("ERROR - Nie prawidłowy ruch - rzuć kostką jeszcze raz");
                diceRolled = false;
            }
        }


        if (diceRolled && field.getFieldState() == FieldState.GREEN) {



            int lol = greenMap.indexOf(new Coordinates(field.getColumn(), field.getRow()));
            System.out.println("indeks wybranego pionka : " + lol);
            int movedIndex = lol + rolledDice;
            System.out.println("indeks nowego pionka " + movedIndex);

            if (movedIndex <= greenMap.size() - 1) {

                Coordinates coordinates = greenMap.get(movedIndex);

                int column = coordinates.getCol();
                int row = coordinates.getRow();
                System.out.println(" coordynate pionka col: " + column + "row : " + row);


                Field greenField = new Field((getClass().getResource("/GREENPAWN2.png").toString()), column, row, this, grid);

                if (movedIndex >= 35) {
                    greenField.setFieldState(EMPTY);
                }


                field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                grid.add(greenField, column, row, 1, 1);


                if (movedIndex >= redMap.size() - 3 + greenPawnsOnFinish) {
                    greenPawnsOnFinish++;
                    greenMap.remove(movedIndex);
                    greenField.setFieldState(EMPTY);
                    for (Coordinates x : redMap) {
                        System.out.println(redMap.indexOf(x));
                    }
                }


                diceRolled = false;

            } else {
                System.out.println("ERROR - Nie prawidłowy ruch - rzuć kostką jeszcze raz");
                diceRolled = false;
            }


        }


    }
}





