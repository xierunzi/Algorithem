package demo.algorithem;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xierz
 * @date 2021/11/15
 */
public class Q1TwoSum {
    public static void main(String[] args) {

    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        Integer index;
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int need = target - current;
            if ((index = map.get(need)) != null) {
                return new int[]{index, i};
            } else {
                map.put(current, i);
            }
        }
        return new int[0];
    }
}
