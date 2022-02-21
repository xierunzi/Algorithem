package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/21
 */
public class Q69 {
    public static void main(String[] args) {
        System.out.println(new Q69().mySqrt(Integer.MAX_VALUE));
    }

    public int mySqrt(int x) {
        int start = 0;
        int end = x;
        int result = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if ((long) mid * mid <= x) {
                result = mid;
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return result;
    }
}
