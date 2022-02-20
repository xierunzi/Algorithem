package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/2/20
 */
public class Q57 {
    public static void main(String[] args) {
        int[][] param = new int[][]{
                {3, 5}, {12, 15}
        };
        int[][] result = new Q57().insert(param, new int[]{6, 6});
        System.out.println();
    }

    public int[][] insert(int[][] intervals, int[] newInterval) {
        if (intervals.length == 0) {
            return new int[][]{newInterval};
        }
        if (newInterval[1] < intervals[0][0]) {
            int[][] result = new int[intervals.length + 1][];
            System.arraycopy(intervals, 0, result, 1, intervals.length);
            result[0] = newInterval;
            return result;
        }
        int start = newInterval[0];
        int end = newInterval[1];
        for (int i = 0; i < intervals.length; i++) {
            if (start <= intervals[i][0]) {
                return modifyEndPosition(intervals, end, i, start);
            } else {
                if (start <= intervals[i][1]) {
                    return modifyEndPosition(intervals, end, i, start);
                }
            }
        }
        int[][] result = new int[intervals.length + 1][];
        System.arraycopy(intervals, 0, result, 0, intervals.length);
        result[result.length - 1] = newInterval;
        return result;
    }

    private int[][] modifyEndPosition(int[][] intervals, int end, int currentIndex, int start) {
        List<int[]> result = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < intervals.length; i++) {
            if (!flag && i >= currentIndex) {
                flag = true;
                int[] temp = new int[2];
                temp[0] = Math.min(intervals[i][0], start);
                while (i < intervals.length && end > intervals[i][1]) {
                    i++;
                }
                if (i < intervals.length && end < intervals[i][0]) {
                    temp[1] = end;
                    result.add(temp);
                    result.add(intervals[i]);
                } else {
                    temp[1] = i < intervals.length ? Math.max(end, intervals[i][1]) : end;
                    result.add(temp);
                }
            } else {
                result.add(intervals[i]);
            }
        }
        return result.toArray(new int[][]{});
    }
}
