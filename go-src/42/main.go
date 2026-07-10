package main

import "math"

func main() {
	println(trap([]int{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}))
}

func trap(height []int) int {
	length := len(height)
	if length < 2 {
		return 0
	}
	leftMaxHeight := make([]int, length)
	rightMaxHeight := make([]int, length)
	leftMaxHeight[0] = height[0]
	rightMaxHeight[length-1] = height[length-1]
	for i := 1; i < length; i++ {
		leftMaxHeight[i] = int(math.Max(float64(leftMaxHeight[i-1]), float64(height[i])))
	}
	for i := length - 2; i >= 0; i-- {
		rightMaxHeight[i] = int(math.Max(float64(rightMaxHeight[i+1]), float64(height[i])))
	}
	result := 0
	for i := 0; i < length; i++ {
		result += int(math.Min(float64(leftMaxHeight[i]), float64(rightMaxHeight[i]))) - height[i]
	}
	return result
}
