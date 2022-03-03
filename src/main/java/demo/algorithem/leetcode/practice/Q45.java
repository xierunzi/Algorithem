package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/3/3
 */
public class Q45 {
    public static void main(String[] args) {
        System.out.println(new Q45().jump(new int[]{7, 0, 9, 6, 9, 6, 1, 7, 9, 0, 1, 2, 9, 0, 3}));
    }

    public int jump(int[] nums) {
        if (nums.length <= 1) {
            return 0;
        }
        int step = 0;
        int index = 0;
        int max = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            max = Math.max(max, i + nums[i]);
            if (i == index) {
                step++;
                index = max;
            }
        }
        return step;
    }
}
