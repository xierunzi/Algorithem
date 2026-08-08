package utils

type Queue struct {
	data []int
}

func NewQueue() *Queue {
	return &Queue{data: []int{}}
}
func (q *Queue) Push(n int) {
	q.data = append(q.data, n)
}
func (q *Queue) Pop() (int, bool) {
	if len(q.data) == 0 {
		return 0, false
	}
	data := q.data[0]
	q.data = q.data[1:]
	return data, true
}

func (q *Queue) Peek() (int, bool) {
	if len(q.data) == 0 {
		return 0, false
	}
	return q.data[0], true
}
