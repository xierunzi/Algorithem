package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * @author xierz
 * @date 2022/1/22
 */
public class Q75 {
    public static void main(String[] args) {
        int[] nums = new int[]{2};
        new Q75().sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }

    public void sortColors(int[] nums) {
        int red = 0;
        int white = 0;
        for (int num : nums) {
            if (num == 0) {
                red++;
            } else if (num == 1) {
                white++;
            }
        }
        white += red;
        for (int i = 0; i < nums.length; i++) {
            if (i < red) {
                nums[i] = 0;
            } else if (i < white) {
                nums[i] = 1;
            } else {
                nums[i] = 2;
            }
        }
    }
}
