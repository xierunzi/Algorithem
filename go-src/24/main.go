package main

type ListNode struct {
	Val  int
	Next *ListNode
}

func main() {
	nodes := []*ListNode{
		{
			Val: 1,
		},
		{
			Val: 2,
		},
		{
			Val: 3,
		},
		{
			Val: 4,
		},
	}
	for i := 0; i < len(nodes); i++ {
		if i-1 >= 0 {
			nodes[i-1].Next = nodes[i]
		}
	}
	res := swapPairs(nodes[0])
	for res != nil {
		println(res.Val)
		res = res.Next
	}
}

func swapPairs(head *ListNode) *ListNode {
	if head == nil || head.Next == nil {
		return head
	}
	var result *ListNode
	cur := head
	var pre *ListNode
	for cur != nil {
		if result == nil {
			result = cur.Next
		}
		if cur.Next == nil {
			break
		}
		nextCur := cur.Next.Next
		cur.Next.Next = cur
		if pre != nil {
			pre.Next = cur.Next
		}
		cur.Next = nextCur
		pre = cur
		cur = nextCur
	}
	return result
}
