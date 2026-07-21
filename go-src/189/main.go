package main

import "fmt"

func main() {
	nums := []int{-1, -100, 3, 99}
	rotate(nums, 2)
	fmt.Printf("%v\n", nums)
}

func rotate(nums []int, k int) {
	length := len(nums)
	if length == 1 {
		return
	}
	k = k % length
	rotated := make(map[int]struct{})
	for i := 0; i < length; i++ {
		if _, ok := rotated[i]; ok {
			continue
		}
		start := i
		preValue := nums[i]
		for {
			idx := nextIdx(start, k, length)
			if _, ok := rotated[idx]; ok {
				break
			}
			tmp := nums[idx]
			nums[idx] = preValue
			preValue = tmp
			rotated[idx] = struct{}{}
			start = idx
		}
	}
}

func nextIdx(i, k, length int) int {
	idx := i + k
	if idx < length {
		return idx
	}
	return idx % length
}
