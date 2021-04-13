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
    int[][] initialState;
    Point initialPosition;

    public Tetromino(Board board) {
        this.board = board;
        this.shape = randomShape();
        this.positions = shape.coordinates;
        this.initialState = initialStateOfTetrimono();
        this.color = randomColor();
        this.initialPosition = initialPosition();
    }

    private int[][] initialStateOfTetrimono() {
        index = randomNumberGenerator.nextInt(positions.length);
        return positions[index];
    }

    Color[] colors = new Color[]{Color.cyan,Color.blue,Color.orange,Color.yellow, Color.green, Color.pink, Color.red};

    private Color randomColor() {
        int number = randomNumberGenerator.nextInt(colors.length);
        return colors[number];
    }

    private Point initialPosition() {
        int y = randomNumberGenerator.nextInt(board.getWidth()-width+1);
        return new Point(0,y);
    }

    private Shape randomShape() {
        return Shape.getRandomShape();
    }

    public void rotateClockwise() {
        if(positions.length != 1) {
            if(index == positions.length-1) {
                initialState = positions[0];
            } else {
                initialState = positions[++index];
            }
        }
    }

    public void rotateAntiClockwise() {
        if(positions.length != 1) {
            if(index == 0) {
                initialState = positions[positions.length-1];
            } else {
                initialState = positions[--index];
            }
        }
    }
}
