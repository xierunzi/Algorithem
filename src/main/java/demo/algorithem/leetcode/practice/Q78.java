package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/25
 */
public class Q78 {

    public static void main(String[] args) {
        System.out.println(new Q78().subsets(new int[]{1}));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(Collections.emptyList());
        inner(result, nums, 0, new LinkedList<>());
        return result;
    }

    private void inner(List<List<Integer>> result, int[] nums, int current, Deque<Integer> temp) {
        for (int i = current; i < nums.length; i++) {
            temp.addLast(nums[i]);
            result.add(new ArrayList<>(temp));
            inner(result, nums, i + 1, temp);
            temp.removeLast();
        }
    }
}
