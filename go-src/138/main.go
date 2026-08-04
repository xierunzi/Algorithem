package main

type Node struct {
	Val    int
	Next   *Node
	Random *Node
}

func copyRandomList(head *Node) *Node {
	cur := head
	var newHead, pre *Node
	nodesMap := make(map[*Node]*Node)
	for cur != nil {
		newCur := getOrInitNode(cur, nodesMap)
		if newHead == nil {
			newHead = newCur
		}
		if pre != nil {
			pre.Next = newCur
		}
		pre = newCur
		// handle random
		newRandom := getOrInitNode(cur.Random, nodesMap)
		newCur.Random = newRandom
		cur = cur.Next
	}
	return newHead
}

func getOrInitNode(oldNode *Node, existsMap map[*Node]*Node) *Node {
	if oldNode == nil {
		return nil
	}
	newNode := existsMap[oldNode]
	if newNode != nil {
		return newNode
	}
	newNode = &Node{Val: oldNode.Val}
	existsMap[oldNode] = newNode
	return newNode
}
