package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
	addOne := false
	cur := &ListNode{}
	head := cur
	for l1 != nil || l2 != nil {
		val := 0
		if addOne {
			val++
			addOne = false
		}
		if l1 != nil {
			val += l1.Val
			l1 = l1.Next
		}
		if l2 != nil {
			val += l2.Val
			l2 = l2.Next
		}
		if val > 9 {
			addOne = true
			val = val - 10
		}
		cur.Next = &ListNode{Val: val}
		cur = cur.Next
	}
	if addOne {
		cur.Next = &ListNode{Val: 1}
	}
	return head.Next
}
