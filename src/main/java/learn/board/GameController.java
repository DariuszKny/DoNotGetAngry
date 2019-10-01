package learn.board;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javafx.scene.image.Image;
import javafx.scene.layout.GridPane;
import learn.GreenFieldMap;

import static learn.board.FieldState.EMPTY;
import static learn.board.FieldState.RED;
import static learn.board.RollTheDice.rollTheDice;

public class GameController {

    private Map<Coordinates, Field> fields = new HashMap<>();

    public void startField(GridPane grid) {


        Field startDice = new Field(getClass().getResource("/DICEROLL1.png").toString(), 10, 2, this, grid);
        grid.add(startDice, 10, 2, 1, 1);


        Field field1 = new Field(getClass().getResource("/REDPAWN1.png").toString(), 0, 8, this, grid);
        grid.add(field1, 0, 8, 1, 1);
        fields.put(new Coordinates(0, 8), field1);

        Field field2 = new Field(getClass().getResource("/REDPAWN1.png").toString(), 1, 8, this, grid);
        grid.add(field2, 1, 8, 1, 1);
        fields.put(new Coordinates(1, 8), field2);

        Field field3 = new Field(getClass().getResource("/REDPAWN1.png").toString(), 2, 8, this, grid);
        grid.add(field3, 2, 8, 1, 1);
        fields.put(new Coordinates(2, 8), field3);

        Field green1 = new Field(getClass().getResource("/GREENPAWN2.png").toString(), 8, 8, this, grid);
        grid.add(green1, 8, 8, 1, 1);
        fields.put(new Coordinates(8, 8), green1);

        Field green2 = new Field(getClass().getResource("/GREENPAWN2.png").toString(), 9, 8, this, grid);
        grid.add(green2, 9, 8, 1, 1);
        fields.put(new Coordinates(9, 8), green2);

        Field green3 = new Field(getClass().getResource("/GREENPAWN2.png").toString(), 10, 8, this, grid);
        grid.add(green3, 10, 8, 1, 1);
        fields.put(new Coordinates(10, 8), green3);
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

        if (field.getFieldState() == FieldState.DICE && !diceRolled ) {
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

            int movedIndex;

            if(lol <= 2 && rolledDice==6){
                movedIndex = 3;
            } else if(lol<=2 && rolledDice<6) {
                movedIndex = lol;
            }   else {
                movedIndex = lol + rolledDice;
            }

            System.out.println("indeks nowego pionka " + movedIndex);

            Coordinates coordinates = redMap.get(movedIndex);


            int column = coordinates.getCol();
            int row = coordinates.getRow();
            Field fieldRed = new Field((getClass().getResource("/REDPAWN1.png").toString()), column, row, this, grid);
            Field greenField = new Field((getClass().getResource("/GREENPAWN2.png").toString()), column, row, this, grid);

            if (movedIndex <= redMap.size() - 1) {



                column = coordinates.getCol();
                row = coordinates.getRow();
                System.out.println(" coordynate pionka col: " + column + "row : " + row + " moved index = " + movedIndex);


                Field lolfield = fields.get(coordinates);


                if (!fields.containsKey(new Coordinates(column, row)) ) {


                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));
                    System.out.println(" removed col: " + field.getColumn() + "row" + field.getRow());
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;

                } else if (lolfield.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(0, 8))) {

                    System.out.println("NIE PRAWIDłowy ruch ");


                } else if (lolfield.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(1, 8))) {


                    System.out.println("NIE PRAWIDłowy ruch ");

                } else if (lolfield.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(2, 8))) {


                    System.out.println("NIE PRAWIDłowy ruch ");


                } else if (lolfield.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(8, 8))) {

                    lolfield.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/GREENPAWN2.png").toString()), 8, 8, this, grid), 8,8,1,1);
                    fields.put(new Coordinates(8, 8), (new Field((getClass().getResource("/GREENPAWN2.png").toString()), 8, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;


                } else if (lolfield.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(9, 8))) {

                    lolfield.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/GREENPAWN2.png").toString()), 9, 8, this, grid), 9,8,1,1);
                    fields.put(new Coordinates(8, 8), (new Field((getClass().getResource("/GREENPAWN2.png").toString()), 9, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;


                } else {

                    lolfield.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    grid.add(fieldRed, column, row, 1, 1);
                    fields.put(coordinates, fieldRed);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/GREENPAWN2.png").toString()), 10, 8, this, grid), 10,8,1,1);
                    fields.put(new Coordinates(8, 8), (new Field((getClass().getResource("/GREENPAWN2.png").toString()), 10, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;

                }


                if (movedIndex >= redMap.size() - 3 + redPawnsOnFinish) {
                    redPawnsOnFinish++;
                    redMap.remove(movedIndex);
                    fieldRed.setFieldState(EMPTY);
                    for (Coordinates x : redMap) {
                        System.out.println(redMap.indexOf(x));
                    }
                }




                for (Map.Entry<Coordinates, Field> entry : fields.entrySet()) {
                    Coordinates key = entry.getKey();
                    Field value = entry.getValue();

                    System.out.println("map contains col" + key.getCol() + " row: " + key.getRow());
                }
            } else {
                    System.out.println("ERROR - Nie prawidłowy ruch - rzuć kostką jeszcze raz");
                    diceRolled = false;
                }

        }









        if (diceRolled && field.getFieldState() == FieldState.GREEN) {



            int lol = greenMap.indexOf(new Coordinates(field.getColumn(), field.getRow()));
            System.out.println("indeks wybranego pionka : " + lol);

            int movedIndex;

            if(lol <= 2 && rolledDice==6){
                movedIndex = 3;
            } else if(lol<=2 && rolledDice<6) {
                movedIndex = lol;
            }   else {
                movedIndex = lol + rolledDice;
            }


            System.out.println("indeks nowego pionka " + movedIndex);

            if (movedIndex <= greenMap.size() - 1) {

                Coordinates coordinates = greenMap.get(movedIndex);

                int column = coordinates.getCol();
                int row = coordinates.getRow();
                System.out.println(" coordynate pionka col: " + column + "row : " + row);


                Field greenField = new Field((getClass().getResource("/GREENPAWN2.png").toString()), column, row, this, grid);



                Field lolfield = fields.get(coordinates);


                if (!fields.containsKey(new Coordinates(column, row))) {


                    grid.add(greenField, column, row, 1, 1);

                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));
                    System.out.println(" removed col: " + field.getColumn() + "row" + field.getRow());
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;

                } else if (lolfield.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(0, 8))) {

                    lolfield.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    grid.add(greenField, column, row, 1, 1);
                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/REDPAWN1.png").toString()), 0, 8, this, grid), 0,8,1,1);
                    fields.put(new Coordinates(0, 8), (new Field((getClass().getResource("/REDPAWN1.png").toString()), 0, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;


                } else if (lolfield.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(1, 8))) {


                    lolfield.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    grid.add(greenField, column, row, 1, 1);
                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/REDPAWN1.png").toString()), 1, 8, this, grid), 8,8,1,1);
                    fields.put(new Coordinates(1, 8), (new Field((getClass().getResource("/REDPAWN1.png").toString()), 1, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;

                } else if (lolfield.getFieldState() == FieldState.RED && !fields.containsKey(new Coordinates(2, 8))) {


                    lolfield.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    grid.add(greenField, column, row, 1, 1);
                    fields.put(coordinates, greenField);
                    fields.remove(new Coordinates(field.getColumn(), field.getRow()));


                    grid.add(new Field((getClass().getResource("/REDPAWN1.png").toString()), 2, 8, this, grid), 2,8,1,1);
                    fields.put(new Coordinates(2, 8), (new Field((getClass().getResource("/REDPAWN1.png").toString()), 2, 8, this, grid)));
                    field.setImage(new Image(getClass().getResource("/empty.png").toString()));
                    diceRolled = false;


                } else if (lolfield.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(8, 8))) {

                    System.out.println("NIE PRAWIDłowy ruch ");


                } else if (lolfield.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(9, 8))) {

                    System.out.println("NIE PRAWIDłowy ruch ");


                } else if(lolfield.getFieldState() == FieldState.GREEN && !fields.containsKey(new Coordinates(10, 8))) {

                    System.out.println("NIE PRAWIDłowy ruch ");

                }





                if (movedIndex >= greenMap.size() - 3 + greenPawnsOnFinish) {
                    greenPawnsOnFinish++;
                    greenMap.remove(movedIndex);
                    greenField.setFieldState(EMPTY);
                    for (Coordinates x : greenMap) {
                        System.out.println(greenMap.indexOf(x));
                    }
                }







            } else {
                System.out.println("ERROR - Nie prawidłowy ruch - rzuć kostką jeszcze raz");
                diceRolled = false;
            }


        }


    }
}





