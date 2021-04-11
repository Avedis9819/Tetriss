package Tetris;

public class Board {
    private int height;
    private int width;

    private final int[][] grid = new int[20][10];

    public Board() {
        this.height = 20;
        this.width = 10;
        gridCreation();
    }

    public Board(int width, int height) {
        this.width = width;
        this.height = height;
        gridCreation();
    }

    public void gridCreation() {

        for(int i = 0; i < this.height; i++) {
            for(int j = 0; j < this.width; j++) {
                this.grid[i][j] = 1;
            }
        }
    }

    public static void main(String[] args) {
        Board b = new Board();

        for(int i = 0; i < b.grid.length; i++) {
            for(int j = 0; j < b.grid[i].length; j++) {
                System.out.print(b.grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
