package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/9
 */
public class Q58 {
    public static void main(String[] args) {
        System.out.println(new Q58().lengthOfLastWord("Hello World"));
    }

    public int lengthOfLastWord(String s) {
        char[] chars = s.toCharArray();
        boolean wordStart = false;
        int len = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] != ' ') {
                len++;
                wordStart = true;
            } else if (wordStart && chars[i] == ' ') {
                return len;
            }
        }
        return len;
    }
}
