package main

import "fmt"

func main() {
	fmt.Printf("%v\n", productExceptSelf([]int{1, 2, 3, 4}))
}

func productExceptSelf(nums []int) []int {
	length := len(nums)
	prefix := make([]int, length)
	suffix := make([]int, length)
	for i := 0; i < length; i++ {
		if i == 0 {
			prefix[i] = 1
		} else {
			prefix[i] = prefix[i-1] * nums[i-1]
		}
		tail := length - i - 1
		if tail == length-1 {
			suffix[tail] = 1
		} else {
			suffix[tail] = suffix[tail+1] * nums[tail+1]
		}
	}
	result := make([]int, length)
	for i := 0; i < length; i++ {
		result[i] = prefix[i] * suffix[i]
	}
	return result
}
