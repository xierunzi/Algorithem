package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/26
 */
public class Q79 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(new Q79().exist(board, "ABCCED"));
    }

    public boolean exist(char[][] board, String word) {
        char[] wordChars = word.toCharArray();
        boolean[][] arrived = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backtrack(board, wordChars, arrived, 0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backtrack(char[][] board, char[] word, boolean[][] arrived, int index, int x, int y) {
        if (board[x][y] != word[index]) {
            return false;
        }
        if (word.length - 1 == index) {
            return true;
        }
        arrived[x][y] = true;
        if (x + 1 < board.length && !arrived[x + 1][y] && backtrack(board, word, arrived, index + 1, x + 1, y)) {
            return true;
        }
        if (y + 1 < board[0].length && !arrived[x][y + 1] && backtrack(board, word, arrived, index + 1, x, y + 1)) {
            return true;
        }
        if (x - 1 >= 0 && !arrived[x - 1][y] && backtrack(board, word, arrived, index + 1, x - 1, y)) {
            return true;
        }
        if (y - 1 >= 0 && !arrived[x][y - 1] && backtrack(board, word, arrived, index + 1, x, y - 1)) {
            return true;
        }
        arrived[x][y] = false;
        return false;
    }
}
