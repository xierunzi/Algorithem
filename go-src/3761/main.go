package main

import "math"

func main() {
	nums := []int{21, 45, 21, 12, 33, 54, 21}
	println(minMirrorPairDistance(nums))
}

func minMirrorPairDistance(nums []int) int {
	mirrorMap := make(map[int]int, len(nums))
	result := -1
	for i := len(nums) - 1; i >= 0; i-- {
		reverse := reverseNum(nums[i])
		idx, ok := mirrorMap[reverse]
		if !ok {
			mirrorMap[nums[i]] = i
			continue
		}
		if result == -1 {
			result = int(math.Abs(float64(idx - i)))
		} else {
			result = int(math.Min(float64(result), math.Abs(float64(idx-i))))
		}
		if result == 1 {
			return 1
		}
		mirrorMap[nums[i]] = i
	}
	return result
}

func reverseNum(a int) int {
	result := 0
	flag := false
	for {

		mod := a % 10
		if mod != 0 || flag {
			result = result*10 + mod
			flag = true
		}
		a /= 10
		if a == 0 {
			break
		}
	}
	return result
}
