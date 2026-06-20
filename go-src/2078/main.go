package main

import "math"

func main() {
	println(maxDistance([]int{1, 1, 1, 6, 1, 1, 1}))
}

func maxDistance(colors []int) int {
	if len(colors) == 2 {
		return 1
	}
	start := 0
	res := 0.0
	length := len(colors)
	for i := start; i < length/2; i++ {
		if length-1-i <= int(res) {
			break
		}
		for j := length - 1; j > i; j-- {
			if colors[i] != colors[j] {
				res = math.Max(res, float64(j-i))
				if int(res) == length-1 {
					return int(res)
				}
				break
			}
		}
	}
	return int(res)
}
