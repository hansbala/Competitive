package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

var totalGames = 0

func main() {
	allData, _ := os.ReadFile("input.txt")
	lines := strings.Split(string(allData), "\n")
	totalGames = len(lines)
	cardToCopies := map[int]int{}
	cardToMatches := map[int]int{}
	// Initially start out with 1 copy each.
	for _, line := range lines {
		cardNumber, _ := strconv.Atoi(line[strings.Index(line, " ")+1 : strings.Index(line, ":")])
		cardToCopies[cardNumber] = 1
		cardToMatches[cardNumber] = getNumMatchingNumbers(line)
	}
	// Increment each copy count below with numCopies the current card has.
	for cardNumber := 1; cardNumber <= totalGames; cardNumber++ {
		numCopies := cardToCopies[cardNumber]
		numMatching := cardToMatches[cardNumber]
		updateCopyCounts(&cardToCopies, cardNumber+1, numMatching, numCopies)
	}
  ans := 0
  for _, v := range cardToCopies {
    ans += v
  }
  fmt.Println(ans)
}

func updateCopyCounts(copiesMap *map[int]int, start int, diff int, numCopies int) {
	// fmt.Println(copiesMap, start, diff, numCopies)
	for i := start; i < start+diff; i++ {
		if i >= len(*copiesMap) {
			break
		}
		(*copiesMap)[i] += numCopies
	}
}

func getNumMatchingNumbers(card string) int {
	numberSets := strings.Split(card[strings.Index(card, ":")+1:], "|")
	winningNumbers := filterOnlyNumbers(strings.Split(numberSets[0], " "))
	myNumbers := filterOnlyNumbers(strings.Split(numberSets[1], " "))
	totalCount := 0
	for winningNumber, _ := range winningNumbers {
		for myNumber, _ := range myNumbers {
			if winningNumber == myNumber {
				totalCount += 1
			}
		}
	}
	return totalCount
}

func filterOnlyNumbers(elements []string) map[int]int {
	sanitized := map[int]int{}
	for _, number := range elements {
		numericalNum, err := strconv.Atoi(number)
		if err == nil {
			sanitized[numericalNum] = 1
		}
	}
	return sanitized
}
