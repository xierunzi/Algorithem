package main

import "math"

func main() {
	println(equalSubstring("krrgw", "zjxss", 19))
}

func equalSubstring(s string, t string, maxCost int) int {
	deltas := make([]int, len(s))
	for i := 0; i < len(s); i++ {
		deltas[i] = -1
	}
	res := 0
	left := 0
	right := 0
	costLeft := maxCost
	for right < len(s) {
		delta := deltas[right]
		if delta == -1 {
			delta = int(math.Abs(float64(int(s[right]) - int(t[right]))))
			deltas[right] = delta
		}
		if costLeft-delta >= 0 {
			tmpRes := right - left + 1
			if res < tmpRes {
				res = tmpRes
			}
			right++
			costLeft -= delta
			continue
		}
		costLeft += deltas[left]
		left++
	}
	return res
}
