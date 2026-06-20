package main

func main() {
	print(isTrionic([]int{1, 2, 3}))
}

func isTrionic(nums []int) bool {
	pFlag := true
	qFlag := true
	for i := 1; i < len(nums); i++ {
		if nums[i] == nums[i-1] {
			return false
		}
		if pFlag {
			if nums[i] < nums[i-1] {
				pFlag = false
				if i == 1 {
					return false
				}
			}
			continue
		}
		if qFlag {
			if nums[i] > nums[i-1] {
				qFlag = false
			}
			continue
		}
		if nums[i] < nums[i-1] {
			return false
		}
	}
	return !pFlag && !qFlag
}
