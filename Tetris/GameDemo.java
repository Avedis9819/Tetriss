package Tetris;

import java.util.*;

import static Tetris.Game.tetrominos;

public class GameDemo {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        Board board = new Board();
        Game game = new Game(board);


        //creates dynamic array of tetromino

//        System.out.println("Position: "+tetromino.Position);
//        System.out.println("Width: " + tetromino.width);
//        System.out.println("Height: " + tetromino.height);
//        System.out.println();

        //print the tetromino
//        for(int i = 0; i < tetromino.stateOfTetromino.length; i++) {
//            for(int j = 0; j < tetromino.stateOfTetromino[i].length; j++) {
//                System.out.print(tetromino.stateOfTetromino[i][j]+" ");
//            }
//            System.out.println();
//        }
//        System.out.println();

        //update the board
        game.updateBoard(tetrominos);

        //Print board
        board.printBoard();

        //user input
        boolean isMenuActive = true;
        while(isMenuActive) {
            System.out.println("Enter command number");
            System.out.println("1. move Left");
            System.out.println("2. move Right");
            System.out.println("3. rotate Clockwise");
            System.out.println("4. rotate AntiClockwise");
            System.out.println("5. Exit");

            int command = keyboard.nextInt();
            game.cannotMove();
            game.userInput(command);
            board.printBoard();
            System.out.println("Size: " + tetrominos.size());
            if(command == 5) {
                isMenuActive = false;
                System.out.println("Bye");
            }
        }

        //TODO: keep previous tetrominos on the board

    }
}
