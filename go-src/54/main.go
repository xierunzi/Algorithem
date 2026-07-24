package main

import (
	"fmt"
	"math"
)

func main() {
	fmt.Printf("%v\n", spiralOrder([][]int{
		{1, 2, 3, 4},
		{5, 6, 7, 8},
		{9, 10, 11, 12},
	}))
}

func spiralOrder(matrix [][]int) []int {
	i := 0
	j := 0
	magicNum := math.MinInt
	length := len(matrix)
	width := len(matrix[0])
	size := length * width
	result := make([]int, size)

	funcs := []func(i, j int) (int, int){
		func(i, j int) (int, int) {
			return i, j + 1
		},
		func(i, j int) (int, int) {
			return i + 1, j
		},
		func(i, j int) (int, int) {
			return i, j - 1
		},
		func(i, j int) (int, int) {
			return i - 1, j
		},
	}

	funcIndex := 0
	index := 0

	for index < size {
		result[index] = matrix[i][j]
		index++
		matrix[i][j] = magicNum
		newI, newJ := funcs[funcIndex](i, j)
		if newI >= length || newJ >= width || newI < 0 || newJ < 0 || matrix[newI][newJ] == magicNum {
			funcIndex = (funcIndex + 1) % len(funcs)
			i, j = funcs[funcIndex](i, j)
		} else {
			i, j = newI, newJ
		}
	}
	return result
}
