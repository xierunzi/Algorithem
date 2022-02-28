package demo.algorithem.leetcode.practice;

/**
 * 暴力解
 * 题目意义不大
 *
 * @author xierz
 * @date 2021/11/28
 */
public class Q12 {

    public static void main(String[] args) {
        System.out.println(new Q12().intToRoman(58));
    }

    public String intToRoman(int num) {
        char[] nums = String.valueOf(num).toCharArray();
        int[] standardNums = new int[4];

        int delta = standardNums.length - nums.length;
        for (int i = 0; i < 4; i++) {
            if (i < delta) {
                standardNums[i] = 0;
            } else {
                standardNums[i] = nums[i - delta] - '0';
            }
        }

        StringBuilder builder = new StringBuilder();
        int current;
        if ((current = standardNums[0]) != 0) {
            for (int i = 0; i < current; i++) {
                builder.append("M");
            }
        }
        if ((current = standardNums[1]) != 0) {
            if (current == 5) {
                builder.append("D");
            } else if (current < 5) {
                if (current == 4) {
                    builder.append("CD");
                } else {
                    for (int i = 0; i < current; i++) {
                        builder.append("C");
                    }
                }
            } else {
                if (current == 9) {
                    builder.append("CM");
                } else {
                    builder.append("D");
                    for (int i = 0; i < current - 5; i++) {
                        builder.append("C");
                    }
                }
            }
        }
        if ((current = standardNums[2]) > 0) {
            if (current == 5) {
                builder.append("L");
            } else if (current < 5) {
                if (current == 4) {
                    builder.append("XL");
                } else {
                    for (int i = 0; i < current; i++) {
                        builder.append("X");
                    }
                }
            } else {
                if (current == 9) {
                    builder.append("XC");
                } else {
                    builder.append("L");
                    for (int i = 0; i < current - 5; i++) {
                        builder.append("X");
                    }
                }
            }
        }
        if ((current = standardNums[3]) > 0) {
            if (current == 5) {
                builder.append("V");
            } else if (current < 5) {
                if (current == 4) {
                    builder.append("IV");
                } else {
                    for (int i = 0; i < current; i++) {
                        builder.append("I");
                    }
                }
            } else {
                if (current == 9) {
                    builder.append("IX");
                } else {
                    builder.append("V");
                    for (int i = 0; i < current - 5; i++) {
                        builder.append("I");
                    }
                }
            }
        }
        return builder.toString();
    }
}
