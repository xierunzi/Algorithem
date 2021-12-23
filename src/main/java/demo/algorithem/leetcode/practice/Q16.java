package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * 最接近的三数之和
 * 类似上一题排序后双指针
 *
 * @author xierz
 * @date 2021/12/20
 */
public class Q16 {
    public static void main(String[] args) {
        System.out.println(new Q16().threeSumClosest(new int[]{-3, -2, -5, 3, -4}, -1));
    }

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int arrayLength = nums.length;
        int result = target >= 0 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        for (int i = 0; i < arrayLength; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int goal = target - nums[i];
            int start = i + 1;
            int end = arrayLength - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (end < arrayLength - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                int temp = nums[start] + nums[end];
                if (temp == goal) {
                    return target;
                } else {
                    int sum = nums[start] + nums[end] + nums[i];
                    if (Math.abs(result - target) > Math.abs(sum - target)) {
                        result = sum;
                    }
                    if (temp > goal) {
                        end--;
                    } else {
                        start++;
                    }
                }
            }
        }
        return result;
    }
}
