package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author xierz
 * @date 2022/2/27
 */
public class Q90 {

    public static void main(String[] args) {
        System.out.println(new Q90().subsetsWithDup(new int[]{4, 4, 4, 1, 4}));
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.emptyList());
        Arrays.sort(nums);
        inner(nums, 0, res, new LinkedList<>(), new HashSet<>());
        return res;
    }

    private void inner(int[] nums, int current, List<List<Integer>> res, Deque<Integer> temp, Set<List<Integer>> set) {
        for (int i = current; i < nums.length; i++) {
            temp.offer(nums[i]);
            List<Integer> list = new ArrayList<>(temp);
            if (set.add(list)) {
                res.add(list);
                inner(nums, i + 1, res, temp, set);
            }
            temp.removeLast();
        }
    }
}
