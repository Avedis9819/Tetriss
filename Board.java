package Tetris;

import java.util.Arrays;

public class Board {
    private final int height;
    private final int width;

    public final int[][] grid = new int[24][10];


    //The height is 24, so that the object can be created at that height and start falling down
    public Board() {
        this.height = 24;
        this.width = 10;
        gridCreation();
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        gridCreation();
    }

    public Board(Board board) {
        this.height = board.height;
        this.width = board.width;
    }

    public void gridCreation() {

        for (int rows = 0; rows < this.height; rows++) {
            for (int cols = 0; cols < this.width; cols++) {
                this.grid[rows][cols] = 1;
            }
        }
    }

    public void clearRows() {

        boolean rowIsFilled = true;
        //Indication of at which row is filled


        for(int row = 0; row < this.height; row++) {
            for(int col = 0; col < this.width; col++) {

                if(this.grid[row][col] == 0) {
                    rowIsFilled = false;
                }
            }

            if(rowIsFilled) {
                Arrays.fill(this.grid[row], 0);
            }
        }

    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public String toString() {
        return "This board has height of " + height +
                " and a width of " + width;
    }

}



//TODO: Shape out of the boarder when rotated