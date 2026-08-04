package main

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
		{
			Val: 5,
		},
	}
	for i := 0; i < len(nodes); i++ {
		if i-1 >= 0 {
			nodes[i-1].Next = nodes[i]
		}
	}
	res := reverseKGroup(nodes[0], 3)
	for res != nil {
		println(res.Val)
		res = res.Next
	}
}

type ListNode struct {
	Val  int
	Next *ListNode
}

func reverseKGroup(head *ListNode, k int) *ListNode {
	count := 0
	var start, end, pre, result *ListNode
	cur := head
	for cur != nil {
		if start == nil {
			start = cur
		}
		count++
		if count < k {
			cur = cur.Next
			continue
		}
		end = cur
		nextCur := cur.Next
		if result == nil {
			result = end
		}
		reverse(start, end)
		count = 0
		if pre != nil {
			pre.Next = end
		}
		start.Next = nextCur
		pre = start
		start = nil
		end = nil
		cur = nextCur
	}
	return result
}

func reverse(start, end *ListNode) {
	cur := start
	var pre *ListNode
	for {
		nextCur := cur.Next
		cur.Next = pre
		pre = cur
		if cur == end {
			break
		}
		cur = nextCur
	}
}
