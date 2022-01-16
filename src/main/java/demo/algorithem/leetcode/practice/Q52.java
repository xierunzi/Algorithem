package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/16
 */
public class Q52 {
    public static void main(String[] args) {
        System.out.println(new Q52().totalNQueens(4));
    }

    public int totalNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        int[][] board = new int[n][n];
        inner(result, n, 0, board);
        return result.size();
    }

    private void inner(List<List<String>> result, int n, int currentRow, int[][] board) {
        if (currentRow >= n) {
            result.add(Collections.emptyList());
            return;
        }
        for (int i = 0; i < n; i++) {
            board[currentRow][i] = 1;
            if (valid(board, currentRow, i, n)) {
                inner(result, n, currentRow + 1, board);
            }
            board[currentRow][i] = 0;
        }
    }

    private List<String> getStringFromBoard(int[][] board, int n) {
        List<String> result = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder builder = new StringBuilder();
            for (int j = 0; j < n; j++) {
                builder.append(board[i][j] == 0 ? "." : "Q");
            }
            result.add(builder.toString());
        }
        return result;
    }

    private boolean valid(int[][] board, int row, int column, int n) {
        for (int i = 0; i < n; i++) {
            if (i != row && board[i][column] == 1) {
                return false;
            }
            if (i == 0) {
                continue;
            }
            if (row - i >= 0 && column - i >= 0) {
                if (board[row - i][column - i] == 1) {
                    return false;
                }
            }
            if (row - i >= 0 && column + i < n) {
                if (board[row - i][column + i] == 1) {
                    return false;
                }
            }
            if (row + i < n && column - i >= 0) {
                if (board[row + i][column - i] == 1) {
                    return false;
                }
            }
            if (row + i < n && column + i < n) {
                if (board[row + i][column + i] == 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
