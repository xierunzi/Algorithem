package demo.algorithem;

/**
 * @author xierz
 * @date 2021/11/28
 */
public class Q10ContainerWithMostWater {

    public static void main(String[] args) {
        int[] param = new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(new Q10ContainerWithMostWater().maxArea(param));
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
