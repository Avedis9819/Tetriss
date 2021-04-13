package Tetris;

import java.util.Random;
public enum Shape {
    I_SHAPE(new int[][][]{{{1,1,1,1},{0,0,0,0}, {0,0,0,0},{0,0,0,0}}, {{0,0,0,1},{0,0,0,1},{0,0,0,1},{0,0,0,1}}}),
    J_SHAPE(new int[][][]{{{0,0,1},
            {0,0,1},
            {0,1,1}},
            {{1,0,0},
                    {1,1,1},
                    {0,0,0}},
            {{1,1,0},
                    {1,0,0},
                    {1,0,0}},
            {{0,0,0},
                    {1,1,1},
                    {0,0,1}}
    }),
    L_SHAPE(new int[][][]{{{1,0,0},
            {1,0,0},
            {1,1,0}},
            {{0,0,0},
                    {1,1,1},
                    {1,0,0}},
            {{0,1,1},
                    {0,0,1},
                    {0,0,1}},
            {{0,0,1},
                    {1,1,1},
                    {0,0,0}}
    }),
    O_SHAPE(new int[][][]{{{1,1,1},{1,1,1},{1,1,1}}}),
    S_SHAPE(new int[][][]{{{0,1,1},
            {1,1,0},
            {0,0,0}},
            {{1,0,0},
                    {1,1,0},
                    {0,1,0}}
    }),
    T_SHAPE(new int[][][]{{{0,0,0},
            {1,1,1},
            {0,1,0}},
            {{0,1,0},
                    {1,1,0},
                    {0,1,0}},
            {{0,1,0},
                    {1,1,1},
                    {0,0,0}},
            {{1,0,0},
                    {1,1,0},
                    {1,0,0}}
    }),
    Z_SHAPE(new int[][][]{{{0,1,1},
            {1,1,0},
            {0,0,0}},
            {{1,0,0},
                    {1,1,0},
                    {0,1,0}}
    });

    private static final Random randomNumberGenerator = new Random();
    int[][][] coordinates;


    Shape(int[][][] coordinates) {
        this.coordinates = coordinates;
    }

    public static Shape getRandomShape() {
        return Shape.values()[randomNumberGenerator.nextInt(Shape.values().length)];
    }
}
