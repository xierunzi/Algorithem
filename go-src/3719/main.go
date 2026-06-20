package main

func main() {
	println(longestBalanced([]int{3, 2, 5, 4}))
}

func longestBalanced(nums []int) int {
	res := 0
	for i := 0; i < len(nums); i++ {
		evenMap := make(map[int]int)
		oddMap := make(map[int]int)
		num1 := nums[i]
		if num1%2 == 0 {
			evenMap[num1] = i
		} else {
			oddMap[num1] = i
		}
		for j := i + 1; j < len(nums); j++ {
			num2 := nums[j]
			if num2%2 == 0 {
				evenMap[num2] = j
			} else {
				oddMap[num2] = j
			}
			if len(evenMap) == len(oddMap) {
				tmp := j - i + 1
				if tmp == len(nums) {
					return tmp
				}
				if res < tmp {
					res = tmp
				}
			}
		}
	}
	return res
}
