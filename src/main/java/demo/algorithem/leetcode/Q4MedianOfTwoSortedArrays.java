package demo.algorithem.leetcode;

/**
 * @author xierz
 * @date 2021/11/16
 */
public class Q4MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        System.out.println(new Q4MedianOfTwoSortedArrays().findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1 == null && nums2 == null) {
            return 0;
        }
        if (nums1 == null) {
            nums1 = new int[0];
        }
        if (nums2 == null) {
            nums2 = new int[0];
        }


        int total = nums1.length + nums2.length;
        int targetIndex1 = total / 2;
        int targetIndex2 = total % 2 == 0 ? targetIndex1 - 1 : targetIndex1;

        int mid1 = -1;
        int mid2 = -1;
        int index1 = 0;
        int index2 = 0;
        int totalIndex = 0;
        while (index1 < nums1.length || index2 < nums2.length) {
            int tempVal1 = index1 >= nums1.length || nums1.length == 0 ? Integer.MAX_VALUE : nums1[index1];
            int tempVal2 = index2 >= nums2.length || nums2.length == 0 ? Integer.MAX_VALUE : nums2[index2];
            int val;
            if (tempVal1 < tempVal2) {
                val = tempVal1;
                index1++;
            } else {
                val = tempVal2;
                index2++;
            }
            if (totalIndex == targetIndex1) {
                mid1 = val;
            }
            if (totalIndex == targetIndex2) {
                mid2 = val;
            }
            if (mid1 != -1 && mid2 != -1) {
                break;
            }
            totalIndex++;
        }
        return (mid1 + mid2) / 2.0;
    }
}
