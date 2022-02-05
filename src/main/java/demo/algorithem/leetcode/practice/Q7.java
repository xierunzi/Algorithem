package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/5
 */
public class Q7 {
    public static void main(String[] args) {
        System.out.println(new Q7().reverse(-1847412));
    }

    public int reverse(int x) {
        long result = 0;
        boolean positive = x > 0;
        int threshold = positive ? Integer.MAX_VALUE / 10 : Integer.MIN_VALUE / 10;
        int max = positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        while (x != 0) {
            int last = x % 10;
            if (positive && result > threshold) {
                return 0;
            } else if (!positive && result < threshold) {
                return 0;
            } else {
                result *= 10;
                if ((positive && result > max - last) || (!positive && result < max - last)) {
                    return 0;
                }
                result += last;
            }
            x /= 10;
        }
        return (int) result;
    }
}
