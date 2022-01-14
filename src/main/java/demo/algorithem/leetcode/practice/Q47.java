package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xierz
 * @date 2022/1/14
 */
public class Q47 {

    public static void main(String[] args) {
        System.out.println(new Q47().permuteUnique(new int[]{1, 3, 2}));
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        inner(result, nums, new LinkedList<>(), new HashSet<>(), 0);
        return result;
    }

    private void inner(List<List<Integer>> result, int[] nums, Deque<Integer> deque, Set<Integer> indexSet, int depth) {
        Set<Integer> exist = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!indexSet.add(i)) {
                continue;
            }
            if (!exist.add(nums[i]) && i > 0 && nums[i] == nums[i - 1]) {
                indexSet.remove(i);
                continue;
            }

            deque.offer(nums[i]);
            if (deque.size() == nums.length) {
                result.add(new ArrayList<>(deque));
            } else {
                inner(result, nums, deque, indexSet, depth + 1);
            }
            deque.removeLast();
            indexSet.remove(i);
        }
    }
}
