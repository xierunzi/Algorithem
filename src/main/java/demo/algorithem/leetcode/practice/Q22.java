package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法穷举所有生成括号的可能
 *
 * @author xierz
 * @date 2021/12/25
 */
public class Q22 {

    public static void main(String[] args) {
        System.out.println(new Q22().generateParenthesis(1));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        inner(n, 0, 0, new StringBuilder(), result, true);
        return result;
    }

    private void inner(int total, int leftCount, int rightCount, StringBuilder builder, List<String> result, boolean left) {
        if (leftCount >= total) {
            return;
        }
        int addCount = 0;
        builder.append("(");
        leftCount++;
        addCount++;
        inner(total, leftCount, rightCount, builder, result, true);
        while (rightCount < leftCount) {
            builder.append(")");
            rightCount++;
            addCount++;
            if (leftCount < total) {
                inner(total, leftCount, rightCount, builder, result, false);
            }
            if (leftCount == total && rightCount == total) {
                result.add(builder.toString());
            }
        }
        for (int i = 0; i < addCount; i++) {
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
