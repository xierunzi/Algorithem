package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * @author xierz
 * @date 2022/2/14
 */
public class Q31 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        new Q31().nextPermutation(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void nextPermutation(int[] nums) {
        if (nums.length == 0) {
            return;
        }
        boolean hasChanged = false;
        int minus = 1;
        while (!hasChanged && minus < nums.length) {
            int index = nums.length - 1 - minus;
            for (int i = nums.length - 1; i > index; i--) {
                if (nums[i] > nums[index]) {
                    for (int j = i; j > index; j--) {
                        int temp = nums[j];
                        nums[j] = nums[j - 1];
                        nums[j - 1] = temp;
                    }
                    Arrays.sort(nums, index + 1, nums.length);
                    hasChanged = true;
                    break;
                }
            }
            minus++;
        }
        if (hasChanged) {
            return;
        }
        Arrays.sort(nums);
    }
}
