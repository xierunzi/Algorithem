package main

func main() {
	println(longestConsecutive([]int{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}))
}

func longestConsecutive(nums []int) int {
	numMap := make(map[int]struct{}, len(nums))
	for _, num := range nums {
		numMap[num] = struct{}{}
	}
	result := 0
	for num := range numMap {
		if _, ok := numMap[num-1]; ok {
			continue
		}
		sum := 1
		for {
			if _, ok := numMap[num+1]; ok {
				sum++
				num++
				continue
			}
			break
		}
		if sum > result {
			result = sum
		}
	}
	return result
}

//func longestConsecutive(nums []int) int {
//	if len(nums) <= 1 {
//		return len(nums)
//	}
//	sort.Slice(nums, func(i, j int) bool {
//		return nums[i] < nums[j]
//	})
//	result := 0
//	sum := 1
//	for i := 0; i < len(nums)-1; i++ {
//		if nums[i] == nums[i+1] {
//			continue
//		}
//		if nums[i] == nums[i+1]-1 {
//			sum++
//			continue
//		}
//		if sum > result {
//			result = sum
//		}
//		sum = 1
//	}
//	if sum > result {
//		result = sum
//	}
//	return result
//}
