package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func isSymmetric(root *TreeNode) bool {
	return check(root.Left, root.Right)
}

func check(root1, root2 *TreeNode) bool {
	if root1 == nil || root2 == nil {
		return root1 == root2
	}
	if root1.Val != root2.Val {
		return false
	}
	return check(root1.Left, root2.Right) && check(root1.Right, root2.Left)
}
