package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/24
 */
public class Q77 {
    public static void main(String[] args) {
        System.out.println(new Q77().combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        inner(result, 1, n, k, new LinkedList<>());
        return result;
    }

    private void inner(List<List<Integer>> result, int current, int n, int k, LinkedList<Integer> temp) {
        if (temp.size() == k) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = current; i <= n; i++) {
            temp.offer(i);
            inner(result, i + 1, n, k, temp);
            temp.removeLast();
        }
    }
}
