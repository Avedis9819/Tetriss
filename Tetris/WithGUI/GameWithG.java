package Tetris.Tetris.WithGUI;

import Tetris.Tetris.Board;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameWithG extends JFrame implements KeyListener {
    private ImageIcon icon;
    Board board;

    GameWithG() {
        icon = new ImageIcon(".//Images//tetris.png");
        this.setIconImage(icon.getImage());
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        this.setLayout(null);
        this.setTitle("Tetris");
        this.setSize(315, 640);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        board = new Board();
        this.addKeyListener(this);
        this.add(board);
    }

    public static void main(String[] args) {
        GameWithG g = new GameWithG();
    }


    @Override
    public void keyTyped(KeyEvent e) {
        //Nothing comes here
    }

    @Override
    public void keyPressed(KeyEvent e) {

            if (e.getKeyCode() == e.VK_LEFT) {
                if (board.currShapeX != 0) {
                    board.currShapeX = board.currShapeX - 1;
                    System.out.println("left");
                    repaint();
                }
            }
            else if (e.getKeyCode() == e.VK_RIGHT) {
                if(board.currShapeX != board.width - 1) {
                    board.currShapeX = board.currShapeX + 1;
                    System.out.println("right");
                    repaint();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //Nothing comes here
    }
}
