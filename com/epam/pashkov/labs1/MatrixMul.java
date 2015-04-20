package com.epam.pashkov.labs1;

/**
 * Created by Yaroslav on 19.04.2015.
 */
public class MatrixMul {
    public static int[][] mul(int[][] a, int[][] b) {
        if (a == null || b == null) {
            throw new IllegalArgumentException();
        }

        if (a[0].length != b.length) {
            throw new IllegalArgumentException();
        }

        int[][] c = new int[a.length][b[0].length];

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < b[0].length; j++) {
                int sum = 0;
                for (int r = 0; r < b.length; r++) {
                    try {
                        sum += a[i][r] * b[r][j];
                    } catch (Exception e) {
                        throw new IllegalArgumentException();
                    }
                }
                c[i][j] = sum;
            }
        }

        return c;
    }
}
