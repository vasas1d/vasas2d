package chess.test;

import chess.board.Board;
import chess.pieces.Color;
import org.junit.Test;
import static org.junit.Assert.*;

public class BoardTest {

    @Test
    public void testGetInstance() {
        Board board1 = Board.getInstance();
        Board board2 = Board.getInstance();
        assertEquals(board1, board2);
    }


}
