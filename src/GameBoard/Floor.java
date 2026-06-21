package GameBoard;

public class Floor extends Cell{
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

    @Override
    public String toString() {
        if(occupant != null){
            return occupant.toString();
        }
        return ".";
    }
}
