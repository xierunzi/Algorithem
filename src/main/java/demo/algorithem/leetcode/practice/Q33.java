package demo.algorithem.leetcode.practice;

/**
 * 意义不大，暴力解已经0ms...
 * logn时间复杂度解法思路：
 * 1. 类似二分查找。找到mid坐标的值
 * 2. 根据num[mid]可以确认旋转点在left区间还是right区间
 * 3. 根据target的实际大小，选择继续在left区间还是right区间来进行二分
 *
 * @author xierz
 * @date 2022/1/3
 */
public class Q33 {

    public int search(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

}
