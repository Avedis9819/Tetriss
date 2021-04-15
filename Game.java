import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    Board board;

    public Game(Board board) {
        this.board = board;
    }

    public void draw (Tetromino tetromino) {
        for(int i = 0; i < tetromino.stateOfTetrimono.length; i++) {
            for(int j = 0; j < tetromino.stateOfTetrimono[i].length; j++) {
                board.grid[tetromino.Position.getX()+i][tetromino.Position.getY()+j] = tetromino.stateOfTetrimono[i][j];
            }
        }
    }

    public void eraseBoard() {
        for (int i = 0; i < board.grid.length; i++) {
            Arrays.fill(board.grid[i],0);
        }
    }

    public void updateBoard(ArrayList<Tetromino> tetrominos) {
        for(Tetromino tetri: tetrominos) {
            eraseBoard();
            draw(tetri);
        }
    }



}
