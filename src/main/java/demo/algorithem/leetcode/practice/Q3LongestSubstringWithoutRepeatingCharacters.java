package demo.algorithem.leetcode.practice;

import java.util.HashSet;
import java.util.Set;

/**
 * todo can be optimized
 *
 * @author xierz
 * @date 2021/11/15
 */
public class Q3LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        System.out.println(new Q3LongestSubstringWithoutRepeatingCharacters().lengthOfLongestSubstring("abba"));
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        int longest = 0;
        int start = 0;
        int end = 0;
        char[] chars = s.toCharArray();
        Set<Character> existChars = new HashSet<>();
        int len = chars.length;
        while (start < len && end < len) {
            boolean notExist = existChars.add(chars[end]);
            if (notExist) {
                end++;
                continue;
            }
            longest = Math.max(longest, end - start);
            start++;
            end = start;
            existChars.clear();
            if (len - start <= longest) {
                return longest;
            }
        }
        return Math.max(longest, end - start);
    }
}
