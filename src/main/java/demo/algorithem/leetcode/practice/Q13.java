package demo.algorithem.leetcode.practice;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 罗马数字转换题
 * 和Q11区别在于不再暴力解了，而是抽象出公共方法
 *
 * @author xierz
 * @date 2021/12/24
 */
public class Q13 {
    public static void main(String[] args) {
        System.out.println(new Q13().romanToInt("LVIII"));
    }

    private static final Map<Integer, DecodePattern> PATTERN_MAP = new HashMap<>(4);

    static {
        PATTERN_MAP.put(1, new DecodePattern('I', 'V', 'X'));
        PATTERN_MAP.put(10, new DecodePattern('X', 'L', 'C'));
        PATTERN_MAP.put(100, new DecodePattern('C', 'D', 'M'));
        PATTERN_MAP.put(1000, new DecodePattern('M', null, null));
    }

    public int romanToInt(String s) {
        int sum = 0;
        int startIndex = 0;
        int level = 1000;
        while (startIndex < s.length() && level > 0) {
            DecodeResult result = decode(s, startIndex, level);
            sum = sum + result.result * level;
            startIndex = result.endIndex;
            level /= 10;
        }
        return sum;
    }

    private DecodeResult decode(String s, int startIndex, int level) {
        DecodePattern pattern = PATTERN_MAP.get(level);
        int result = 0;
        for (int i = startIndex; i < s.length(); i++) {
            char current = s.charAt(i);
            if (Objects.equals(current, pattern.tenChar)) {
                return new DecodeResult(9, i + 1);
            } else if (Objects.equals(current, pattern.fiveChar)) {
                if (i == startIndex) {
                    result += 5;
                } else {
                    return new DecodeResult(4, i + 1);
                }
            } else if (Objects.equals(current, pattern.oneChar)) {
                result++;
            } else {
                return new DecodeResult(result, i);
            }
        }
        return new DecodeResult(result, s.length());
    }

    static class DecodeResult {
        int result;
        int endIndex;

        public DecodeResult(int result, int endIndex) {
            this.result = result;
            this.endIndex = endIndex;
        }

        public static DecodeResult defaultResult(int index) {
            return new DecodeResult(0, index);
        }
    }

    static class DecodePattern {
        Character oneChar;
        Character fiveChar;
        Character tenChar;

        public DecodePattern(Character oneChar, Character fiveChar, Character tenChar) {
            this.oneChar = oneChar;
            this.fiveChar = fiveChar;
            this.tenChar = tenChar;
        }
    }
}
