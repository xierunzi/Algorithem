package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xierz
 * @date 2022/1/13
 */
public class Q46 {
    public static void main(String[] args) {
        System.out.println(new Q46().permute(new int[]{1, 2, 3}));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        inner(result, nums, new LinkedList<>(), new HashSet<>());
        return result;
    }

    private void inner(List<List<Integer>> result, int[] nums, Deque<Integer> deque, Set<Integer> indexSet) {
        for (int i = 0; i < nums.length; i++) {
            if (!indexSet.add(i)) {
                continue;
            }
            deque.offer(nums[i]);
            if (deque.size() == nums.length) {
                result.add(new ArrayList<>(deque));
            } else {
                inner(result, nums, deque, indexSet);
            }
            deque.removeLast();
            indexSet.remove(i);
        }
    }
}
