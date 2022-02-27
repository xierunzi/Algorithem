package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/2/27
 */
public class Q100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        if (p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

}
