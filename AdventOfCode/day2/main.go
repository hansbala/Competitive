package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

const (
	cNumRed   = 12
	cNumGreen = 13
	cNumBlue  = 14

	cRed   = "red"
	cGreen = "green"
	cBlue  = "blue"
)

type color string

func main() {
	fileData, _ := os.ReadFile("input.txt")
	lines := strings.Split(string(fileData), "\n")
	totalSum := 0
	for _, line := range lines {
		maxRoundCounts := getMaxColorsFromRounds(line)
		totalSum += maxRoundCounts[cRed] * maxRoundCounts[cGreen] * maxRoundCounts[cBlue]
	}
	fmt.Println(totalSum)
}

func isGamePossible(game string) (int /*game id*/, bool) {
	gameId, _ := strconv.Atoi(game[strings.Index(game, " ")+1 : strings.Index(game, ":")])
	maxRoundCount := getMaxColorsFromRounds(game)
	if maxRoundCount[cRed] > cNumRed || maxRoundCount[cGreen] > cNumGreen || maxRoundCount[cBlue] > cNumBlue {
		return gameId, false
	}
	return gameId, true
}

func getMaxColorsFromRounds(game string) map[color]int {
	rounds := getRounds(game)
	maxRoundCount := map[color]int{
		cRed:   0,
		cGreen: 0,
		cBlue:  0,
	}
	for _, round := range rounds {
		r, g, b := getRoundCount(round)
		if r > maxRoundCount[cRed] {
			maxRoundCount[cRed] = r
		}
		if g > maxRoundCount[cGreen] {
			maxRoundCount[cGreen] = g
		}
		if b > maxRoundCount[cBlue] {
			maxRoundCount[cBlue] = b
		}
	}
	return maxRoundCount
}

func getRoundCount(round string) (int /*red*/, int /*green*/, int /*blue*/) {
	redCount := 0
	greenCount := 0
	blueCount := 0
	spaceSeparated := strings.Split(round, " ")
	for idx := 0; idx < len(spaceSeparated); idx += 2 {
		numBalls, _ := strconv.Atoi(spaceSeparated[idx])
		color := spaceSeparated[idx+1]
		if color[len(color)-1] == ',' {
			color = color[:len(color)-1]
		}
		switch color {
		case cRed:
			redCount += numBalls
		case cGreen:
			greenCount += numBalls
		case cBlue:
			blueCount += numBalls
		}
	}
	return redCount, greenCount, blueCount
}

func getRounds(game string) []string {
	rounds := strings.Split(game[strings.Index(game, ":")+2:], ";")
	for i, round := range rounds {
		rounds[i] = strings.TrimSpace(round)
	}
	return rounds
}
