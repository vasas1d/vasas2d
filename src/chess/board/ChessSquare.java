// SquareView osztály egy sakktábla egy mezőjét jeleníti meg
package chess.board;

import chess.pieces.ChessPiece;

public class ChessSquare {
    private int x;
    private int y;
    private ChessPiece piece;

    public ChessSquare(int x, int y) {
        this.x = x;
        this.y = y;
        this.piece = null;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public void setPiece(ChessPiece piece) {
        this.piece = piece;
    }

    public ChessPiece getPiece() {
        return this.piece;
    }

    public boolean isEmpty() {
        return this.piece == null;
    }
}
