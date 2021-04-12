package Tetris;

public class Board {
    private final int height;
    private final int width;

    private final int[][] grid = new int[24][10];


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

        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                this.grid[i][j] = 0;
            }
        }
    }

    public String toString() {
        return "This board has height of " + height +
                " and a width of " + width;
    }

}

//
//    public static void main(String[] args) {
//        Board b = new Board();
//
//        for(int i = 0; i < b.grid.length; i++) {
//            for(int j = 0; j < b.grid[i].length; j++) {
//                System.out.print(b.grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//    }

