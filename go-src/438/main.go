package main

import "fmt"

func main() {
	fmt.Printf("%v\n", findAnagrams("abacbabc", "abc"))
}
func findAnagrams(s string, p string) []int {
	pLen := len(p)
	if len(s) < pLen {
		return []int{}
	}
	pArray := make([]int, 26)
	for i := 0; i < pLen; i++ {
		index := p[i] - 'a'
		pArray[index]++
	}
	curArray := make([]int, 26)
	var result []int
	left := 0
	right := 0
	for right < len(s) {
		rIdx := s[right] - 'a'
		curArray[rIdx]++
		if curArray[rIdx] <= pArray[rIdx] {
			if pLen == right-left+1 {
				result = append(result, left)
				lIdx := s[left] - 'a'
				curArray[lIdx]--
				left++
			}
			right++
			continue
		}
		if pArray[rIdx] == 0 {
			curArray = make([]int, 26)
			right++
			left = right
			continue
		}
		for left < right {
			lIdx := s[left] - 'a'
			curArray[lIdx]--
			left++
			if curArray[rIdx] <= pArray[rIdx] {
				break
			}
		}
		right++
	}
	return result
}
