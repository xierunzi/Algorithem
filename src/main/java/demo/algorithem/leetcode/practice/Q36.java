package demo.algorithem.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xierz
 * @date 2022/1/1
 */
public class Q36 {

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'.', '.', '.', '3', '.', '.', '.', '1', '.'},
                {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '8', '2', '7', '.'},
                {'1', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '5', '.', '.', '.', '.', '.'},
                {'2', '.', '.', '.', '8', '.', '.', '.', '7'},
                {'7', '.', '.', '.', '.', '.', '.', '.', '.'},
                {'.', '.', '.', '.', '.', '.', '.', '.', '.'}
        };
        System.out.println(new Q36().isValidSudoku(board));
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (i % 3 == 0 && j % 3 == 0 && !checkInner(board, i, j)) {
                    return false;
                }
                if (i == 0) {
                    Set<Character> existNums = new HashSet<>();
                    for (int k = 0; k < 9; k++) {
                        if (board[k][j] != '.' && !existNums.add(board[k][j])) {
                            return false;
                        }
                    }
                }
            }
            Set<Character> existNums = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.' && !existNums.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkInner(char[][] board, int startX, int startY) {
        Set<Character> exist = new HashSet<>();
        for (int i = startX; i < startX + 3; i++) {
            for (int j = startY; j < startY + 3; j++) {
                if (board[i][j] != '.' && !exist.add(board[i][j])) {
                    return false;
                }
            }
        }
        return true;
    }
}
