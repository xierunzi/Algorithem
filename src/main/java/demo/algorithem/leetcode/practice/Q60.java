package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author xierz
 * @date 2022/2/22
 */
public class Q60 {
    public static void main(String[] args) {
        System.out.println(new Q60().getPermutation(3, 6));
    }

    public String getPermutation(int n, int k) {
        List<Integer> list = new ArrayList<>();
        int sum = 1;
        for (int i = 1; i <= n; i++) {
            list.add(i);
            sum *= i;
        }
        StringBuilder builder = new StringBuilder();
        AtomicInteger remain = new AtomicInteger(k);
        for (int i = n; i > 0; i--) {
            if (sum != 1) {
                sum /= i;
                builder.append(list.remove(calculateNum(sum, n, remain) - 1));
            } else {
                builder.append(list.get(0));
            }
        }
        return builder.toString();
    }

    private int calculateNum(int gap, int current, AtomicInteger remain) {
        int k = remain.get();
        boolean flag = k % gap == 0;
        int index = k / gap + (flag ? 0 : 1);
        remain.set(flag ? gap : k % gap);
        return index;
    }

}
