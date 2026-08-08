package main

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

func main() {
	root := &TreeNode{Val: 1, Left: nil, Right: nil}
	root.Left = &TreeNode{Val: 2, Left: nil, Right: nil}
	root.Right = &TreeNode{Val: 3, Left: nil, Right: nil}
	root.Left.Left = &TreeNode{Val: 4, Left: nil, Right: nil}
	root.Left.Right = &TreeNode{Val: 5, Left: nil, Right: nil}
	root.Left.Left.Left = &TreeNode{Val: 6, Left: nil, Right: nil}
	root.Left.Right.Left = &TreeNode{Val: 7, Left: nil, Right: nil}
	root.Left.Left.Left.Left = &TreeNode{Val: 8, Left: nil, Right: nil}
	root.Left.Right.Left.Left = &TreeNode{Val: 9, Left: nil, Right: nil}
	println(diameterOfBinaryTree(root))
}

func diameterOfBinaryTree(root *TreeNode) int {
	_, maxDistance := solve(root, 0)
	return maxDistance
}

func solve(root *TreeNode, depth int) (int, int) {
	if root == nil {
		return depth - 1, 0
	}
	leftDepth, leftDistance := solve(root.Left, depth+1)
	rightDepth, rightDistance := solve(root.Right, depth+1)
	distance := leftDepth + rightDepth - 2*depth
	if leftDistance > distance {
		distance = leftDistance
	}
	if rightDistance > distance {
		distance = rightDistance
	}
	maxDepth := leftDepth
	if rightDepth > maxDepth {
		maxDepth = rightDepth
	}
	return maxDepth, distance
}
