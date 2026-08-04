package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func inorderTraversal(root *TreeNode) []int {
	result := make([]int, 0)
	if root == nil {
		return result
	}
	inorder(root, &result)
	return result
}

func inorder(node *TreeNode, result *[]int) {
	if node == nil {
		return
	}
	inorder(node.Left, result)
	*result = append(*result, node.Val)
	inorder(node.Right, result)
}
