package chess.pieces;

import chess.board.Board;

public class Bishop extends ChessPiece {

    public Bishop(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    public Bishop() {
        super();
    }
    
    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }
    
    @Override
    public String getImageFileName() {
        return isWhite() ? "BishopWhite.png" : "BishopBlack.png";
	//return isWhite() ? "BishopWhite" : "BishopBlack";
    }

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        // A futó csak átlósan mozoghat, tehát az x és y koordináták különbségeinek abszolút értékeinek egyeznie kell
        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());
        if (dx == dy) {
            // Ellenőrizzük, hogy útban van-e másik bábu
            int xDir = Integer.compare(x, getXPosition());
            int yDir = Integer.compare(y, getYPosition());
            int currX = getXPosition() + xDir;
            int currY = getYPosition() + yDir;
            while (currX != x && currY != y) {
                if (board.getPiece(currX, currY) != null) {
                    return false;
                }
                currX += xDir;
                currY += yDir;
            }
            // Ha nincs útban másik bábu, akkor az lépés helyes
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return "Bishop";
    }
}
