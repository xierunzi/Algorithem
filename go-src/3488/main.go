package main

import (
	"fmt"
	"math"
)

func main() {
	res := solveQueries([]int{1, 3, 1, 4, 1, 3, 2}, []int{0, 3, 5})
	fmt.Printf("%v\n", res)
}

func solveQueries(nums []int, queries []int) []int {
	valueMap := make(map[int][]int)
	for index, num := range nums {
		valueMap[num] = append(valueMap[num], index)
	}
	numsLen := len(nums)
	var result []int
	for _, index := range queries {
		target := nums[index]
		indexArray := valueMap[target]
		if len(indexArray) <= 1 {
			result = append(result, -1)
			continue
		}

		left := 0
		right := len(indexArray) - 1
		finalIndex := 0
		for left <= right {
			mid := left + (right-left)/2
			if indexArray[mid] == index {
				finalIndex = mid
				break
			} else if indexArray[mid] > index {
				right = mid
			} else {
				left = mid + 1
			}
		}
		rightIndex := finalIndex + 1
		if rightIndex >= len(indexArray) {
			rightIndex = 0
		}
		leftIndex := finalIndex - 1
		if leftIndex < 0 {
			leftIndex = len(indexArray) - 1
		}

		leftIndexValue := indexArray[leftIndex]
		rightIndexValue := indexArray[rightIndex]
		leftDistance := 0.0
		if leftIndexValue > index {
			leftDistance = math.Min(float64(leftIndexValue-index), float64(index+numsLen-leftIndexValue))
		} else {
			leftDistance = math.Min(float64(index-leftIndexValue), float64(leftIndexValue+numsLen-index))
		}

		rightDistance := 0.0
		if rightIndexValue > index {
			rightDistance = math.Min(float64(rightIndexValue-index), float64(index+numsLen-rightIndexValue))
		} else {
			rightDistance = math.Min(float64(index-rightIndexValue), float64(rightIndexValue+numsLen-index))
		}
		result = append(result, int(math.Min(leftDistance, rightDistance)))
	}
	return result
}
