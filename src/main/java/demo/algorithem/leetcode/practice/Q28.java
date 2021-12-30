package demo.algorithem.leetcode.practice;

/**
 * 最优解是kmp，后面可以了解下
 *
 * @author xierz
 * @date 2021/12/31
 */
public class Q28 {
    public static void main(String[] args) {
        System.out.println(new Q28().strStr("abc", "c"));
    }

    public int strStr(String haystack, String needle) {
        if (needle == null || needle.length() == 0 || needle.equals(haystack)) {
            return 0;
        }
        int targetLen = needle.length();
        int sourceLen = haystack.length();
        if (targetLen > sourceLen) {
            return -1;
        }
        char[] chars = haystack.toCharArray();
        char[] target = needle.toCharArray();

        outer:
        for (int i = 0; i <= sourceLen - targetLen; i++) {
            if (chars[i] != target[0]) {
                continue;
            }
            for (int j = 1, start = i + 1; j < targetLen; j++, start++) {
                if (chars[start] != target[j]) {
                    continue outer;
                }
            }
            return i;
        }
        return -1;
    }
}
