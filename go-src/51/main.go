package main

import (
	"fmt"
)

func main() {
	fmt.Printf("%v\n", solveNQueensV2(4))
}

func solveNQueensV2(n int) [][]string {
	var result [][]string
	// key row value col
	board := make(map[int]int, n)
	col := make([]bool, n)
	leftDiag := make(map[int]bool, n)
	rightDiag := make(map[int]bool, n)
	var solve func(int)
	solve = func(row int) {
		if row == n {
			result = append(result, printBoard(n, board))
			return
		}
		for i := 0; i < n; i++ {
			leftDiagIndex := row - i
			rightDiagIndex := row + i
			if col[i] || leftDiag[leftDiagIndex] || rightDiag[rightDiagIndex] {
				continue
			}
			board[row] = i
			col[i] = true
			leftDiag[leftDiagIndex] = true
			rightDiag[rightDiagIndex] = true
			solve(row + 1)
			col[i] = false
			leftDiag[leftDiagIndex] = false
			rightDiag[rightDiagIndex] = false
		}
	}
	solve(0)
	return result
}

func printBoard(n int, queens map[int]int) []string {
	board := make([]string, n)
	for row, col := range queens {
		line := make([]byte, n)
		for i := range line {
			line[i] = '.'
		}
		line[col] = 'Q'
		board[row] = string(line)
	}
	return board
}

//func solveNQueens(n int) [][]string {
//	var result [][]string
//	board := make(map[int]int, n)
//	for i := 0; i < n; i++ {
//		// 避免零值问题
//		board[i] = 0
//		result = append(result, solve(1, n, board)...)
//		delete(board, i)
//	}
//	return result
//}
//
//func solve(row, n int, board map[int]int) [][]string {
//	if row >= n {
//		if len(board) == n {
//			return [][]string{genResult(board)}
//		}
//		return nil
//	}
//	var result [][]string
//	for i := 0; i < n; i++ {
//		// 判断同一列是否选过
//		if canPut(row, i, n, board) {
//			// 没选过则选，然后进入下一行
//			board[i] = row
//			result = append(result, solve(row+1, n, board)...)
//			delete(board, i)
//
//		}
//		// 选过则跳过当前节点
//	}
//	return result
//}
//
//func canPut(row, col, n int, board map[int]int) bool {
//	if _, ok := board[col]; ok {
//		return false
//	}
//	for i := 1; i <= row; i++ {
//		tmpRow := row - i
//		if tmpRow < 0 {
//			break
//		}
//		tmpCol := col - i
//		r, ok := board[tmpCol]
//		if tmpCol >= 0 && ok && tmpRow == r {
//			return false
//		}
//		tmpCol = col + i
//		r, ok = board[tmpCol]
//		if tmpCol < n && ok && tmpRow == r {
//			return false
//		}
//	}
//	return true
//}
//
//func genResult(board map[int]int) []string {
//	result := make([]string, len(board))
//	for column, row := range board {
//		s := strings.Builder{}
//		for i := 0; i < len(board); i++ {
//			if i == column {
//				s.WriteString("Q")
//			} else {
//				s.WriteString(".")
//			}
//		}
//		result[row] = s.String()
//	}
//	return result
//}
