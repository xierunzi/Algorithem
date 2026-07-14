package main

func main() {
	println(maxSubArray([]int{5, 4, -1, 7, 8}))
}
func maxSubArray(nums []int) int {
	if len(nums) == 1 {
		return nums[0]
	}
	maxValues := make([]int, len(nums))
	result := 0
	for i := 0; i < len(nums); i++ {
		if i == 0 {
			maxValues[i] = nums[0]
			result = nums[0]
			continue
		}
		maxValues[i] = max(nums[i], nums[i]+maxValues[i-1])
		if maxValues[i] > result {
			result = maxValues[i]
		}
	}
	return result
}
