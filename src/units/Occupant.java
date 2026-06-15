package units;

public interface Occupant {
    public char getTile();
    public String toString();
    public  void accept(OccupantVisitor visitor);
}
