package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * @author xierz
 * @date 2022/1/2
 */
public class Q34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q34().searchRange(new int[]{2, 2}, 2)));
    }

    public int[] searchRange(int[] nums, int target) {
        int index = Arrays.binarySearch(nums, target);
        if (index < 0) {
            return new int[]{-1, -1};
        }
        int leftRes = index;
        int rightRes = index;
        boolean left = false;
        boolean right = false;
        for (int i = 1; i < nums.length; i++) {
            if (index - i >= 0 && nums[index - i] == target) {
                leftRes = index - i;
            } else {
                left = true;
            }
            if (index + i < nums.length && nums[index + i] == target) {
                rightRes = index + i;
            } else {
                right = true;
            }
            if (left && right) {
                return new int[]{leftRes, rightRes};
            }
        }
        return new int[]{leftRes == -1 ? index : leftRes, rightRes == -1 ? index : rightRes};
    }
}
