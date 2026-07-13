package main

import (
	"fmt"
)

func main() {
	fmt.Printf("%v\n", maxSlidingWindow([]int{1, 3, -1, -3, -5, -3, 6, 7}, 3))
}

type dequeue struct {
	array []int
	head  int
	tail  int
}

func newDequeue(length int) *dequeue {
	return &dequeue{
		array: make([]int, length),
	}
}

func (sw *dequeue) removeHead() {
	if sw.head < sw.tail {
		sw.head++
	}
}

func (sw *dequeue) getTail() int {
	return sw.array[sw.tail-1]
}

func (sw *dequeue) getHead() int {
	return sw.array[sw.head]
}

func (sw *dequeue) push(nums []int, num, idx int) {
	for sw.tail > sw.head {
		if nums[sw.array[sw.tail-1]] > num {
			break
		}
		sw.tail--
	}
	sw.array[sw.tail] = idx
	sw.tail++
}

func maxSlidingWindow(nums []int, k int) []int {
	res := make([]int, 0, len(nums)-k+1)
	dq := newDequeue(len(nums))
	for i, num := range nums {
		if i < k-1 {
			dq.push(nums, num, i)
			continue
		}
		dq.push(nums, num, i)
		if i-k >= dq.getHead() {
			dq.removeHead()
		}
		res = append(res, nums[dq.getHead()])
	}
	return res
}
