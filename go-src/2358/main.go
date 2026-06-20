package main

func main() {
	println(maximumGroups([]int{2, 31, 41, 31, 36, 46, 33, 45, 47, 8, 31, 6, 12, 12, 15, 35}))
}

func maximumGroups(grades []int) int {
	result := 0
	delta := 1
	length := len(grades)
	for i := 0; i < length; i++ {
		if i+delta > length {
			break
		}
		i += delta - 1
		result++
		delta++
	}
	return result
}

//func maximumGroups(grades []int) int {
//	sort.Slice(grades, func(i, j int) bool {
//		return grades[i] < grades[j]
//	})
//	lastNum := 0
//	lastSum := 0
//	res := 0
//	currentNum := 0
//	currentSum := 0
//	for _, grade := range grades {
//		currentSum += grade
//		currentNum++
//		if currentSum > lastSum && currentNum > lastNum {
//			lastNum = currentNum
//			lastSum = currentSum
//			currentNum = 0
//			currentSum = 0
//			res++
//			continue
//		}
//	}
//	return res
//}
