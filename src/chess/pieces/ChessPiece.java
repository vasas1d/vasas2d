package chess.pieces;

import chess.board.Board;
import chess.pieces.Color;
import chess.pieces.util.PieceUtils;
import chess.game.Move;
import java.util.ArrayList;
import java.util.List;

public abstract class ChessPiece {

    protected int xPosition;
    protected int yPosition;
    protected Color color;

    public ChessPiece(){};

    public ChessPiece(int xPosition, int yPosition, Color color) {
        this.xPosition = xPosition;
        this.yPosition = yPosition;
        this.color = color;
    }
    
    //Visszaadja, hogy a bábu fehér-e vagy sem.
    public abstract boolean isWhite();
    
    //Visszaadja a bábu képének a fájlnevét. 
    public abstract String getImageFileName();

    //Vizsgálja, hogy a bábu adott célmezőre történő lépése érvényes-e.
    public abstract boolean isValidMove(int x, int y, Board board);
    
    //Visszaadja a bábunak az összes lehetséges érvényes lépését.
    public List<Move> getLegalMoves(Board board) {
        List<Move> legalMoves = new ArrayList<>();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (isValidMove(x, y, board)) {
                    legalMoves.add(new Move(xPosition, yPosition, x, y, board));
                }
            }
        }

        return legalMoves;
    }

    //Visszaadja a bábu nevét. metódus felesleges, mert minden bábu rendelkezik a color és a type adattagokkal, ezekből a színből és a típusból könnyen meg lehet határozni a bábu nevét.
    public abstract String getName();

    public int getXPosition() {
        return xPosition;
    }

    public void setXPosition(int xPosition) {
        this.xPosition = xPosition;
    }

    public int getYPosition() {
        return yPosition;
    }

    public void setYPosition(int yPosition) {
        this.yPosition = yPosition;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    
    //Az isPathBlocked függvény ellenőrzi, hogy az adott útvonalon van-e akadály a bábu és a célmező között.
    public boolean isPathBlocked(int fromX, int fromY, int toX, int toY, Board board) {
	    if (toX < 0 || toX > 7 || toY < 0 || toY > 7) {
	        return true;
	    }
	    int dx = Integer.compare(toX, fromX);
	    int dy = Integer.compare(toY, fromY);

	    int x = fromX + dx;
	    int y = fromY + dy;

	    while (x != toX || y != toY) {
	        if (board.getPiece(x, y) != null) {
	            return true;
	        }
	        x += dx;
	        y += dy;
	    }

	    return false;
	}


    //Beállítja a bábut az adott mezőre a táblán.
    public void setPiece(int x, int y, Board board) {
        board.setPiece(this, x, y);
    }
            
    //Visszaadja az adott mezőn lévő bábut.
    public ChessPiece getPiece(int x, int y, Board board) {
        return board.getBoard()[x][y];
    }
}
