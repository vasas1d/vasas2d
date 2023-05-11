// Singleton osztály, egyke hehe", egyetlen példányban tartja a táblát, és biztosítja, hogy mindenhol ugyanazt a táblát használja a program

package chess.board;

import chess.pieces.ChessPiece;
import chess.pieces.util.PieceUtils;
import chess.game.Move;
import chess.pieces.Color;
import java.util.ArrayList;
import java.util.List;

//Singleton osztály "egyke" hehe
public class Board {
    private static Board instance = null;
    private final ChessPiece[][] board;
    

    //publikus konstruktor, hogy a tesztosztályokból elérhető legyen
    private Board() {
        board = BoardFactory.generateBoard();
    }

    public static Board getInstance() {
        if (instance == null) {
            instance = new Board();
        }
        return instance;
    }

    //toString() metódus a táblát jeleníti meg karakterlánc formájában
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("  a b c d e f g h\n");
        for (int i = 0; i < 8; i++) {
            result.append(8 - i).append(" ");
            for (int j = 0; j < 8; j++) {
                ChessPiece piece = board[i][j];
                if (piece != null) {
                    result.append(piece.getName());
                } else {
                    result.append(".");
                }
                result.append(" ");
            }
            result.append(i + 1).append(System.lineSeparator());
        }
        result.append("  a b c d e f g h\n");
        return result.toString();
    }


    public boolean isOnBoard(int x, int y) {
        return PieceUtils.isOnBoard(x, y);
    }

    public ChessPiece getPiece(int x, int y) {
	    if (isOnBoard(x, y)) {
	        return board[x][y];
	    } else {
	        throw new IllegalArgumentException("Érvénytelen mező: " + x + ", " + y);
	    }
	}
    
    public void setPiece(ChessPiece piece, int x, int y) {
	    if (isOnBoard(x, y)) {
	        board[x][y] = piece;
	        if (piece != null) {
	            piece.setXPosition(x);
	            piece.setYPosition(y);
	        }
	    } else {
	        throw new IllegalArgumentException("Érvénytelen mező: " + x + ", " + y);
	    }
	}
    
    public boolean movePiece(int fromX, int fromY, int toX, int toY) { 
        ChessPiece piece = getPiece(fromX, fromY);

        if (piece == null) {
            return false;
        }

        if (!piece.isValidMove(toX, toY, this)) {
            return false;
        }

        if (piece.isPathBlocked(fromX, fromY, toX, toY, this)) {
            return false;
        }

        if (getPiece(toX, toY) != null) {
            return false;
        }

        setPiece(piece, toX, toY);
        setPiece(null, fromX, fromY);

        return true;
    }
    
    //getLegalMoves metódus a szabályos lépések listáját adja vissza az adott szín által birtokolt bábuk számára
    public List<Move> getLegalMoves(Color color) { 
        List<Move> legalMoves = new ArrayList<>();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessPiece piece = getPiece(x, y);

                if (piece != null && piece.getColor() == color) {
                    List<Move> pieceLegalMoves = piece.getLegalMoves(this);
                    legalMoves.addAll(pieceLegalMoves);
                }
            }
        }

        return legalMoves;
    }
    
    public ChessPiece[][] getBoard() {
        return board;
    }
    
    //a hasPieces() metódus azonosítja, hogy van-e még egy adott szín által birtokolt bábu a táblán vagy sem.
    public boolean hasPieces(Color color) {
	    for (int x = 0; x < 8; x++) {
	        for (int y = 0; y < 8; y++) {
	            ChessPiece piece = getPiece(x, y);
	            if (piece != null && piece.getColor() == color) {
	                return true;
	            }
	        }
	    }
	    return false;
	}
  // ChessPiece removePiece(int x, int y) metódus visszatérési értéke a törölt bábu  
    public ChessPiece removePiece(int x, int y) {
	    if (isOnBoard(x, y)) {
	        ChessPiece piece = board[x][y];
	        board[x][y] = null;
	        if (piece != null) {
	            piece.setXPosition(-1);
	            piece.setYPosition(-1);
	        }
	        return piece;
	    } else {
	        throw new IllegalArgumentException("Érvénytelen mező: " + x + ", " + y);
	    }
	}




}
