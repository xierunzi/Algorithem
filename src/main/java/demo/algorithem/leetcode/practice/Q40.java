package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/6
 */
public class Q40 {

    public static void main(String[] args) {
        System.out.println(new Q40().combinationSum2(new int[]{1, 2, 2, 5, 2}, 5));
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);
        inner(result, candidates, target, 0, new LinkedList<>(), 0);
        return result;
    }

    private void inner(List<List<Integer>> result, int[] nums, int target, int current, LinkedList<Integer> linkedList, int start) {
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            if (current + nums[i] < target) {
                linkedList.addLast(nums[i]);
                inner(result, nums, target, current + nums[i], linkedList, i + 1);
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
