package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/27
 */
public class Q5 {
    public static void main(String[] args) {
        System.out.println(new Q5().longestPalindrome("abcba"));
    }

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len == 1) {
            return s;
        }
        boolean[][] isPalindrome = new boolean[len][len];
        int maxStart = 0;
        int maxEnd = 0;
        int maxLen = 0;
        for (int i = 0; i < len; i++) {
            isPalindrome[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int i = 1; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int index = j + i;
                if (j + i >= len || chars[index] != chars[j]) {
                    continue;
                }
                if (i == 1 || (j + 1 < len && isPalindrome[j + 1][index - 1])) {
                    isPalindrome[j][index] = true;
                    if (maxLen < i) {
                        maxLen = i;
                        maxStart = j;
                        maxEnd = index;
                    }
                }
            }
        }
        return s.substring(maxStart, maxEnd + 1);
    }
}
