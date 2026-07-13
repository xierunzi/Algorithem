package main

func main() {
	println(lengthOfLongestSubstring("tmmzuxt"))
}

func lengthOfLongestSubstring(s string) int {
	charMap := make(map[uint8]int, len(s))
	maxLen := 0
	left := 0
	right := 0
	for right < len(s) {
		c := s[right]
		lastIdx, ok := charMap[c]
		if ok {
			for left <= lastIdx {
				delete(charMap, s[left])
				left++
			}
		} else {
			tmp := right - left + 1
			if tmp > maxLen {
				maxLen = tmp
			}
		}
		charMap[c] = right
		right++
	}
	return maxLen
}
