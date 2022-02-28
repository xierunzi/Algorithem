package demo.algorithem.leetcode.practice;

/**
 * 盛水最多的容器
 * 双指针
 * <p>
 * 因为容器的体积为 两指针的距离*两指针中较小的那个指针的高度
 * 所以双指针从两头开始向中间遍历，固定其中一个变量距离，然后选取较小的指针向中间移动一位
 *
 * @author xierz
 * @date 2021/11/28
 */
public class Q11 {

    public static void main(String[] args) {
        int[] param = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q11().maxArea(param));
    }

    public int maxArea(int[] height) {
        int len = height.length;
        if (len == 2) {
            return Math.min(height[0], height[1]);
        }
        int left = 0;
        int right = len - 1;
        int max = -1;
        while (left < right) {
            int leftVal = height[left];
            int rightVal = height[right];
            max = Math.max(max, Math.min(leftVal, rightVal) * (right - left));
            if (leftVal < rightVal) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}
