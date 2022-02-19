package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/19
 */
public class Q48 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9},
        };
        new Q48().rotate(matrix);
        System.out.println();
    }

    public void rotate(int[][] matrix) {
        boolean[][] hasRotated = new boolean[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (hasRotated[i][j]) {
                    continue;
                }
                int x = i;
                int y = j;
                int stashValue = matrix[x][y];
                while (true) {
                    int nextX = y;
                    int nextY = matrix.length - 1 - x;
                    if (hasRotated[nextX][nextY]) {
                        break;
                    }
                    int temp = stashValue;
                    stashValue = matrix[nextX][nextY];
                    matrix[nextX][nextY] = temp;
                    x = nextX;
                    y = nextY;
                    hasRotated[x][y] = true;
                }
            }
        }
    }
}
