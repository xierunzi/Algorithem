package main

func main() {
	grid := [][]byte{
		{'1', '0', '1', '1', '1'},
		{'1', '0', '1', '0', '1'},
		{'1', '1', '1', '0', '1'},
	}
	//grid := [][]byte{
	//	{'1', '1', '0', '0', '0'},
	//	{'1', '1', '0', '0', '0'},
	//	{'0', '0', '1', '0', '0'},
	//	{'0', '0', '0', '1', '1'},
	//}
	//grid := [][]byte{
	//	{'1', '1', '1', '1', '1', '1'},
	//	{'1', '0', '0', '0', '0', '1'},
	//	{'1', '0', '1', '1', '0', '1'},
	//	{'1', '0', '0', '0', '0', '1'},
	//	{'1', '1', '1', '1', '1', '1'}}
	println(numIslands(grid))
}

func numIslands(grid [][]byte) int {
	result := 0
	for i := 0; i < len(grid); i++ {
		for j := 0; j < len(grid[i]); j++ {
			if grid[i][j] == '1' {
				grid[i][j] = '0'
				seek(grid, i, j)
				result++
			}
		}
	}
	return result
}

func seek(grid [][]byte, i, j int) {
	var row, col int
	// up
	row = i - 1
	col = j
	for row >= 0 {
		if grid[row][col] == '0' {
			break
		}
		grid[row][col] = '0'
		seek(grid, row, col)
		row--
	}
	// down
	row = i + 1
	col = j
	for row < len(grid) {
		if grid[row][col] == '0' {
			break
		}
		grid[row][col] = '0'
		seek(grid, row, col)
		row++
	}
	// left
	row = i
	col = j - 1
	for col >= 0 {
		if grid[row][col] == '0' {
			break
		}
		grid[row][col] = '0'
		seek(grid, row, col)
		col--
	}
	// right
	row = i
	col = j + 1
	for col < len(grid[row]) {
		if grid[row][col] == '0' {
			break
		}
		grid[row][col] = '0'
		seek(grid, row, col)
		col++
	}
}
