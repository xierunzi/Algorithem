package main

import (
	"fmt"
	"sort"
)

func main() {
	fmt.Printf("%v\n", groupAnagrams([]string{"eat", "tea", "tan", "ate", "nat", "bat"}))
}

func groupAnagrams(strs []string) [][]string {
	if len(strs) == 1 {
		return [][]string{{strs[0]}}
	}
	resultMap := make(map[string][]string, len(strs))

	for _, s := range strs {
		chars := []rune(s)
		sort.Slice(chars, func(i, j int) bool {
			return chars[i] < chars[j]
		})
		resultMap[string(chars)] = append(resultMap[string(chars)], s)
	}

	result := make([][]string, 0, len(strs))
	for _, v := range resultMap {
		result = append(result, v)
	}
	return result
}

func isEquivalent(m1, m2 map[int32]int) bool {
	if len(m1) != len(m2) {
		return false
	}
	for k, v := range m1 {
		if m2[k] != v {
			return false
		}
	}
	return true
}

func getCharMap(s string) map[int32]int {
	res := make(map[int32]int, len(s))
	for _, c := range s {
		res[c]++
	}
	return res
}
