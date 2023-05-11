// egyetlen lépést definiál és ahzt végrehajta a sakktáblán.
package chess.game;

import chess.board.Board;
import chess.pieces.ChessPiece;
import chess.pieces.util.PieceUtils;

public class Move {

    private final int fromX;
    private final int fromY;
    private final int toX;
    private final int toY;
    private final Board board;

    public Move(int fromX, int fromY, int toX, int toY, Board board) {
        this.fromX = fromX;
        this.fromY = fromY;
        this.toX = toX;
        this.toY = toY;
        this.board = board;
    }
    
    public int getFromX() {
        return fromX;
    }

    public int getFromY() {
        return fromY;
    }

    public int getToX() {
        return toX;
    }

    public int getToY() {
        return toY;
    }

    public Board getBoard() {
        return board;
    }

    //Az executeMove függvény lépést hajt végre a sakktáblán.
    public boolean executeMove() {
        ChessPiece piece = board.getPiece(fromX, fromY);
        if (piece == null) {
            return false;
        }
        if (!piece.isValidMove(toX, toY, board)) {
            return false;
        }
        if (piece.isPathBlocked(fromX, fromY, toX, toY, board)) {
            return false;
        }
        board.movePiece(fromX, fromY, toX, toY);
        return true;
    }

}
