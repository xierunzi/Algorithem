package main

func main() {

}

func mergeTwoLists(list1 *ListNode, list2 *ListNode) *ListNode {
	if list1 == nil {
		return list2
	}
	if list2 == nil {
		return list1
	}
	head := &ListNode{}
	cur := head
	for list1 != nil && list2 != nil {
		if list1.Val <= list2.Val {
			cur.Next = list1
			list1 = list1.Next
			cur = cur.Next
			continue
		}
		cur.Next = list2
		cur = cur.Next
		list2 = list2.Next
	}
	if list1 != nil {
		for list1 != nil {
			cur.Next = list1
			cur = cur.Next
			list1 = list1.Next
		}
	}
	if list2 != nil {
		for list2 != nil {
			cur.Next = list2
			cur = cur.Next
			list2 = list2.Next
		}
	}
	return head.Next
}

type ListNode struct {
	Val  int
	Next *ListNode
}
