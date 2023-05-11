//sakkjáték grafikus felhasználói felületét valósítja meg, amely a megjelenítést végzi, és a játékosok által végrehajtott lépéseket megjeleníti a sakk-táblán

package chess.game;

import java.awt.*;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;
import chess.board.*;
import chess.pieces.*;
import java.io.File;


public class ChessMain {

    private JFrame frame;
    private JPanel boardPanel;
    private JPanel whitePanel;
    private JPanel blackPanel;

    public ChessMain() {
	frame = new JFrame("French Chess Game");
	frame.setSize(600, 600);
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	boardPanel = new JPanel(new GridLayout(8, 8));
	boardPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	whitePanel = new JPanel(new GridLayout(1, 8));
	whitePanel.setPreferredSize(new Dimension(600, 75));
	whitePanel.setBackground(Color.WHITE);

	blackPanel = new JPanel(new GridLayout(1, 8));
	blackPanel.setPreferredSize(new Dimension(600, 75));
	blackPanel.setBackground(Color.WHITE);

	frame.add(boardPanel, BorderLayout.CENTER);
	frame.add(whitePanel, BorderLayout.NORTH);
	frame.add(blackPanel, BorderLayout.SOUTH);

	for (int i = 0; i < 64; i++) {
	    JPanel squarePanel = new JPanel(new BorderLayout());
	    if ((i / 8) % 2 == 0) {
		if (i % 2 == 0) {
		    squarePanel.setBackground(Color.WHITE);
		} else {
		    squarePanel.setBackground(Color.GRAY);
		}
	    } else {
		if (i % 2 == 0) {
		    squarePanel.setBackground(Color.GRAY);
		} else {
		    squarePanel.setBackground(Color.WHITE);
		}
	    }
	    boardPanel.add(squarePanel);
	}

	addPieces();
	frame.setLocationRelativeTo(null); // az ablak középre igazítása

	frame.setVisible(true);
    }
    
    private void addPieces() {
	    ChessPiece[][] pieces = BoardFactory.generateBoard();

	    // fehér bábuk létrehozása, felül a tisztek
	    for (int i = 0; i < 8; i++) {
	        JPanel squarePanel = (JPanel)boardPanel.getComponent(i);
	        JPanel piecePanel = new JPanel(new BorderLayout()); 
	        JLabel pieceLabel = new JLabel(new ImageIcon("C:\\Users\\Acer\\Desktop\\Project chess\\WORKSPACES4\\BoblerFrenchChessApplication\\src\\images\\" + pieces[0][i].getImageFileName()));
	        piecePanel.add(pieceLabel);
	        piecePanel.setOpaque(false); // átlátszó hátteret állítunk be
	        squarePanel.add(piecePanel);
	    }

	    //  fehér gyalogok
	    for (int i = 8; i < 16; i++) {
	        JPanel squarePanel = (JPanel)boardPanel.getComponent(i);
	        JPanel piecePanel = new JPanel(new BorderLayout());
	        JLabel pieceLabel = new JLabel(new ImageIcon("C:\\Users\\Acer\\Desktop\\Project chess\\WORKSPACES4\\BoblerFrenchChessApplication\\src\\images\\" + pieces[1][i-8].getImageFileName()));
	        piecePanel.add(pieceLabel);
	        piecePanel.setOpaque(false); // átlátszó hátteret állítunk be
	        squarePanel.add(piecePanel);
	    }
	    // fekete gyalogok
	    for (int i = 48; i < 56; i++) {
	        JPanel squarePanel = (JPanel)boardPanel.getComponent(i);
	        JPanel piecePanel = new JPanel(new BorderLayout());
	        JLabel pieceLabel = new JLabel(new ImageIcon("C:\\Users\\Acer\\Desktop\\Project chess\\WORKSPACES4\\BoblerFrenchChessApplication\\src\\images\\" + pieces[6][i-48].getImageFileName()));
	        piecePanel.add(pieceLabel);
	        piecePanel.setOpaque(false); // átlátszó hátteret állítunk be
	        squarePanel.add(piecePanel);
	    }
	    // fekete bábok
	    for (int i = 56; i < 64; i++) {
	        JPanel squarePanel = (JPanel)boardPanel.getComponent(i);
	        JPanel piecePanel = new JPanel(new BorderLayout());
	        JLabel pieceLabel = new JLabel(new ImageIcon("C:\\Users\\Acer\\Desktop\\Project chess\\WORKSPACES4\\BoblerFrenchChessApplication\\src\\images\\" + pieces[7][i-56].getImageFileName()));
	        piecePanel.add(pieceLabel);
	        piecePanel.setOpaque(false); // átlátszó hátteret állítunk be
	        squarePanel.add(piecePanel);
	    }
	    
	    		//+ további mezők valamerre a leütött báboknak
	    
	}




public static void main(String[] args) {
   
new ChessMain();

  }
}
