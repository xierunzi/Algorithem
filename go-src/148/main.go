package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	nodes := []*ListNode{
		{
			Val: -1,
		},
		{
			Val: 5,
		},
		{
			Val: 3,
		},
		{
			Val: 4,
		},
		{
			Val: 0,
		},
	}
	var pre *ListNode
	for _, node := range nodes {
		if pre != nil {
			pre.Next = node
		}
		pre = node
	}
	result := sortList(nodes[0])
	for result != nil {
		println(result.Val)
		result = result.Next
	}
}

func sortList(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	return sort(head, nil)
}

func sort(start, end *ListNode) *ListNode {
	if start == end || start.Next == nil {
		start.Next = nil
		return start
	}
	mid := findMid(start, end)
	midNext := mid.Next
	mid.Next = nil
	head1 := sort(start, mid)
	if midNext == nil {
		return head1
	}
	head2 := sort(midNext, end)
	return merge(head1, head2)
}

func merge(head1, head2 *ListNode) *ListNode {
	result := &ListNode{}
	cur := result
	for head1 != nil && head2 != nil {
		if head1.Val < head2.Val {
			cur.Next = head1
			head1 = head1.Next
		} else {
			cur.Next = head2
			head2 = head2.Next
		}
		cur = cur.Next
	}
	if head1 != nil {
		cur.Next = head1
	}
	if head2 != nil {
		cur.Next = head2
	}
	return result.Next
}

func findMid(start, end *ListNode) *ListNode {
	if start.Next == end {
		return start
	}
	slow := start
	fast := start
	for fast != end && fast.Next != end {
		slow = slow.Next
		fast = fast.Next.Next
	}
	return slow
}
