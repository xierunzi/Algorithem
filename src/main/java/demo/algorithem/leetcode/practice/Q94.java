package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/1/9
 */
public class Q94 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inner(root, res);
        return res;
    }

    private void inner(TreeNode node, List<Integer> result) {
        if (node == null) {
            return;
        }
        inner(node.left, result);
        result.add(node.val);
        inner(node.right, result);
    }

}
