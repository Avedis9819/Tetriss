package Tetris;

import java.util.Random;
public enum Shape { //Do not have figures that have all 0s in the first row
    I_SHAPE(new int[][][]{{{1,1,1,1}}, {{1},{1},{1},{1}}}),
    J_SHAPE(new int[][][]{{{0,1},
            {0,1},
            {1,1}},
            {{1,0,0},
             {1,1,1}},
            {{1,1},
             {1,0},
             {1,0}},
            {{1,1,1},
             {0,0,1}}
    }),
    L_SHAPE(new int[][][]{{
            {1,0},
            {1,0},
            {1,1}},
            {{1,1,1},
             {1,0,0}},
            {{1,1},
             {0,1},
             {0,1}},
            {{0,0,1},
             {1,1,1}}}),
    O_SHAPE(new int[][][]{{{1,1,1},{1,1,1},{1,1,1}}}),
    S_SHAPE(new int[][][]{{
        {0,1,1},
        {1,1,0}},
        {{1,0},
         {1,1},
         {0,1}}
    }),
    T_SHAPE(new int[][][]{{
        {1,1,1},
        {0,1,0}},
        {{0,1},
         {1,1},
         {0,1}},
         {{0,1,0},
          {1,1,1}},
         {{1,0},
          {1,1},
          {1,0}}
    }),
    Z_SHAPE(new int[][][]{{
        {0,1,1},
        {1,1,0}},
        {{1,0},
         {1,1},
         {0,1}}
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
