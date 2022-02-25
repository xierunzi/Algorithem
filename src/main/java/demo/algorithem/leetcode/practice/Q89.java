package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xierz
 * @date 2022/2/25
 */
public class Q89 {
    public static void main(String[] args) {
        System.out.println(new Q89().grayCode(2));
    }

    private Map<Integer, List<Integer>> cache = new HashMap<>();

    public List<Integer> grayCode(int n) {
        if (cache.containsKey(n)) {
            return cache.get(n);
        }
        return calculate(1, n, cache.computeIfAbsent(1, key -> Arrays.asList(0, 1)), 1);
    }

    private List<Integer> calculate(int current, int n, List<Integer> currentList, int flag) {
        if (current == n) {
            return currentList;
        }
        current++;
        flag = flag << 1;
        List<Integer> next = new ArrayList<>(currentList);
        for (int i = currentList.size() - 1; i >= 0; i--) {
            next.add(currentList.get(i) | flag);
        }
        return calculate(current, n, next, flag);
    }
}
