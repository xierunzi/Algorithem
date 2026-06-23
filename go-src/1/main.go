package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Printf("%v\n", twoSum([]int{3, 3, 3}, 6))
}

func twoSum(nums []int, target int) []int {
	sort.SliceIsSorted(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	numMap := make(map[int]int, len(nums))
	for i := 0; i < len(nums); i++ {
		num1 := nums[i]
		num2 := target - num1
		if num2Index, ok := numMap[num2]; ok {
			return []int{i, num2Index}
		}
		numMap[num1] = i
	}
	return nil
}
