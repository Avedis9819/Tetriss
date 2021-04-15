import java.util.ArrayList;

public class GameDemo {
    public static void main(String[] args) {
        Board board = new Board();
        Game game = new Game(board);

        ArrayList<Tetromino> tetrominos = new ArrayList<Tetromino>();
        Tetromino tetromino = new Tetromino(board);
        tetrominos.add(tetromino);

        System.out.println("Position: "+tetromino.Position);
        System.out.println("Width: " + tetromino.width);
        System.out.println();
        for(int i = 0; i < tetromino.stateOfTetrimono.length; i++) {
            for(int j = 0; j < tetromino.stateOfTetrimono[i].length; j++) {
                System.out.print(tetromino.stateOfTetrimono[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();

        for(Tetromino tetri: tetrominos) {
            game.eraseBoard();
            game.draw(tetri);
        }

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

        for(Tetromino tetri: tetrominos) {
            game.eraseBoard();
            game.draw(tetri);
        }

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
