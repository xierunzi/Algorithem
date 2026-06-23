package main

func main() {
	println(beautifulSubsets([]int{2, 4, 6}, 2))
}

func beautifulSubsets(nums []int, k int) int {
	return genSubset(0, k, nums, make(map[int]int, len(nums)))
}

func genSubset(index, k int, nums []int, numCountMap map[int]int) int {
	if index >= len(nums) {
		return 0
	}
	// 每个元素都要经历选择和不选择
	// 尝试不选择
	total := genSubset(index+1, k, nums, numCountMap)
	// 尝试选择
	num := nums[index]
	// 看是否存在会不符合子集要求的数
	if numCountMap[num-k] == 0 && numCountMap[num+k] == 0 {
		// 只有不存在才能选择，选择后加入map，组合数+1，继续判断下一个元素
		numCountMap[num]++
		total++
		total += genSubset(index+1, k, nums, numCountMap)
		// 选择完毕要清掉
		numCountMap[num]--
	}
	return total
}
