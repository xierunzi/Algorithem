package demo.algorithem.leetcode;

import java.util.*;

/**
 * 回溯
 *
 * @author xierz
 * @date 2021/12/21
 */
public class Q17 {
    public static void main(String[] args) {
        System.out.println(new Q17().letterCombinations(""));
    }

    private static final Map<Character, List<Character>> CHAR_MAP = new HashMap<>();

    static {
        CHAR_MAP.put('2', Arrays.asList('a', 'b', 'c'));
        CHAR_MAP.put('3', Arrays.asList('d', 'e', 'f'));
        CHAR_MAP.put('4', Arrays.asList('g', 'h', 'i'));
        CHAR_MAP.put('5', Arrays.asList('j', 'k', 'l'));
        CHAR_MAP.put('6', Arrays.asList('m', 'n', 'o'));
        CHAR_MAP.put('7', Arrays.asList('p', 'q', 'r', 's'));
        CHAR_MAP.put('8', Arrays.asList('t', 'u', 'v'));
        CHAR_MAP.put('9', Arrays.asList('w', 'x', 'y', 'z'));
    }

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        inner(new StringBuilder(), digits, 0, result);
        return result;
    }

    public void inner(StringBuilder builder, String digits, int currentIndex, List<String> result) {
        boolean shouldReturn = currentIndex == digits.length() - 1;
        List<Character> letters = CHAR_MAP.get(digits.charAt(currentIndex));
        for (Character letter : letters) {
            builder.append(letter);
            if (shouldReturn) {
                result.add(builder.toString());
            } else {
                inner(builder, digits, currentIndex + 1, result);
            }
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
