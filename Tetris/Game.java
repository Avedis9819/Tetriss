package Tetris;

import java.util.ArrayList;
import java.util.Arrays;

public class Game {
    Board board;
    public static ArrayList<Tetromino> tetrominos;
    Tetromino fallingTetromino;

    public Game(Board board) {
        this.board = board;
        tetrominos = new ArrayList<>();
        fallingTetromino = generateNewTetromino();
    }


    public void draw (Tetromino tetromino) {
        for(int i = 0; i < tetromino.stateOfTetromino.length; i++) {
            for(int j = 0; j < tetromino.stateOfTetromino[i].length; j++) {
                board.grid[tetromino.Position.getX()+i][tetromino.Position.getY()+j] = tetromino.stateOfTetromino[i][j];
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

    public Tetromino generateNewTetromino() {
        Tetromino tetromino = new Tetromino(board);
        tetrominos.add(tetromino);
        return tetromino;
    }

    public void cannotMove() {
        if (!fallingTetromino.moveDown()) {
            fallingTetromino = generateNewTetromino();
        }
    }
    public void userInput(int command) {
        switch (command) {
            case 1 -> {
                fallingTetromino.moveLeft();
                updateBoard(tetrominos);
            }
            case 2 -> {
                fallingTetromino.moveRight();
                updateBoard(tetrominos);
            }
            case 3 -> {
                fallingTetromino.rotateClockwise();
                updateBoard(tetrominos);
            }
            case 4 -> {
                fallingTetromino.rotateAntiClockwise();
                updateBoard(tetrominos);
            }
            default -> System.out.println("Invalid command number");
        }
            //TODO: moveDown automatically by given time
    }
}
