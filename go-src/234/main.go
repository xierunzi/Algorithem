package main

func main() {

}

func isPalindrome(head *ListNode) bool {
	var values []int
	for head != nil {
		values = append(values, head.Val)
		head = head.Next
	}
	left, right := 0, len(values)-1
	for left < right {
		if values[left] != values[right] {
			return false
		}
		left++
		right--
	}
	return true
}

type ListNode struct {
	Val  int
	Next *ListNode
}
