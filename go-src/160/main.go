package main

func main() {

}

func getIntersectionNode(headA, headB *ListNode) *ListNode {
	nodes := make(map[*ListNode]struct{})
	a := headA
	for a != nil {
		nodes[a] = struct{}{}
		a = a.Next
	}
	b := headB
	for b != nil {
		if _, ok := nodes[b]; ok {
			return b
		}
		b = b.Next
	}
	return nil
}

type ListNode struct {
	Val  int
	Next *ListNode
}
