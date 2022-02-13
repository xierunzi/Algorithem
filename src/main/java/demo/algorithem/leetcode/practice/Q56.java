package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author xierz
 * @date 2022/2/13
 */
public class Q56 {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] o) -> o[0]).thenComparingInt(o -> o[1]));
        List<int[]> result = new ArrayList<>();
        int index = 0;
        for (int[] interval : intervals) {
            if (result.isEmpty()) {
                result.add(interval);
                continue;
            }
            int[] pre = result.get(index);
            if (pre[1] >= interval[0]) {
                pre[1] = Math.max(interval[1], pre[1]);
            } else {
                index++;
                result.add(interval);
            }
        }
        return result.toArray(new int[][]{});
    }
}
