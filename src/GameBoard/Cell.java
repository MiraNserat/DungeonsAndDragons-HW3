package GameBoard;

public abstract class Cell {
    private Position position;

    public Cell(Position p){ this.position = p;}
}

class Wall extends Cell {
    public Wall(Position p) {
        super(p);
    }
}

class Floor extends Cell{
    private Occupant occupant;

    public Floor(Position p, Occupant occupant) {
        super(p);
        this.occupant = occupant;
    }

    public Occupant getOccupant() {
        return occupant;
    }

    public void setOccupant(Occupant occupant) {
        this.occupant = occupant;
    }

}
