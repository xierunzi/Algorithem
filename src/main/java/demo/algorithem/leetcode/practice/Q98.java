package demo.algorithem.leetcode.practice;

/**
 * @author xierz
 * @date 2022/3/8
 */
public class Q98 {
    public static void main(String[] args) {
        TreeNode node = new TreeNode(2);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(3);
        node.left = node1;
        node.right = node2;
        System.out.println(new Q98().isValidBST(node));
    }

    public boolean isValidBST(TreeNode root) {
        return isValid(root.left, null, root.val) && isValid(root.right, root.val, null);
    }

    private boolean isValid(TreeNode current, Integer min, Integer max) {
        if (current == null) {
            return true;
        }
        if (min != null && current.val <= min) {
            return false;
        }
        if (max != null && current.val >= max) {
            return false;
        }
        return isValid(current.left, min, current.val) && isValid(current.right, current.val, max);
    }
}
