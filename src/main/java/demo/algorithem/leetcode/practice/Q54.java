package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/17
 */
public class Q54 {
    public static void main(String[] args) {
        int[][] param = new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
        };
        System.out.println(new Q54().spiralOrder(param));
    }

    public List<Integer> spiralOrder(int[][] matrix) {
        int[][] flags = new int[matrix.length][matrix[0].length];
        // 0 right 1 down 2 left 3 up
        int symbol = 0;
        List<Integer> result = new ArrayList<>();
        int i = 0;
        int j = 0;
        int maxI = matrix.length;
        int maxJ = matrix[0].length;
        while (true) {
            if (i < 0 || i >= maxI || j < 0 || j >= maxJ || flags[i][j] == 1) {
                break;
            }
            result.add(matrix[i][j]);
            flags[i][j] = 1;
            if (symbol == 0) {
                if (j + 1 >= maxJ || flags[i][j + 1] == 1) {
                    i++;
                    symbol++;
                } else {
                    j++;
                }
            } else if (symbol == 1) {
                if (i + 1 >= maxI || flags[i + 1][j] == 1) {
                    j--;
                    symbol++;
                } else {
                    i++;
                }
            } else if (symbol == 2) {
                if (j - 1 < 0 || flags[i][j - 1] == 1) {
                    i--;
                    symbol++;
                } else {
                    j--;
                }
            } else {
                if (i - 1 < 0 || flags[i - 1][j] == 1) {
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
        return result;
    }


}
