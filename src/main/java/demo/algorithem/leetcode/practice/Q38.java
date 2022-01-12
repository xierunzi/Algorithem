package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/12
 */
public class Q38 {
    public static void main(String[] args) {
        System.out.println(new Q38().countAndSay(10));
    }

    public String countAndSay(int n) {
        String origin = "1";
        for (int i = 1; i < n; i++) {
            origin = init(origin);
        }
        return origin;
    }

    private String init(String origin) {
        char[] chars = origin.toCharArray();
        StringBuilder builder = new StringBuilder();
        char cur = chars[0];
        int count = 1;
        for (int i = 1; i < chars.length; i++) {
            if (chars[i] == chars[i - 1]) {
                count++;
            } else {
                builder.append(count);
                builder.append(cur);
                count = 1;
                cur = chars[i];
            }
        }
        builder.append(count);
        builder.append(cur);
        return builder.toString();
    }
}
