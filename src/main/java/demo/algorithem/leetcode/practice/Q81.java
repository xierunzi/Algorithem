package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * @author xierz
 * @date 2022/3/20
 */
public class Q81 {

    public static void main(String[] args) {
        System.out.println(new Q81().search(new int[]{1, 1, 3}, 3));
    }

    public boolean search(int[] nums, int target) {
        if (nums.length == 1) {
            return nums[0] == target;
        }
        if (nums.length == 2) {
            return nums[0] == target || nums[1] == target;
        }
        int rotateIndex = -1;
        int num = nums[0];
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] < nums[i - 1] && nums[i] <= nums[i + 1]) {
                rotateIndex = i;
            }
        }
        if (nums[nums.length - 1] < nums[nums.length - 2]) {
            rotateIndex = nums.length - 1;
        }
        if (rotateIndex == -1) {
            rotateIndex = 0;
        }

        if (nums[rotateIndex] == target) {
            return true;
        } else if (nums[rotateIndex] > target) {
            return false;
        } else if (rotateIndex == 0) {
            return Arrays.binarySearch(nums, target) >= 0;
        } else {
            if (nums[0] <= target && nums[rotateIndex - 1] >= target) {
                return Arrays.binarySearch(nums, 0, rotateIndex, target) >= 0;
            } else if (nums[rotateIndex] <= target && nums[nums.length - 1] >= target) {
                return Arrays.binarySearch(nums, rotateIndex, nums.length, target) >= 0;
            } else {
                return false;
            }
        }
    }

}
