package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * binary search
 *
 * @author xierz
 * @date 2022/1/21
 */
public class Q74 {
    public static void main(String[] args) {
        int[][] param = new int[][]{
                {1}
        };
        System.out.println(new Q74().searchMatrix(param, 1));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int top = 0;
        int bottom = matrix.length - 1;
        int mid = 0;
        while (top < bottom) {
            mid = (top + bottom) >> 1;
            if (matrix[mid][0] > target) {
                bottom = mid - 1;
            } else if (matrix[mid][0] < target) {
                top = mid + 1;
            } else {
                return true;
            }
        }
        if (top < matrix.length) {
            if (matrix[top][0] > target && top > 0) {
                return Arrays.binarySearch(matrix[top - 1], target) >= 0;
            } else if (matrix[top][0] < target) {
                return Arrays.binarySearch(matrix[top], target) >= 0;
            } else if (matrix[top][0] == target) {
                return true;
            }
        }
        return false;
    }

}
