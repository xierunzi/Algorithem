package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/3/22
 */
public class Q85 {
    public static void main(String[] args) {
        char[][] param = new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '0', '0', '1'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '0'}
        };
        System.out.println(new Q85().maximalRectangle(param));
    }

    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) {
            return 0;
        }
        int[][][] area = new int[matrix.length][matrix.length][matrix[0].length];
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int m = 0; m < matrix[0].length; m++) {
                int colLimit = matrix[0].length;
                row:
                for (int j = i; j < matrix.length; j++) {
                    for (int k = m; k < colLimit; k++) {
                        if (i == j && m == k) {
                            if (matrix[i][m] == '1') {
                                area[i][j][k] = 1;
                            } else {
                                break row;
                            }
                        } else {
                            if (matrix[j][k] == '1') {
                                area[i][j][k] = (k - m > 0 ? k - m + 1 : 1) * (j - i > 0 ? j - i + 1 : 1);
                            } else {
                                colLimit = k;
                                if (j == i && k == 0) {
                                    break row;
                                }
                                break;
                            }
                        }
                        max = Math.max(max, area[i][j][k]);
                    }
                }
            }
        }
        return max;
    }
}
