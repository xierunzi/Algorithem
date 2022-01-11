package demo.algorithem.leetcode.practice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author xierz
 * @date 2022/1/11
 */
public class Q88 {

    public static void main(String[] args) {
        int[] nums1 = new int[]{0, 0, 3, 0, 0, 0, 0, 0, 0};
        new Q88().merge(nums1, 3, new int[]{-1, 1, 1, 1, 2, 3}, 6);
        System.out.println(Arrays.toString(nums1));
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        Queue<Integer> temp = new LinkedList<>();
        int left = 0;
        int right = 0;
        while (left < m + n || right < n) {
            Integer val1 = null;
            if (left < m || !temp.isEmpty()) {
                val1 = temp.isEmpty() ? nums1[left] : temp.peek();
            }
            Integer val2 = right < n ? nums2[right] : null;
            if (val1 == null && val2 == null) {
                break;
            }
            if (val1 == null) {
                nums1[left++] = val2;
                right++;
            } else if (val2 == null || val1 <= val2) {
                if (left < m || val2 == null) {
                    temp.offer(nums1[left]);
                }
                nums1[left++] = val1;
                if (!temp.isEmpty()) {
                    temp.poll();
                }

            } else {
                if (left < m) {
                    temp.offer(nums1[left]);
                }
                nums1[left++] = val2;
                right++;
            }
        }
    }
}
