package demo.algorithem.leetcode.practice;

import java.util.Objects;

/**
 * @author xierz
 * @date 2022/2/15
 */
public class Q43 {
    public static void main(String[] args) {
        System.out.println(new Q43().multiply("123", "456"));
    }

    public String multiply(String num1, String num2) {
        if (Objects.equals("0", num1) || Objects.equals("0", num2)) {
            return "0";
        }
        char[] nums1 = num1.toCharArray();
        char[] nums2 = num2.toCharArray();
        int[] result = new int[num1.length() + num2.length()];
        for (int i = nums1.length - 1; i >= 0; i--) {
            for (int j = nums2.length - 1; j >= 0; j--) {
                result[i + j + 1] += (nums1[i] - '0') * (nums2[j] - '0');
            }
        }
        for (int i = result.length - 1; i > 0; i--) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }
        StringBuilder builder = new StringBuilder();
        for (int j : result) {
            if (builder.length() != 0 || j != 0) {
                builder.append(j);
            }
        }
        return builder.toString();
    }

    public int[] multiply(int num1, int num2, int zeroCount) {
        int[] result = new int[2 + zeroCount];
        int index = result.length - 1;
        for (int i = 0; i < zeroCount; i++) {
            index--;
        }
        int num = num1 * num2;
        while (num != 0) {
            result[index--] = num % 10;
            num /= 10;
        }
        return result;
    }

    public void add(int[] result, int[] adder) {
        boolean addOne = false;
        for (int i = 1; i <= result.length; i++) {
            int tempIndex = adder.length - i;
            if (tempIndex < 0 && !addOne) {
                break;
            }
            int index = result.length - i;
            int a = result[index];
            int b = tempIndex >= 0 ? adder[tempIndex] : 0;
            int sum = a + b + (addOne ? 1 : 0);
            addOne = sum >= 10;
            sum %= 10;
            result[index] = sum;
        }
    }
}
