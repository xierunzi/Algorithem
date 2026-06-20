package main

func main() {
	server := Constructor(4)
	server.Upload(3)
	println(server.Longest())
	server.Upload(1)
	println(server.Longest())
	server.Upload(2)
	println(server.Longest())
}

type LUPrefix struct {
	index      int
	isUploaded []bool
	total      int
}

func Constructor(n int) LUPrefix {
	return LUPrefix{index: 0, isUploaded: make([]bool, n+1), total: n}
}

func (this *LUPrefix) Upload(video int) {
	this.isUploaded[video-1] = true
	for i := this.index; i < this.total; i++ {
		if !this.isUploaded[i] {
			break
		}
		this.index++
	}
}

func (this *LUPrefix) Longest() int {
	return this.index
}
