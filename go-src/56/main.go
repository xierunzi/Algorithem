package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Printf("%v\n", merge([][]int{{4, 7}, {5, 6}}))
}

func merge(intervals [][]int) [][]int {
	sort.Slice(intervals, func(i, j int) bool {
		if intervals[i][0] == intervals[j][0] {
			return intervals[i][1] < intervals[j][1]
		}
		return intervals[i][0] < intervals[j][0]
	})
	var result [][]int
	var array []int
	for _, nums := range intervals {
		if array == nil {
			array = make([]int, 2)
			array[0] = nums[0]
			array[1] = nums[1]
			continue
		}
		if nums[0] <= array[1] {
			if nums[1] > array[1] {
				array[1] = nums[1]
			}
			continue
		}
		result = append(result, array)
		array = make([]int, 2)
		array[0] = nums[0]
		array[1] = nums[1]
	}
	result = append(result, array)
	return result
}
