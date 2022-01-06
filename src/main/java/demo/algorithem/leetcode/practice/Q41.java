package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/6
 */
public class Q41 {

    public static void main(String[] args) {
        System.out.println(new Q41().firstMissingPositive(new int[]{3, 1}));
    }

    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            int cur = nums[i];
            if (cur >= 1 && cur <= len) {
                int temp;
                while (true) {
                    temp = nums[cur - 1];
                    nums[cur - 1] = cur;
                    if (temp == cur || temp <= 0 || temp > len) {
                        break;
                    }
                    cur = temp;
                }
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
