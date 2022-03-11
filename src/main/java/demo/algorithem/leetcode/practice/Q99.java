package demo.algorithem.leetcode.practice;

import java.util.ArrayList;
import java.util.List;

/**
 * @author xierz
 * @date 2022/3/11
 */
public class Q99 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.left = node2;
        node2.right = node1;
        new Q99().recoverTree(root);
        System.out.println();
    }

    public void recoverTree(TreeNode root) {
        List<TreeNode> nodes = new ArrayList<>();
        readTree(root, nodes);
        Integer index1 = null;
        Integer index2 = null;
        for (int i = 0; i < nodes.size() - 1; i++) {
            if (index1 == null) {
                if (nodes.get(i).val > nodes.get(i + 1).val) {
                    index1 = i;
                    continue;
                }
            }
            if (index1 != null) {
                if (nodes.get(i).val > nodes.get(i + 1).val) {
                    index2 = i + 1;
                    break;
                }
            }
        }
        if (index2 != null) {
            swap(index1, index2, nodes);
        } else {
            swap(index1, index1 + 1, nodes);
        }
    }

    private void swap(int index1, int index2, List<TreeNode> nodes) {
        TreeNode node1 = nodes.get(index1);
        TreeNode node2 = nodes.get(index2);
        int temp = node1.val;
        node1.val = node2.val;
        node2.val = temp;
    }


    private void readTree(TreeNode node, List<TreeNode> nodes) {
        if (node == null) {
            return;
        }
        readTree(node.left, nodes);
        nodes.add(node);
        readTree(node.right, nodes);
    }
}
