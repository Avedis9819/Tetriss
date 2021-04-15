import java.util.ArrayList;

public class GameDemo {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);

        //creates dynamic array of tetromino
        ArrayList<Tetromino> tetrominos = new ArrayList<>();
        Tetromino tetromino = new Tetromino(board);
        tetrominos.add(tetromino);

        System.out.println("Position: "+tetromino.Position);
        System.out.println("Width: " + tetromino.width);
        System.out.println();

        //print the tetromino
        for(int i = 0; i < tetromino.stateOfTetrimono.length; i++) {
            for(int j = 0; j < tetromino.stateOfTetrimono[i].length; j++) {
                System.out.print(tetromino.stateOfTetrimono[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        //update the board
        game.updateBoard(tetrominos);

        //Print board
        for (int i = 0; i < board.grid.length; i++) {
            for (int j = 0; j < board.grid[i].length;j++) {
                System.out.print(board.grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();

        //Move to the right
        tetromino.moveRight();

        //update the board
        game.updateBoard(tetrominos);

        //Print board
        for (int i = 0; i < board.grid.length; i++) {
            for (int j = 0; j < board.grid[i].length;j++) {
                System.out.print(board.grid[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();


    }
}
