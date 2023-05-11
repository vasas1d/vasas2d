package chess.game;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class ChessBoardPanel extends JPanel {

    private static final long serialVersionUID = 1L;

    private static final int BOARD_SIZE = 8;
    private static final int SQUARE_SIZE = 50;

    // A paintComponent metódus beállítja a panel hátterét, majd kirajzolja a sakktáblát.
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        setBackground(Color.WHITE);
        drawBoard(g);
    }

    // A drawBoard metódus rajzolja ki a sakktáblát a megadott Graphics objektum segítségével.
    private void drawBoard(Graphics g) {
        for (int row = 0; row < BOARD_SIZE; row++) {
            for (int col = 0; col < BOARD_SIZE; col++) {
                // A négyzeten való állapotfüggő színbeállítást külön metódusba szerveztük ki.
                setSquareColor(g, row, col);
                // A fillRect metódus segítségével rajzoljuk ki a sakktáblát.
                g.fillRect(col * SQUARE_SIZE, row * SQUARE_SIZE, SQUARE_SIZE, SQUARE_SIZE);
            }
        }
    }

    // A setSquareColor metódus állapotfüggő színt ad a négyzetnek.
    private void setSquareColor(Graphics g, int row, int col) {
        if ((row + col) % 2 == 0) {
            g.setColor(Color.WHITE);
        } else {
            g.setColor(Color.BLACK);
        }
    }
}
