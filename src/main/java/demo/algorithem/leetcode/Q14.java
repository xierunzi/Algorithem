package demo.algorithem.leetcode;

/**
 * 最长公共前缀
 * 暴力解，时间复杂度还好
 *
 * @author xierz
 * @date 2021/12/20
 */
public class Q14 {
    public static void main(String[] args) {
        System.out.println(new Q14().longestCommonPrefix(new String[]{"dog", "racecar", "car"}));
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        int minLen = Integer.MAX_VALUE;
        for (String temp : strs) {
            if (temp.length() == 0) {
                return "";
            }
            minLen = Math.min(temp.length(), minLen);
        }
        for (int i = 0; i < minLen; i++) {
            Character currentChar = null;
            for (String str : strs) {
                Character temp = str.charAt(i);
                if (currentChar == null) {
                    currentChar = temp;
                } else if (!currentChar.equals(temp)) {
                    return i == 0 ? "" : strs[0].substring(0, i);
                }
            }
        }
        return strs[0].substring(0, minLen);
    }
}
