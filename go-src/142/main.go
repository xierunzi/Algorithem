package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func detectCycle(head *ListNode) *ListNode {
	nodes := make(map[*ListNode]struct{})
	for head != nil {
		if _, ok := nodes[head]; ok {
			return head
		}
		nodes[head] = struct{}{}
		head = head.Next
	}
	return nil
}
