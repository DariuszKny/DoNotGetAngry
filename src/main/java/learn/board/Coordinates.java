package learn.board;

public class Coordinates {

    private Integer col;
    private Integer row;

    public Coordinates(Integer col, Integer row) {
        this.col = col;
        this.row = row;
    }

    public Integer getCol() {
        return col;
    }

    public Integer getRow() {
        return row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Coordinates that = (Coordinates) o;

        if (col != null ? !col.equals(that.col) : that.col != null) return false;
        return row != null ? row.equals(that.row) : that.row == null;
    }

    @Override
    public int hashCode() {
        int result = col != null ? col.hashCode() : 0;
        result = 31 * result + (row != null ? row.hashCode() : 0);
        return result;
    }
}
