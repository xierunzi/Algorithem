package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/5
 */
public class Q6 {
    public static void main(String[] args) {
        System.out.println(new Q6().convert("PAYPALISHIRING", 3));
    }

    public String convert(String s, int numRows) {
        if (s.length() == 0) {
            return "";
        }
        if (numRows == 1) {
            return s;
        }
        StringBuilder[] res = new StringBuilder[numRows];
        for (int i = 0; i < res.length; i++) {
            res[i] = new StringBuilder();
        }
        boolean isDown = false;
        char[] chars = s.toCharArray();
        int index = 0;
        for (char aChar : chars) {
            res[index].append(aChar);
            if (index == numRows - 1 || index == 0) {
                isDown = !isDown;
            }
            index += isDown ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder re : res) {
            sb.append(re);
        }
        return sb.toString();
    }
}
