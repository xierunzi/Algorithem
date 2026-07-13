package main

import "math"

func main() {
	println(maxArea([]int{1, 8, 6, 2, 5, 4, 8, 3, 7}))
	println(maxArea([]int{1, 1}))
}

func maxArea(height []int) int {
	left := 0
	right := len(height) - 1
	result := 0
	for left < right {
		area := (right - left) * int(math.Min(float64(height[left]), float64(height[right])))
		if area > result {
			result = area
		}
		if height[left] < height[right] {
			left++
		} else {
			right--
		}
	}
	return result
}
