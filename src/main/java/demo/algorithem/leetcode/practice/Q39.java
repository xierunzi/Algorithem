package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * 回溯法
 *
 * @author xierz
 * @date 2022/1/5
 */
public class Q39 {
    public static void main(String[] args) {
        System.out.println(new Q39().combinationSum(new int[]{1}, 2));
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        Deque<Integer> deque = new LinkedList<>();
        inner(result, candidates, target, 0, new LinkedList<>(), 0);
        return new ArrayList<>(result);
    }

    private void inner(List<List<Integer>> result, int[] nums, int target, int current, LinkedList<Integer> linkedList, int start) {
        for (int i = start; i < nums.length; i++) {
            if (current + nums[i] < target) {
                linkedList.addLast(nums[i]);
                inner(result, nums, target, current + nums[i], linkedList, i);
                linkedList.removeLast();
            } else if (current + nums[i] == target) {
                linkedList.addLast(nums[i]);
                result.add(new ArrayList<>(linkedList));
                linkedList.removeLast();
            } else {
                break;
            }
        }
    }
}
