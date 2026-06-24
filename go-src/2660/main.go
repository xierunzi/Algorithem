package main

func main() {
	println(isWinner([]int{5, 10, 3, 2}, []int{6, 5, 7, 3}))
}

func isWinner(player1 []int, player2 []int) int {
	last1 := -1
	last2 := -1
	sum1 := 0
	sum2 := 0
	for i := 0; i < len(player1); i++ {
		sum1 += calculateScore(player1[i], i, last1)
		sum2 += calculateScore(player2[i], i, last2)
		if player1[i] == 10 {
			last1 = i
		}
		if player2[i] == 10 {
			last2 = i
		}
	}
	if sum1 > sum2 {
		return 1
	} else if sum1 < sum2 {
		return 2
	}
	return 0
}

func calculateScore(current, index, last int) int {
	if last != -1 && index-last <= 2 {
		return current * 2
	}
	return current
}
