
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
    public Tetromino currentTetromino;
    private Timer timer;
    private int prevShapeY;
    private int prevShapeX;
    private boolean collided = false;


    public Board() {
        this.setLayout(null);
        this.height = 20;
        this.width = 10;
        this.grid =  new int[this.width][this.height];
        this.squareSize = 30;
        this.currentTetromino = new Tetromino();

        timer = new Timer(800, this);
        timer.start();

    }

    //TODO: correct clearRows - DONE - should be checked
    public void clearRows() {
        boolean rowIsFilled = true;
        //Indication of at which row is filled

        for(int row = 0; row <= this.height; row++) {
            for(int col = 0; col <= this.width; col++) {
                if(this.grid[row][col] == 0) {
                    rowIsFilled = false;
                    break;
                }
            }

            if(rowIsFilled) {
                for(int col = row; col > 0;--col) {
                    System.arraycopy(this.grid[col-1],0,this.grid[col],0,width);
                }

                Arrays.fill(this.grid[0], 0);
            }
        }

    }


    public boolean checkCollision() {
        boolean collisionOccurred = false;
//        height/2 < BOARD_WIDTH - currShapeX
        //
        if(currentTetromino.height/2 + (currentTetromino.currShapeY == height -1 ?1:0) >= height - this.currentTetromino.currShapeY || (currentTetromino.currShapeY == height - currentTetromino.height/2-1 && !currentTetromino.areSidesZeros('d'))) { //changed -1
            collisionOccurred = true;
        }
//        for(int i = 0; i < currentTetromino.stateOfTetromino.length; i++) {
//            for (int j = 0; j < currentTetromino.stateOfTetromino[i].length; j++) {
//                if (currentTetromino.stateOfTetromino[i][j] != 0) {
//                    if(grid[i+1][j] == 1) {
//                        collisionOccurred = true;
//                    }
//
//                    //TODO: write logic for collision with other shapes
//                }
//            }
//        }
        return collisionOccurred;
    }



    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        for (int i = 0; i <= this.height; i++) {
            graphics.drawLine(0, squareSize * i, this.width * squareSize, i * squareSize);
        }

        for (int i = 0; i <= this.width; i++) {
            graphics.drawLine(i * squareSize, 0, i * squareSize, this.height * squareSize);

        }


        for(int i = 0; i < currentTetromino.getStateOfTetromino().length; i++) {
            for(int j = 0; j < currentTetromino.getStateOfTetromino()[i].length; j++) {
                if(currentTetromino.getStateOfTetromino()[i][j] == 1) {
                    graphics.setColor(Color.BLACK);
                    graphics.fillRect((j + this.currentTetromino.currShapeX-1) * squareSize,  (i + this.currentTetromino.currShapeY-1) * squareSize , squareSize, squareSize);
                    //TODO: had i and j
                }
            }
        }

//        graphics.setColor(Color.BLACK);
//        graphics.fillRect(this.currShapeX * squareSize, this.currShapeY * squareSize, squareSize ,squareSize);
//            for(int row = 0; row < this.height; row++) {
//                for(int col = 0; col < this.width; col++) {
//                }
//            }
    }


    @Override
    public void actionPerformed (ActionEvent e){
        //Moves the shapes down
        if(!checkCollision()) {
            this.currentTetromino.currShapeY = this.currentTetromino.currShapeY + 1;
//            clearRows();
            repaint();
        }

    }

    //TODO: Check whether the hardDrop works properly with the gui, and set the Down button for hardDrop
    public void hardDrop() {
        while(!checkCollision()) {
            this.currentTetromino.currShapeY = this.currentTetromino.currShapeY +1;
        }
    }

    public static void main(String[] args) {
        Board board = new Board();
        int count = 0;
        System.out.println("Shape: "+ board.currentTetromino.shape);
        System.out.println("Index: " + board.currentTetromino.index);
        System.out.println("Tetromino X: " + board.currentTetromino.currShapeX);
        System.out.println("Tetromino Y: " + board.currentTetromino.currShapeY);
        System.out.println("Tetromino height: " + board.currentTetromino.height);
        System.out.println("Tetromino width: " + board.currentTetromino.width);
        while(!board.checkCollision()) {
            board.currentTetromino.currShapeY = board.currentTetromino.currShapeY + 1;
            count++;
        }
        System.out.println("Count: " + count);
        System.out.println(board.checkCollision());
    }


}

