package main

func main() {
	println(firstMissingPositive([]int{3, 4, -1, 1}))
}

func firstMissingPositive(nums []int) int {
	numsMap := make(map[int]int, len(nums))
	maxNums := 0
	for _, num := range nums {
		numsMap[num]++
		if num > maxNums {
			maxNums = num
		}
	}
	result := 0
	for i := 1; i < maxNums; i++ {
		if numsMap[i] > 0 {
			continue
		}
		result = i
		break
	}
	if result == 0 {
		result = maxNums + 1
	}
	return result
}
