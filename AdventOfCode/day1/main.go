package main

import (
	"fmt"
	"os"
	"strconv"
	"strings"
)

var (
	cConversions = map[string]int{
		"zero":  0,
		"one":   1,
		"two":   2,
		"three": 3,
		"four":  4,
		"five":  5,
		"six":   6,
		"seven": 7,
		"eight": 8,
		"nine":  9,
	}
)

func main() {
	// Read input.txt
	inputData, err := os.ReadFile("input.txt")
	if err != nil {
		panic(err)
	}
	lines := strings.Split(string(inputData), "\n")
	totalCount := 0
	for lineIdx, line := range lines {
		totalCount += getLineCount(line)
		fmt.Println(lineIdx, line, getLineCount(line))
	}
	fmt.Println(totalCount)
}

func getLineCount(line string) int {
	count, _ := strconv.Atoi(fmt.Sprintf("%d%d", findFirstDigit(line), findLastDigit(line)))
	return count
}

func findFirstDigit(line string) int {
	// convert to character array
	chars := strings.Split(line, "")
	curr_string := ""
	for _, char := range chars {
		atoi, err := strconv.Atoi(char)
		if err == nil {
			return atoi
		}
		curr_string += char
		num, ok := getNumber(curr_string)
		if ok {
			return num
		}
	}
	return 0
}

func findLastDigit(line string) int {
	// convert to character array
	chars := strings.Split(line, "")
	curr_string := ""
	for i := len(chars) - 1; i >= 0; i-- {
		atoi, err := strconv.Atoi(chars[i])
		if err == nil {
			return atoi
		}
		curr_string = chars[i] + curr_string
		num, ok := getNumber(curr_string)
		if ok {
			return num
		}
	}
	return 0

}

func getNumber(input string) (int, bool) {
	var fromTheStart strings.Builder
	var fromTheEnd strings.Builder
	for _, char := range strings.Split(input, "") {
		fromTheStart.WriteString(char)
		num, ok := cConversions[fromTheStart.String()]
		if ok {
			return num, true
		}
	}
	for i := len(input) - 1; i >= 0; i-- {
		fromTheEnd.WriteString(string(input[i]))
		reverse := reverse(fromTheEnd)
		num, ok := cConversions[reverse.String()]
		if ok {
			return num, true
		}
	}
	return -1, false
}

func reverse(input strings.Builder) strings.Builder {
	var reversed strings.Builder
	for i := input.Len() - 1; i >= 0; i-- {
		reversed.WriteString(string(input.String()[i]))
	}
	return reversed
}
