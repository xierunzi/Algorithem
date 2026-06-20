package main

func main() {

}

type ListNode struct {
	Val  int
	Next *ListNode
}

func deleteMiddle(head *ListNode) *ListNode {
	if head.Next == nil {
		return nil
	}
	// len == 2 的特殊情况
	if head.Next.Next == nil {
		head.Next = nil
		return head
	}
	fast := head
	slow := head
	pre := &ListNode{}
	for {
		if fast.Next == nil {
			pre.Next = slow.Next
			break
		}
		if fast.Next != nil {
			fast = fast.Next
			if fast.Next != nil {
				fast = fast.Next
			}
		}
		pre = slow
		slow = slow.Next
	}
	return head
}
