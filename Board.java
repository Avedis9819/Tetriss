package Tetris;

import java.util.Arrays;

public class Board {
    public final int height = 24;
    public final int width = 10;

    public final int[][] grid = new int[24][10];


    //The height is 24, so that the object can be created at that height and start falling down
    public Board() {
        gridCreation();
    }

    public void gridCreation() {

        for (int rows = 0; rows < this.height; rows++) {
            for (int cols = 0; cols < this.width; cols++) {
                this.grid[rows][cols] = 0;
            }
        }
    }

    //TODO: correct clearRows
    public void clearRows() {
        boolean rowIsFilled = true;
        //Indication of at which row is filled

        for(int row = 0; row < this.height; row++) {
            for(int col = 0; col < this.width; col++) {
                if(this.grid[row][col] == 0) {
                    rowIsFilled = false;
                    break;
                }
            }

            if(rowIsFilled) {
                Arrays.fill(this.grid[row], 0);
            }
        }

    }

    //TODO: Check for collisions
    // TODO: Check for collisions
    // TODO: Check for collisions

    public String toString() {
        return "This board has height of " + height +
                " and a width of " + width;
    }

    public void printBoard() {
        for (int[] ints : grid) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

}
