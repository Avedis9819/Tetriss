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
                stateOfTetrimono = positions[0];
            } else {
                stateOfTetrimono = positions[++index];
            }
        }
    }

    public void rotateAntiClockwise() {
        if(positions.length != 1) {
            if(index == 0) {
                stateOfTetrimono = positions[positions.length-1];
            } else {
                stateOfTetrimono = positions[--index];
            }
        }
    }

    public void moveLeft() {
        if(Position.getY() != 0) {
            Position = new Point(Position.getX(), Position.getY()-1 );
        }
    }
    public void moveRight() {
        if(width < board.getWidth()-Position.getY()) {
            Position = new Point(Position.getX(), Position.getY()+1 );
        }
    }


}
