package main

import "fmt"

func main() {
	array := []int{0, 1, 0, 3, 12}
	moveZeroes(array)
	fmt.Printf("%v\n", array)
}

func moveZeroes(nums []int) {
	if len(nums) == 1 {
		return
	}
	slow := 0
	fast := 0
	for fast < len(nums) {
		if nums[fast] != 0 {
			tmp := nums[fast]
			nums[fast] = nums[slow]
			nums[slow] = tmp
			slow++
		}
		fast++
	}
}
