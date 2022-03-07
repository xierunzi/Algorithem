package demo.algorithem.leetcode.practice;

import java.util.Deque;
import java.util.LinkedList;
import java.util.function.Function;

/**
 * @author xierz
 * @date 2022/3/7
 */
public class Q42 {
    public static void main(String[] args) {
        System.out.println(new Q42().trap(new int[]{4, 2, 0, 3, 2, 5}));
    }

    public int trap(int[] height) {
        Deque<Integer> deque = new LinkedList<>();
        int max = 0;
        int total = 0;

        for (int j : height) {
            if (deque.isEmpty() || j < max) {
                if (deque.isEmpty() && j == 0) {
                    continue;
                }
                deque.offer(j);
                if (max == 0) {
                    max = j;
                }
                continue;
            }
            total += calculate(deque, true);
            deque.offer(j);
            max = j;
        }
        if (!deque.isEmpty()) {
            total += calculate(deque, false);
        }
        return total;
    }

    private int calculate(Deque<Integer> deque, boolean fromHead) {
        Function<Deque<Integer>, Integer> function = fromHead ? Deque::pollFirst : Deque::pollLast;
        int total = 0;
        int first = -1;
        while (!deque.isEmpty()) {
            if (first == -1) {
                first = function.apply(deque);
            } else {
                while (!deque.isEmpty()) {
                    int current = function.apply(deque);
                    if (current > first) {
                        first = current;
                        break;
                    }
                    total += first - current;
                }
            }
        }
        return total;
    }
}
