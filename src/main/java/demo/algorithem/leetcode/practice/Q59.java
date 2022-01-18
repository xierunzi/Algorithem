package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/18
 */
public class Q59 {
    public static void main(String[] args) {
        new Q59().generateMatrix(4);
    }

    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        // 0 right 1 down 2 left 3 up
        int symbol = 0;
        int i = 0;
        int j = 0;
        int num = 1;
        while (true) {
            if (i < 0 || i >= n || j < 0 || j >= n || res[i][j] != 0) {
                break;
            }
            res[i][j] = num++;
            if (symbol == 0) {
                if (j + 1 >= n || res[i][j + 1] != 0) {
                    i++;
                    symbol++;
                } else {
                    j++;
                }
            } else if (symbol == 1) {
                if (i + 1 >= n || res[i + 1][j] != 0) {
                    j--;
                    symbol++;
                } else {
                    i++;
                }
            } else if (symbol == 2) {
                if (j - 1 < 0 || res[i][j - 1] != 0) {
                    i--;
                    symbol++;
                } else {
                    j--;
                }
            } else {
                if (i - 1 < 0 || res[i - 1][j] != 0) {
                    j++;
                    symbol++;
                } else {
                    i--;
                }
            }
            if (symbol == 4) {
                symbol = 0;
            }
        }
        return res;
    }
}
