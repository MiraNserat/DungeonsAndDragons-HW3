package GameBoard;
import units.*;
public class Floor extends Cell{
    private Occupant occupant;

    public Floor(Position p) {
        super(p);
        occupant = null;
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
