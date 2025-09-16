package main

import (
	"fmt"
	"slices"
	"strings"
)

func main() {
	fmt.Println(removeDuplicateLetters("cbacdcbc"))
}

func removeDuplicateLetters(s string) string {
	lastOccurence := map[string]int{}
	letters := strings.Split(s, "")
	for idx, letter := range letters {
		lastOccurence[letter] = idx
	}
	stack := []string{}
	for idx, letter := range letters {
		if slices.Contains(stack, letter) {
			continue
		}
		for len(stack) > 0 {
			if letter < stack[len(stack) - 1] && lastOccurence[stack[len(stack) - 1]] > idx {
				stack = stack[:len(stack) - 1]
			} else {
				break
			}
		}
		stack = append(stack, letter)
	}
	return strings.Join(stack, "")
}

func removeDuplicateLetters_Memo(s string) string {
	table := map[string]string{}
	return memo(s, table)
}

func memo(s string, table map[string]string) string {
	if len(s) == 0 {
		panic("received 0 length string")
	}
	if v, ok := table[s]; ok {
		return v
	}

	letters := strings.Split(s, "")
	letterCountMap := buildLetterCountMap(letters)
	// Base condition.
	if allUnique(letterCountMap) {
		table[s] = s
		return s
	}

	best := strings.Repeat("z", len(s))
	// Try to remove each duplicate one-by-one.
	for idx, letter := range letters {
		if letterCountMap[letter] == 1 {
			continue
		}
		// Try to remove this character.
		curr := memo(s[:idx] + s[idx + 1 :], table)
		if curr < best {
			best = curr
		}
	}
	table[s] = best
	return best
}

func allUnique(lm map[string]int) bool {
	for _, count := range lm {
		if count > 1 {
			return false
		}
	}
	return true
}

func buildLetterCountMap(letters []string) map[string]int {
	r := map[string]int{}
	for _, letter := range letters {
		r[letter] += 1
	}
	return r
}
