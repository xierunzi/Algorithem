package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 类似Q15、Q16
 * 排序加双指针
 * 核心在于剪枝逻辑减少重复计算
 *
 * @author xierz
 * @date 2021/12/22
 */
public class Q18 {

    public static void main(String[] args) {
        System.out.println(new Q18().fourSum(new int[]{0, 0, 0, 1000000000, 1000000000, 1000000000, 1000000000}, 1000000000));
    }

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int size = nums.length;
        if (size < 4) {
            return Collections.emptyList();
        }
        Arrays.sort(nums);
        Set<List<Integer>> answers = new HashSet<>();
        for (int i = 0; i < size - 3; i++) {
            if (i >= 1 && nums[i - 1] == nums[i]) {
                continue;
            }
            if (i + 4 <= size && (long) nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            if ((long) nums[i] + nums[size - 1] + nums[size - 2] + nums[size - 3] < target) {
                continue;
            }
            for (int j = i + 1; j < size - 2; j++) {
                if (j != i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (j + 3 <= size && (long) nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if ((long) nums[i] + nums[size - 1] + nums[size - 2] + nums[j] < target) {
                    continue;
                }
                int innerTarget = target - nums[i] - nums[j];
                int start = j + 1;
                int end = size - 1;
                while (start < end) {
                    if (start != j + 1 && nums[start] == nums[start - 1]) {
                        start++;
                        continue;
                    }
                    if (end != size - 1 && nums[end] == nums[end + 1]) {
                        end--;
                        continue;
                    }
                    int temp = nums[start] + nums[end];
                    if (temp == innerTarget) {
                        answers.add(Arrays.asList(nums[i], nums[j], nums[start], nums[end]));
                        start++;
                        end--;
                    } else if (temp < innerTarget) {
                        start++;
                    } else {
                        end--;
                    }
                }
            }
        }
        return new ArrayList<>(answers);
    }
}
