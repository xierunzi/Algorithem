package demo.algorithem.leetcode.practice;

/**
 * 双指针基础题
 *
 * @author xierz
 * @date 2021/11/23
 */
public class Q9 {
    public static void main(String[] args) {
        System.out.println(new Q9().isPalindrome(101101));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (x <= 9) {
            return true;
        }
        char[] chars = String.valueOf(x).toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            if (chars[start++] != chars[end--]) {
                return false;
            }
        }
        return true;
    }
}
