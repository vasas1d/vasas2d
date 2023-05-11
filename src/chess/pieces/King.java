// nincs sakk adás a francia sakkban. sakk és matt sincs így. 

package chess.pieces;
//import static chess.pieces.util.PieceUtils.isOnBoard;
import chess.board.Board;
import chess.pieces.util.PieceUtils;

public class King extends ChessPiece {

    public King(int xPosition, int yPosition, Color color) {
        super(xPosition, yPosition, color);
    }

    public King() {
        super();
    }
    
    @Override
    public boolean isWhite() {
        return color == Color.WHITE;
    }
    
    @Override
    public String getImageFileName() {
        return isWhite() ? "KingWhite.png" : "KingBlack.png";
    }

    @Override
    public boolean isValidMove(int x, int y, Board board) {
        if (x == getXPosition() && y == getYPosition()) {
            return false; // A király nem változtatja a pozícióját
        }

        //if (!Board.getInstance().isOnBoard(x, y)) {
        if (!PieceUtils.isOnBoard(x, y)) {
            return false; // Az új pozíció azon kívül van, mint a játéktábla
        }

        int dx = Math.abs(x - getXPosition());
        int dy = Math.abs(y - getYPosition());

        return (dx == 1 && dy == 0) || // Vízszintesen 1 mező
                (dx == 0 && dy == 1) || // Függőlegesen 1 mező
                (dx == 1 && dy == 1);  // Átlósan 1 mező
    }

    @Override
    public String getName() {
        return "King";
    }
}
