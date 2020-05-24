package com.jia.board.offer;

public class T04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1) {
            return false;
        }
        int n = matrix.length;
        int m = matrix[0].length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean findNumberIn2DArray1(int[][] matrix, int target) {

        if (matrix == null || matrix.length < 1) {
            return false;
        }

        int n = matrix.length;
        int m = matrix[0].length;
        int i = 0;
        int j = m - 1;
        while (i < n && j >= 0) {
            if (matrix[i][j] == target) {
                return true;
            }
            if (matrix[i][j] > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        int target = 5;
        System.out.println(findNumberIn2DArray1(matrix, 20));
    }
}
