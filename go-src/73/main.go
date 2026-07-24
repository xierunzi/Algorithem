package main

import "fmt"

func main() {
	matrix := [][]int{
		{0, 1, 2, 0},
		{3, 4, 5, 2},
		{1, 3, 1, 5},
	}
	setZeroes(matrix)
	fmt.Printf("%v\n", matrix)
}

func setZeroes(matrix [][]int) {
	columns := make(map[int]struct{})
	for i := 0; i < len(matrix); i++ {
		rowChange := false
		for j := 0; j < len(matrix[i]); j++ {
			if matrix[i][j] == 0 {
				columns[j] = struct{}{}
				rowChange = true
			}
		}
		if rowChange {
			for j := 0; j < len(matrix[i]); j++ {
				matrix[i][j] = 0
			}
		}
	}
	for c, _ := range columns {
		for i := 0; i < len(matrix); i++ {
			matrix[i][c] = 0
		}
	}
	return
}
