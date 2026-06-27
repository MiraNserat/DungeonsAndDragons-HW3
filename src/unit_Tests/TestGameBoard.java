package unit_Tests;
import GameBoard.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.DynamicTest.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestGameBoard {
    public GameBoard buildBoard(){
        Cell[][] cells = new Cell[3][3];

        cells[0][0] = new Wall(new Position(0,0));
        cells[0][1] = new Wall(new Position(0,1));
        cells[0][2] = new Wall(new Position(0,2));

        cells[1][0] = new Wall(new Position(1,0));
        cells[1][1] = new Floor(new Position(1,1));
        cells[1][2] = new Wall(new Position(1,2));

        cells[2][0] = new Wall(new Position(2,0));
        cells[2][1] = new Wall(new Position(2,1));
        cells[2][2] = new Wall(new Position(2,2));

        return new GameBoard(cells);
    }

    @Test
    public void testPrintingBoard(){

        GameBoard board = buildBoard();
        String expected =
                "###\n" +
                "#.#\n" +
                "###\n";

        assertEquals(expected, board.toString());
    }

    @Test
    public void testSetOccupant(){
        GameBoard board = buildBoard();
        board.setOccupant(new Position(1,1), null);
    }

}
