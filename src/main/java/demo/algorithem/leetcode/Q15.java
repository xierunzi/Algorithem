package demo.algorithem.leetcode;

import java.util.*;

/**
 * 三数之和
 * 排序后双指针
 *
 * @author xierz
 * @date 2021/12/20
 */
public class Q15 {

    public static void main(String[] args) {
        System.out.println(new Q15().threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int arrayLength = nums.length;
        if (arrayLength < 3) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        List<List<Integer>> answers = new ArrayList<>();
        for (int i = 0; i < arrayLength; i++) {
            int current = nums[i];
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int target = -current;
            int start = i + 1;
            int end = arrayLength - 1;
            while (start < end) {
                if (start > i + 1 && nums[start] == nums[start - 1]) {
                    start++;
                    continue;
                }
                if (end < arrayLength - 1 && nums[end] == nums[end + 1]) {
                    end--;
                    continue;
                }
                int temp = nums[start] + nums[end];
                if (temp == target) {
                    answers.add(Arrays.asList(current, nums[start], nums[end]));
                    start++;
                    end--;
                } else if (temp > target) {
                    end--;
                } else {
                    start++;
                }
            }
        }
        return answers;
    }

    static class Answer {
        public int first;

        public int second;

        public int third;

        public Answer(int first, int second, int third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Answer answer = (Answer) o;
            return first == answer.first && second == answer.second && third == answer.third;
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }


}
