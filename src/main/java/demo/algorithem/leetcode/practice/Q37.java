package demo.algorithem.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * @author xierz
 * @date 2022/3/1
 */
public class Q37 {
    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        new Q37().solveSudoku(board);
        System.out.println();
    }

    public void solveSudoku(char[][] board) {
        Set[][] unitUsedSets = new HashSet[3][3];
        Set[] rowUsedSets = new HashSet[9];
        Set[] columnUsedSets = new HashSet[9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (rowUsedSets[i] == null) {
                    rowUsedSets[i] = new HashSet();
                }
                if (columnUsedSets[j] == null) {
                    columnUsedSets[j] = new HashSet();
                }
                int x = i / 3;
                int y = j / 3;
                if (unitUsedSets[x][y] == null) {
                    unitUsedSets[x][y] = new HashSet();
                }
                if (board[i][j] != '.') {
                    rowUsedSets[i].add(board[i][j]);
                    columnUsedSets[j].add(board[i][j]);
                    unitUsedSets[x][y].add(board[i][j]);
                }
            }
        }
        doSolve(board, unitUsedSets, rowUsedSets, columnUsedSets, 0, 0);
    }

    private boolean doSolve(char[][] board, Set[][] unitUsedSets, Set[] rowUsedSets, Set[] columnUsedSets, int x, int y) {
        for (int i = x; i < board.length; i++) {
            for (int j = 0; j < board.length; j++) {
                if (board[i][j] != '.') {
                    continue;
                }
                Set unit = unitUsedSets[i / 3][j / 3];
                Set row = rowUsedSets[i];
                Set column = columnUsedSets[j];
                for (char k = '1'; k <= '9'; k++) {
                    if (!unit.add(k)) {
                        continue;
                    }
                    if (!row.add(k)) {
                        unit.remove(k);
                        continue;
                    }
                    if (!column.add(k)) {
                        unit.remove(k);
                        row.remove(k);
                        continue;
                    }
                    board[i][j] = k;
                    if (doSolve(board, unitUsedSets, rowUsedSets, columnUsedSets, i, j + 1)) {
                        return true;
                    }
                    board[i][j] = '.';
                    unit.remove(k);
                    column.remove(k);
                    row.remove(k);
                }
                if (row.size() < board.length) {
                    return false;
                }
            }
        }
        return true;
    }
}
