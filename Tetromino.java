package Tetris;

import java.util.Random;
import java.awt.Color;

public class Tetromino {
    Random randomNumberGenerator = new Random();
    Shape shape;
    Board board;
    int height;
    int width;
    Color color;
    int index;
    int[][][] positions;
    int[][] stateOfTetrimono;
    Point Position;

    public Tetromino(Board board) {
        this.board = board;
        this.shape = randomShape();
        this.positions = shape.coordinates;
        this.stateOfTetrimono = initialStateOfTetrimono();
        setWidthAndHeight(stateOfTetrimono);
        this.color = randomColor();
        this.Position = initialPosition();
    }
    //sets width and height according to the shape
    private void setWidthAndHeight(int[][] stateOfTetrimono) {
        int maxWidth = stateOfTetrimono[0].length;
        for(int i = 1; i < stateOfTetrimono.length;i++) {
            if(stateOfTetrimono[i].length > maxWidth) {
                maxWidth = stateOfTetrimono[i].length;
            }
        }
        this.width = maxWidth;
        this.height = stateOfTetrimono.length;
    }

    //randomly generate the initial state of tetromino
    private int[][] initialStateOfTetrimono() {
        index = randomNumberGenerator.nextInt(positions.length);
        return positions[index];
    }

    Color[] colors = new Color[]{Color.cyan,Color.blue,Color.orange,Color.yellow, Color.green, Color.pink, Color.red};

    //randomly generates the color of tetromino
    private Color randomColor() {
        int number = randomNumberGenerator.nextInt(colors.length);
        return colors[number];
    }

    //randomly generates the initial position of tetromino
    private Point initialPosition() {
        int y = randomNumberGenerator.nextInt(board.width-width+1);
        return new Point(0,y);
    }

    //randomly generates the shape of tetromino
    private Shape randomShape() {
        return Shape.getRandomShape();
    }


    //TODO: correct rotate center

    public void rotateClockwise() { //does nothing if it is impossible to rotate
        if(height < board.width-Position.getY()) {
            if(positions.length != 1) {
                if(index == positions.length-1) {
                    stateOfTetrimono = positions[0];
                    setWidthAndHeight(stateOfTetrimono);
                } else {
                    stateOfTetrimono = positions[++index];
                    setWidthAndHeight(stateOfTetrimono);
                }
            }
        }
    }

    public void rotateAntiClockwise() { //does nothing if it is impossible to rotate
        if(height < board.width-Position.getY()) {
            if(positions.length != 1) {
                if(index == 0) {
                    stateOfTetrimono = positions[positions.length-1];
                    setWidthAndHeight(stateOfTetrimono);
                } else {
                    stateOfTetrimono = positions[--index];
                    setWidthAndHeight(stateOfTetrimono);
                }
            }
        }
    }

    public void moveLeft() { //does nothing if it is impossible to move left
        if(Position.getY() != 0) {
            Position = new Point(Position.getX(), Position.getY()-1 );
        }
    }
    public void moveRight() {
        if(width < board.width-Position.getY()) { //does nothing if it is impossible to move right
            Position = new Point(Position.getX(), Position.getY()+1 );
        }
    }

    public void moveDown() {
        //TODO: check whether it has met another tetromino
        Position = new Point(Position.getX()+1, Position.getY());
    }

    //TODO: check if one tetromino meets another tetromino
    //TODO: add hard drop and gradually drop




}
