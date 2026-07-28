package main

func main() {
	matrix := [][]int{
		{5, 6, 10, 14},
		{6, 10, 13, 18},
		{10, 13, 18, 19},
	}
	println(searchMatrix(matrix, 14))
}

func searchMatrix(matrix [][]int, target int) bool {
	m := len(matrix)
	n := len(matrix[0])
	if target < matrix[0][0] || target > matrix[m-1][n-1] {
		return false
	}
	row := 0
	col := 0
	for row < m || col < n {
		if row >= m {
			row = m - 1
		}
		if col >= n {
			col = n - 1
		}
		if matrix[row][col] == target {
			return true
		}
		if matrix[row][col] < target {
			row++
			col++
			continue
		}
		if binarySearchMatrix(matrix, target, row, col) {
			return true
		}
		row++
		col++
	}
	return false
}

func binarySearchMatrix(matrix [][]int, target int, row, col int) bool {
	// fixed row
	left := 0
	right := col
	for left <= right {
		mid := (left + right) / 2
		if target == matrix[row][mid] {
			return true
		} else if target < matrix[row][mid] {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	left = 0
	right = row
	for left <= right {
		mid := (left + right) / 2
		if target == matrix[mid][col] {
			return true
		} else if target < matrix[mid][col] {
			right = mid - 1
		} else {
			left = mid + 1
		}
	}
	return false
}
