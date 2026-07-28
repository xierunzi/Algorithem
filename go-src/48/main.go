package main

import "fmt"

func main() {
	matrix := [][]int{
		{5, 1, 9, 11},
		{2, 4, 8, 10},
		{13, 3, 6, 7},
		{15, 14, 12, 16},
	}
	rotate(matrix)
	fmt.Printf("%v\n", matrix)
}

func rotate(matrix [][]int) {
	n := len(matrix)
	// 第i行变第size-i-1列
	// 第i列变第i行
	moved := make(map[string]bool, n*n)
	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			row := i
			col := j
			preValue := matrix[row][col]
			if moved[movedKey(row, col)] {
				continue
			}
			for {
				newRow := col
				newCol := n - 1 - row
				key := movedKey(newRow, newCol)
				if moved[key] {
					break
				}
				moved[key] = true
				tmp := matrix[newRow][newCol]
				matrix[newRow][newCol] = preValue
				preValue = tmp
				row = newRow
				col = newCol
			}
		}
	}
}

func movedKey(i, j int) string {
	return fmt.Sprintf("%d:%d", i, j)
}
