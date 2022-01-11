package demo.algorithem.leetcode.practice;

import java.util.Arrays;

/**
 * @author xierz
 * @date 2022/1/12
 */
public class Q66 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Q66().plusOne(new int[]{4, 3, 2, 1})));
    }

    public int[] plusOne(int[] digits) {
        boolean addOne = true;
        for (int i = digits.length - 1; i >= 0; i--) {
            if (digits[i] == 9) {
                digits[i] = 0;
            } else {
                digits[i] = digits[i] + 1;
                addOne = false;
                break;
            }
        }
        if (addOne) {
            int[] res = new int[digits.length + 1];
            res[0] = 1;
            System.arraycopy(digits, 0, res, 1, digits.length);
            return res;
        }
        return digits;
    }
}
