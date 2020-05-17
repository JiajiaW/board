package com.jia.board.algorithm.dynamic;

public class T72EditDistance {

    public static int minDistance1(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();
        char[] char1 = word1.toCharArray();
        char[] char2 = word2.toCharArray();

        return getEditDistance(char1, m, char2, n, 0, 0, 0);
    }

    private static int getEditDistance(char[] char1, int m, char[] char2, int n, int i, int j, int dist) {

        if (i == m) {
            return dist + (n - j);
        }
        if (j == n) {
            return dist + (m - i);
        }

        if (char1[i] == char2[j]) {
            return getEditDistance(char1, m, char2, n, i + 1, j + 1, dist);
        } else {
            int d1 = getEditDistance(char1, m, char2, n, i + 1, j, dist + 1);
            int d2 = getEditDistance(char1, m, char2, n, i, j + 1, dist + 1);
            int d3 = getEditDistance(char1, m, char2, n, i+1, j+1, dist + 1);
            return min(d1, d2, d3);
//            return min(getEditDistance(char1, m, char2, n, i + 1, j, dist + 1),
//                    getEditDistance(char1, m, char2, n, i, j + 1, dist + 1),
//                    getEditDistance(char1, m, char2, n, i+1, j+1, dist + 1));
        }
    }

    public static int min(int a, int b, int c){
        int minValue = Integer.MAX_VALUE;
        if (a < minValue){
            minValue = a;
        }
        if (b < minValue){
            minValue = b;
        }
        if (c < minValue){
            minValue = c;
        }
        return minValue;
    }

    public static int minDistance(String word1, String word2) {

        int m = word1.length();
        int n = word2.length();

        if (m == 0){
            return n;
        }
        if (n == 0){
            return m;
        }

        char[] a = word1.toCharArray();
        char[] b = word2.toCharArray();

        int[][] status = new int[m][n];
        // 初始化第0行
        for (int j=0; j<n; j++){
           if (a[0] == b[j]){
               status[0][j] = j;
           } else if (j != 0){
               status[0][j] = status[0][j-1] + 1;
           } else {
               status[0][j] = 1;
           }
        }

        // 初始化第0列
        for (int i=0; i<m; i++){
            if (b[0] == a[i]){
                status[i][0] = i;
            }else if (i != 0){
                status[i][0] = status[i-1][0] + 1;
            }else {
                status[i][0] = 1;
            }
        }

        for (int i=1; i<m; i++){
            for (int j=1; j<n; j++){
                if (a[i] == b[j]){
                    status[i][j] = min(status[i-1][j-1], status[i][j-1]+1, status[i-1][j]+1);
                }
                if (a[i] != b[j]){
                    status[i][j] = min(status[i-1][j-1], status[i][j-1], status[i-1][j]) + 1;
                }
            }
        }

        return status[m-1][n-1];

    }


    public static void main(String[] args) {
        String word1 = "intention";
        String word2 = "execution";
        System.out.println(minDistance(word1, word2));
    }


}
