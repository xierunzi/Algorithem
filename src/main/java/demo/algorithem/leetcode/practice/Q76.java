package demo.algorithem.leetcode.practice;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author xierz
 * @date 2022/3/19
 */
public class Q76 {
    public static void main(String[] args) {
        System.out.println(new Q76().minWindow("adobecodebancbbcaa", "abc"));
    }

    public String minWindow(String s, String t) {
        if (t.length() > s.length()) {
            return "";
        }
        int[] lowCase = new int[26];
        int[] upperCase = new int[26];
        Set<Character> charSet = new HashSet<>(t.length());
        for (char c : t.toCharArray()) {
            markInArray(lowCase, upperCase, c, -1);
            charSet.add(c);
        }
        int fast = 0;
        int slow = -1;
        int min = Integer.MAX_VALUE;
        int resultStart = -1;
        int resultEnd = -1;
        Queue<Integer> indexQueue = new LinkedList<>();
        char[] originArray = s.toCharArray();
        while (fast < originArray.length) {
            char fastChar = originArray[fast];
            if (charSet.contains(fastChar)) {
                if (slow == -1) {
                    slow = fast;
                }
                indexQueue.offer(fast);
                markInArray(lowCase, upperCase, fastChar, 1);
                int minus = fast - slow;
                if (minus + 1 >= t.length()) {
                    if (isContain(lowCase, upperCase)) {
                        if (min > minus) {
                            resultStart = slow;
                            resultEnd = fast;
                            min = minus;
                        }

                        int nextSlow = -1;
                        while (!indexQueue.isEmpty()) {
                            nextSlow = indexQueue.poll();
                            if (nextSlow == slow) {
                                continue;
                            }
                            if (slow > -1) {
                                markInArray(lowCase, upperCase, originArray[slow], -1);
                            }
                            slow = nextSlow;
                            minus = fast - slow;
                            if (minus + 1 < t.length()) {
                                break;
                            }
                            if (isContain(lowCase, upperCase)) {
                                if (min > minus) {
                                    resultStart = slow;
                                    resultEnd = fast;
                                    min = minus;
                                }
                            } else {
                                break;
                            }
                        }
                        if (nextSlow == -1) {
                            break;
                        }
                    }
                }
            }
            fast++;
        }

        return resultEnd != -1 ? s.substring(resultStart, resultEnd + 1) : "";
    }

    private boolean isContain(int[] lowCase, int[] upperCase) {
        for (int temp : lowCase) {
            if (temp < 0) {
                return false;
            }
        }
        for (int temp : upperCase) {
            if (temp < 0) {
                return false;
            }
        }
        return true;
    }

    private void markInArray(int[] lowCase, int[] upperCase, char current, int num) {
        if (current <= 'Z') {
            upperCase[current - 'A'] += num;
        } else {
            lowCase[current - 'a'] += num;
        }
    }


}
