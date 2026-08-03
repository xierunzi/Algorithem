package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func removeNthFromEnd(head *ListNode, n int) *ListNode {
	nodes := make(map[int]*ListNode, n)
	length := 0
	for head != nil {
		nodes[length] = head
		length++
		head = head.Next
	}
	preIndex := length - n - 1
	postIndex := length - n + 1
	if preIndex < 0 {
		return nodes[0].Next
	}
	nodes[preIndex].Next = nodes[postIndex]
	return nodes[0]
}
