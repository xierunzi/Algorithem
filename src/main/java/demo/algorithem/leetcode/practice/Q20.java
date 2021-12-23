package demo.algorithem.leetcode.practice;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Objects;

/**
 * 用栈特性
 *
 * @author xierz
 * @date 2021/12/24
 */
public class Q20 {
    public static void main(String[] args) {
        System.out.println(new Q20().isValid("(}[]{}"));
    }

    private static final Map<Character, Character> MATCH_MAP = new HashMap<>(3);

    static {
        MATCH_MAP.put('(', ')');
        MATCH_MAP.put('{', '}');
        MATCH_MAP.put('[', ']');
    }

    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        char[] chars = s.toCharArray();
        for (char current : chars) {
            if (MATCH_MAP.containsKey(current)) {
                stack.add(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char exist = stack.removeLast();
                if (!Objects.equals(MATCH_MAP.get(exist), current)) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
