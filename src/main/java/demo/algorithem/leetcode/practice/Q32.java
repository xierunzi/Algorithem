package demo.algorithem.leetcode.practice;

/**
 * 一共就两种情况：
 * 1. ()
 * 2. ((()))类型
 * 从动态规划的角度来看，只需要找到)，并且判断加上当前的右括号和能否是有效括号
 * 如果有效，那么就向前判断是左括号还是右括号，左括号比较简单，简单计算后就能知道是否为有效括号
 * 如果是右括号，那么需要跳过上一个右括号的有效长度，到前面去寻找是否存在对应的左括号
 * <p>
 * 需要注意的是每次计算dp时，都需要加上当前括号有效括号前一位的有效括号长度
 * 防止出现类似这种情况：()()，只统计了后面的一对括号而漏掉了前面
 *
 * @author xierz
 * @date 2022/3/6
 */
public class Q32 {
    public int longestValidParentheses(String s) {
        int[] dp = new int[s.length()];
        int max = 0;
        char[] chars = s.toCharArray();
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    // 需要加上前面已知的最大长度，case: ()()
                    dp[i] = i >= 2 ? dp[i - 2] + 2 : 2;
                } else if (i - dp[i - 1] > 0 && chars[i - dp[i - 1] - 1] == '(') {
                    // 同上，case: ()((())))
                    dp[i] = dp[i - 1] + ((i - dp[i - 1]) >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
