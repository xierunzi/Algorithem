package main

import "fmt"

func main() {
	grid := [][]int{
		{2, 1, 1},
		{0, 1, 1},
		{1, 0, 1},
	}
	println(orangesRotting(grid))
}

type Index struct {
	Row    int
	Col    int
	Minute int
}

func NewIndex(row, col, minute int) *Index {
	return &Index{Row: row, Col: col, Minute: minute}
}

type Queue struct {
	data []*Index
}

func NewQueue() *Queue {
	return &Queue{data: []*Index{}}
}
func (q *Queue) Push(n *Index) {
	q.data = append(q.data, n)
}
func (q *Queue) Pop() *Index {
	if len(q.data) == 0 {
		return nil
	}
	data := q.data[0]
	q.data = q.data[1:]
	return data
}

func (q *Queue) Peek() *Index {
	if len(q.data) == 0 {
		return nil
	}
	return q.data[0]
}

func (q *Queue) Len() int {
	return len(q.data)
}

func orangesRotting(grid [][]int) int {
	queue := NewQueue()
	m := len(grid)
	n := len(grid[0])
	oranges := make(map[string]struct{}, m*n)
	for i := 0; i < m; i++ {
		for j := 0; j < n; j++ {
			if grid[i][j] == 2 {
				queue.Push(NewIndex(i, j, 0))
			} else if grid[i][j] == 1 {
				oranges[stringKey(i, j)] = struct{}{}
			}
		}
	}
	minutes := bfs(grid, queue, 0, oranges)
	if len(oranges) == 0 {
		return minutes
	}
	return -1
}

func bfs(grid [][]int, queue *Queue, minute int, oranges map[string]struct{}) int {
	newMinute := minute + 1
	for {
		index := queue.Peek()
		if index == nil || index.Minute != minute {
			break
		}
		queue.Pop()
		if index.Row-1 >= 0 && grid[index.Row-1][index.Col] == 1 {
			delete(oranges, stringKey(index.Row-1, index.Col))
			queue.Push(NewIndex(index.Row-1, index.Col, newMinute))
			grid[index.Row-1][index.Col] = 0
		}
		if index.Row+1 < len(grid) && grid[index.Row+1][index.Col] == 1 {
			delete(oranges, stringKey(index.Row+1, index.Col))
			queue.Push(NewIndex(index.Row+1, index.Col, newMinute))
			grid[index.Row+1][index.Col] = 0
		}
		if index.Col-1 >= 0 && grid[index.Row][index.Col-1] == 1 {
			delete(oranges, stringKey(index.Row, index.Col-1))
			queue.Push(NewIndex(index.Row, index.Col-1, newMinute))
			grid[index.Row][index.Col-1] = 0
		}
		if index.Col+1 < len(grid[0]) && grid[index.Row][index.Col+1] == 1 {
			delete(oranges, stringKey(index.Row, index.Col+1))
			queue.Push(NewIndex(index.Row, index.Col+1, newMinute))
			grid[index.Row][index.Col+1] = 0
		}
	}
	if queue.Len() == 0 {
		return minute
	}
	return bfs(grid, queue, newMinute, oranges)
}

func stringKey(row, col int) string {
	return fmt.Sprintf("%d-%d", row, col)
}
