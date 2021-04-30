package Tetris.Tetris;

import java.util.Random;
import java.awt.Color;

public class Tetromino   {
    Random randomNumberGenerator = new Random();
    Shape shape;
    int height;
    int width;
    int BOARD_WIDTH = 10;
    int BOARD_HEIGHT = 20;
    //TODO: decide how to change the currShapeX and currShapeY properly
    int currShapeX;
    int currShapeY;
    int[] numberOfNonZerosWidth;
    int[] numberOfNonZerosHeight;
    Color color;
    int index;
    int[][][] positions;
    int[][] stateOfTetromino;

    public Tetromino() {
        this.shape = Shape.T_SHAPE;
//        this.shape = randomShape();
        this.positions = shape.coordinates;
        this.stateOfTetromino = initialStateOfTetrimono();
        setWidthAndHeight();
        this.color = randomColor();
        this.currShapeX = 4; //change to 4 later
        this.currShapeY = 0;
    }
    //sets width and height according to the shape
    void setWidthAndHeight() {
        int r = stateOfTetromino.length;
        int c = stateOfTetromino[0].length;

        int[] h = new int[r];
        int[] w = new int[c];

        for (int i = 0; i < r; i++) {
            int count = 0;
            for (int j = 0; j < c; j++) {
                if(stateOfTetromino[i][j] != 0) {
                    w[j] += 1;
                    count += 1;
                }
            }
            h[i] = count;
        }

        this.numberOfNonZerosWidth = w;
        this.numberOfNonZerosHeight = h;

        int width = w.length;
        int height = h.length;
        for(int i: w) {
            if(i == 0) {
                width--;
            }
        }

        for(int i: h) {
            if(i == 0) {
                height--;
            }
        }
        this.width = width;
        this.height = height;
//        this.width = c;
//        this.height = r;
    }

    public boolean areSidesZeros(char side) {
        if(side == 'r') {
            return numberOfNonZerosWidth[numberOfNonZerosWidth.length-1] == 0;
        } else if( side == 'l') {
            return numberOfNonZerosWidth[0] == 0;
        } else if(side == 'd') {
            return (numberOfNonZerosHeight[numberOfNonZerosWidth.length-1] == 0) || (numberOfNonZerosHeight[numberOfNonZerosWidth.length-2] == 0);
        }
//        if(numberOfNonZerosWidth[0] == 0 || numberOfNonZerosWidth[2] == 0 || numberOfNonZerosHeight[0] == 0 || numberOfNonZerosHeight[2] == 0) {
//            return true;
//        }
        return false;
    }
    //randomly generate the initial state of tetromino
    private int[][] initialStateOfTetrimono() {
        index = randomNumberGenerator.nextInt(positions.length);
        return positions[index];
    }

    public int[][] getStateOfTetromino() {
        return stateOfTetromino;
    }

    Color[] colors = new Color[]{Color.cyan,Color.blue,Color.orange,Color.yellow, Color.green, Color.pink, Color.red};

    //randomly generates the color of tetromino
    private Color randomColor() {
        int number = randomNumberGenerator.nextInt(colors.length);
        return colors[number];
    }


    //randomly generates the shape of tetromino
    private Shape randomShape() {
        return Shape.getRandomShape();
    }


    //TODO: correct rotate center
    //TODO: correct rotation issue (calling to rotate to the same direction several time)
//
    public void rotateClockwise() { //does nothing if it is impossible to rotate
        if(currShapeX >= 5) {
            if(height/2 <= BOARD_WIDTH-currShapeX-1) { //changed /2
                if(positions.length > 1) {
                    if(index == positions.length-1) {
                        index = 0;
                    } else {
                        ++index;
                    }
                    stateOfTetromino = positions[index];
                    setWidthAndHeight();
                }
            }
        } else {
            if((height/2 <= currShapeX)) { //changed /2
                if(positions.length > 1) {
                    if(index == positions.length-1) {
                        index = 0;
                    } else {
                        ++index;
                    }
                    stateOfTetromino = positions[index];
                    setWidthAndHeight();
                }
            }
        }

    }

    //TODO: Delete anticlockwise and replace it with hard drop
    public void rotateAntiClockwise() { //does nothing if it is impossible to rotate
        if(currShapeX >= 5) {
            if((height/2 < BOARD_WIDTH - currShapeX)) { //changed /2
                if(positions.length > 1) {
                    if(index == 0) {
                        index = positions.length -1;
                    } else {
                        --index;
                    }
                    stateOfTetromino = positions[index];
                    setWidthAndHeight();
                }
            }
        } else {
            if((height/2 <= currShapeX)) { //changed /2
                if(positions.length > 1) {
                    if(index == 0) {
                        index = positions.length -1;
                    } else {
                        --index;
                    }
                    stateOfTetromino = positions[index];
                    setWidthAndHeight();
                }
            }
        }
//        || (height/2 < currShapeX-1)

    }


    //TODO: add hard drop




}
