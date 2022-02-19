package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/19
 */
public class Q50 {
    public static void main(String[] args) {
        System.out.println(new Q50().myPow(2, 10));
    }

    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }
        return n > 0 ? res : 1 / res;
    }

}
