
package Tetris.Tetris;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

public class Board extends JPanel implements ActionListener {

    public final int height;
    public final int width;
    public final int[][] grid;
    private final int squareSize;
    private Shape shape;
    private int shapeForm;
    private Timer timer;
    private int currShapeY;
    private int prevShapeY;
    public int currShapeX;
    private int prevShapeX;
    private boolean collided = false;


    public Board() {
        this.setLayout(null);
        this.height = 20;
        this.width = 10;
        this.grid =  new int[this.width][this.height];
        this.squareSize = 30;
        this.currShapeY = 0;
        this.currShapeX = 4;
        this.shape = Shape.getRandomShape();

        timer = new Timer(800, this);
        timer.start();

    }

    //TODO: correct clearRows
    public void clearRows() {
        boolean rowIsFilled = true;
        //Indication of at which row is filled

        for (int row = 0; row < this.height; row++) {
            for (int col = 0; col < this.width; col++) {
                if (this.grid[row][col] == 0) {
                    rowIsFilled = false;
                    break;
                }
            }

            if (rowIsFilled) {
                Arrays.fill(this.grid[row], 0);
            }
        }

    }

    //TODO: Check for collisions
    // TODO: Check for collisions
    // TODO: Check for collisions


    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i < this.height; i++) {
            graphics.drawLine(0, squareSize * i, this.width * squareSize, i * squareSize);
        }

        for (int i = 0; i < this.width; i++) {
            graphics.drawLine(i * squareSize, 0, i * squareSize, this.height * squareSize);

        }
        graphics.setColor(Color.BLACK);
        graphics.fillRect(this.currShapeX * squareSize, this.currShapeY * squareSize, squareSize ,squareSize);
//            for(int row = 0; row < this.height; row++) {
//                for(int col = 0; col < this.width; col++) {
//                }
//            }
    }


    @Override
    public void actionPerformed (ActionEvent e){
        //Moves the shapes down
        if(currShapeY != this.height - 1) {
            this.currShapeY = this.currShapeY + 1;
            repaint();
        }
    }



}

