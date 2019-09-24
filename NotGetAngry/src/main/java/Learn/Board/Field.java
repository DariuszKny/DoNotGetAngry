package Learn.board;

import java.util.ArrayList;

public class Field {
    private int column;
    private int row;
    private static boolean occupied = false;
    private static int fieldIndex;

    public Field(int column, int row) {
        this.column = column;
        this.row = row;
    }

    public int getColumn() {
        return column;
    }

    public int getRow() {
        return row;
    }

    public boolean isOccupied() {
        return occupied;
    }

    public boolean changeFieldStatus() {
        if (occupied == false) {
            occupied = true;
        } else {
            occupied = false;
        }
        return occupied;
    }
}

