package demo.algorithem;

import java.util.LinkedList;

/**
 * @author xierz
 * @date 2021/11/18
 */
public class Q8StringToInteger {
    public static void main(String[] args) {
        System.out.println(new Q8StringToInteger().myAtoi("10000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000000522545459"));
    }

    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        Character first = null;
        int firstIndex = 0;
        for (int i = 0; i < chars.length; i++) {
            char current = chars[i];
            if (isNumber(current)) {
                first = current;
                firstIndex = i;
                break;
            }
            if (current == '-' || current == '+') {
                first = current;
                firstIndex = i;
                break;
            }
            if (current == ' ' || current == '0') {
                continue;
            }
            break;
        }
        if (first == null) {
            return 0;
        }
        LinkedList<Character> numbers = new LinkedList<>();
        int start = 1;
        boolean negative = false;
        if (isNumber(first)) {
            numbers.add(first);
            start = firstIndex + 1;
        } else {
            if (chars.length <= firstIndex + 1) {
                return 0;
            }
            negative = first == '-';
            char afterSymbol = chars[firstIndex + 1];
            if (isNumber(afterSymbol)) {
                start = firstIndex + 1;
            } else {
                return 0;
            }
        }
        for (int i = start; i < chars.length; i++) {
            char current = chars[i];
            if (isNumber(current)) {
                numbers.add(current);
            } else {
                break;
            }
        }

        if (numbers.isEmpty()) {
            return 0;
        }

        long temp = 1;
        long sum = 0;
        boolean outOfRange = false;
        for (int i = numbers.size() - 1; i >= 0; i--) {
            long num = numbers.get(i) - 48;
            sum += num * temp;
            if (sum > Integer.MAX_VALUE || (num != 0 && outOfRange)) {
                return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }
            if (Long.MAX_VALUE / 10 < temp) {
                outOfRange = true;
            }
            temp *= 10;
        }
        return negative ? (int) (-1 * sum) : (int) sum;
    }

    private boolean isNumber(char val) {
        return val >= '0' && val <= '9';
    }
}
