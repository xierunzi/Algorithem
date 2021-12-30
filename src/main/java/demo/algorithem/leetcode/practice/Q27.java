package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * @author xierz
 * @date 2021/12/30
 */
public class Q27 {

    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 2, 3};
        System.out.println(new Q27().removeElement(nums, 3));
        System.out.println(Arrays.toString(nums));
    }

    public int removeElement(int[] nums, int val) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1 && nums[0] == val) {
            nums[0] = 0;
            return 0;
        }
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                continue;
            }
            nums[left++] = nums[i];
        }
        return left;
    }
}
