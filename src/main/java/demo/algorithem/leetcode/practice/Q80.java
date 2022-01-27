package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/27
 */
public class Q80 {
    public static void main(String[] args) {
        System.out.println(new Q80().removeDuplicates(new int[]{1, 1, 1, 2, 2, 3}));
    }

    public int removeDuplicates(int[] nums) {
        if (nums.length < 3) {
            return nums.length;
        }
        int sameCount = 1;
        int slow = 1;
        int fast = 1;
        while (fast < nums.length) {
            if (nums[fast] == nums[fast - 1]) {
                if (sameCount < 2) {
                    sameCount++;
                    nums[slow++] = nums[fast++];
                } else {
                    sameCount = 0;
                    fast++;
                    while (fast < nums.length && nums[fast] == nums[fast - 1]) {
                        fast++;
                    }

                }
            } else {
                nums[slow++] = nums[fast++];
                sameCount = 1;
            }
        }
        return slow;
    }
}
