package GameBoard;

public class Wall extends Cell {
    public Wall(Position p) {
        super(p);
    }

    @Override
    public String toString() {
        return "#";
    }
}
