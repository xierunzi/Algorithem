package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func maxDepth(root *TreeNode) int {
	result := 0
	tmp := depth(root, 0)
	if tmp > result {
		result = tmp
	}
	return result
}

func depth(node *TreeNode, lastDepth int) int {
	if node == nil {
		return lastDepth
	}
	curDepth := lastDepth + 1
	leftDepth := depth(node.Left, curDepth)
	rightDepth := depth(node.Right, curDepth)
	nextDepth := leftDepth
	if leftDepth < rightDepth {
		nextDepth = rightDepth
	}
	if curDepth < nextDepth {
		return nextDepth
	}
	return curDepth
}
