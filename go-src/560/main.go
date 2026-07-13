package main

func main() {
	println(subarraySum([]int{-1, -1, 1}, 0))
}

func subarraySum(nums []int, k int) int {
	result := 0
	sumCountMap := make(map[int]int, len(nums))
	sumCountMap[0] = 1
	sum := 0
	for i := 0; i < len(nums); i++ {
		sum += nums[i]
		target := sum - k
		result += sumCountMap[target]
		sumCountMap[sum]++
	}
	return result
}
