package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/1/9
 */
public class Q67 {
    public static void main(String[] args) {
        System.out.println(new Q67().addBinary("1010", "1011"));
    }

    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int index1 = a.length() - 1;
        int index2 = b.length() - 1;
        char[] chars1 = a.toCharArray();
        char[] chars2 = b.toCharArray();
        boolean addOne = false;
        while (index1 >= 0 || index2 >= 0) {
            int val1 = index1 >= 0 ? chars1[index1] - 48 : 0;
            int val2 = index2 >= 0 ? chars2[index2] - 48 : 0;
            int sum = val1 + val2 + (addOne ? 1 : 0);
            if (sum == 0 || sum == 1) {
                builder.insert(0, sum);
                addOne = false;
            } else {
                builder.insert(0, sum - 2);
                addOne = true;
            }
            index1--;
            index2--;
        }
        if (addOne) {
            builder.insert(0, 1);
        }
        return builder.toString();
    }
}
