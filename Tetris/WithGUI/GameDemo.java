package Tetris.Tetris.WithGUI;

import Tetris.Tetris.IntroPage;

import java.util.ArrayList;
import java.util.Scanner;

public class GameDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
//        Board board = new Board();

        IntroPage game = new IntroPage();
//
//        //creates dynamic array of tetromino
//        ArrayList<Tetromino> tetrominos = new ArrayList<Tetromino>();
//        Tetromino tetromino = new Tetromino(board);
//        tetrominos.add(tetromino);
//
//        System.out.println("Position: " + tetromino.Position);
//        System.out.println("Width: " + tetromino.width);
//        System.out.println();
//
//        //print the tetromino
//        for (int i = 0; i < tetromino.stateOfTetrimono.length; i++) {
//            for (int j = 0; j < tetromino.stateOfTetrimono[i].length; j++) {
//                System.out.print(tetromino.stateOfTetrimono[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();
//
//        //Print board
//        for (int i = 0; i < board.grid.length; i++) {
//            for (int j = 0; j < board.grid[i].length; j++) {
//                System.out.print(board.grid[i][j] + " ");
//            }
//            System.out.println();
//        }
//        System.out.println();


//        //user control
//        boolean isMenuActive = true;
//        while (isMenuActive) {
//            System.out.println("Enter command number");
//            System.out.println("1. do nothing");
//            System.out.println("2. move Right");
//            System.out.println("3. move Left");
//            System.out.println("4. rotate Clockwise");
//            System.out.println("5. rotate AntiClockwise");
//            System.out.println("6. Exit");
//
//            int command = keyboard.nextInt();

            //TODO: moveDown automatically by given time
//            switch (command) {
//                case 1 -> {
//                    tetromino.moveDown();
//                    game.updateBoard(tetrominos);
//                    board.printBoard();
//                }
//                case 2 -> {
//                    tetromino.moveDown();
//                    tetromino.moveRight();
//                    game.updateBoard(tetrominos);
//                    board.printBoard();
//                }
//                case 3 -> {
//                    tetromino.moveDown();
//                    tetromino.moveLeft();
//                    game.updateBoard(tetrominos);
//                    board.printBoard();
//                }
//                case 4 -> {
//                    tetromino.moveDown();
//                    tetromino.rotateClockwise();
//                    game.updateBoard(tetrominos);
//                    board.printBoard();
//                }
//                case 5 -> {
//                    tetromino.moveDown();
//                    tetromino.rotateAntiClockwise();
//                    game.updateBoard(tetrominos);
//                    board.printBoard();
//                }
//                case 6 -> {
//                    isMenuActive = false;
//                    System.out.println("Bye");
//                }
//                default -> System.out.println("Invalid command number");
//            }
//        }
//        }
    }
}
