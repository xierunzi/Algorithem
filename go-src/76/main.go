package main

import (
	"math"
)

func main() {
	println(minWindow("ECODEBANC", "ABC"))
}

func minWindow(s string, t string) string {
	m := len(s)
	n := len(t)
	if m < n {
		return ""
	}
	charMap := make(map[byte]int)
	for i := 0; i < n; i++ {
		charMap[t[i]]++
	}
	existedMap := make(map[byte]int)
	length := math.MaxInt
	left := 0
	right := 0
	resultLeft := 0
	resultRight := 0
	for right < m {
		if charMap[s[right]] <= 0 {
			right++
			continue
		}
		existedMap[s[right]]++
		for left <= right && isEquivalent(charMap, existedMap) {
			if right-left+1 < length {
				length = right - left + 1
				resultLeft = left
				resultRight = right + 1
			}
			if _, ok := charMap[s[left]]; ok {
				existedMap[s[left]]--
			}
			left++
		}
		right++
	}
	return s[resultLeft:resultRight]
}

func isEquivalent(charMap map[byte]int, existedMap map[byte]int) bool {
	for k, v := range charMap {
		if v > existedMap[k] {
			return false
		}
	}
	return true
}
