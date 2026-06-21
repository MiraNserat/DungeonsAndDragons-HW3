package GameBoard;

import java.util.NoSuchElementException;

public class GameBoard {
    private Cell [][] gameTiles;

    public GameBoard(Cell[][] gameTiles){
        this.gameTiles = gameTiles;
    }

    public Cell getCell(Position p){
        if(p == null){
            throw new NullPointerException("position is invalid");
        }

        return gameTiles[p.getX()][p.getY()];
    }

    public Occupant getOccupant(Position p){
        if(p == null){
            throw new NullPointerException("position is invalid");
        }

        Cell cell = this.gameTiles[p.getX()][p.getY()];

        if(cell instanceof Floor){
            return ((Floor) cell).getOccupant();
        }
        else {
            throw new NoSuchElementException("can not place an occupant on a wall");
        }
    }

    public void setOccupant(Position p, Occupant o){
        if(p == null){
            throw new NullPointerException("position is invalid");
        }

        Cell cell = this.gameTiles[p.getX()][p.getY()];

        if(cell instanceof Floor){
            ((Floor) cell).setOccupant(o);
        }
        else {
            throw new NoSuchElementException("can not place an occupant on a wall");
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        for(int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++)
                sb.append(gameTiles[i][j].toString());
            sb.append("\n");
        }

        return sb.toString();
    }
}
