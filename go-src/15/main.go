package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Printf("%v\n", threeSum([]int{-1, 0, 1, 2, -1, -4}))
}

func threeSum(nums []int) [][]int {
	length := len(nums)
	var result [][]int
	sort.Slice(nums, func(i, j int) bool {
		return nums[i] < nums[j]
	})
	for i := 0; i < length; i++ {
		if i > 0 && nums[i] == nums[i-1] {
			continue
		}
		target := -nums[i]
		j := i + 1
		k := len(nums) - 1
		for j < k {
			if j > i+1 && nums[j] == nums[j-1] {
				j++
				continue
			}
			sum := nums[j] + nums[k]
			if sum > target {
				k--
			} else if sum < target {
				j++
			} else {
				result = append(result, []int{nums[i], nums[j], nums[k]})
				j++
			}
		}
	}
	return result
}
