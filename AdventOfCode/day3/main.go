package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

type Coord struct {
	row int
	col int
}
type Element struct {
	value string
	start Coord
	end   Coord
}

func main() {
	allData, _ := os.ReadFile("input.txt")
	lines := strings.Split(string(allData), "\n")
	numbers, symbols := parseGrid(lines)
  // PART 1
	// totalSum := 0
  // for _, number := range numbers {
	// 	for _, symbol := range symbols {
	// 		if isNeighbor(number, symbol) {
  //       numericalNum, _ := strconv.Atoi(number.value)
	// 			totalSum += numericalNum
	// 			break
	// 		}
	// 	}
	// }
	// fmt.Println(totalSum)
  // END: PART 1
  
  // PART 2
  totalSum := 0
  for _, symbol := range symbols {
    if symbol.value != "*" {
      continue
    }
    var numberNeighbors []Element
    for _, number := range numbers {
      if !isNeighbor(number, symbol) {
        continue
      }
      numberNeighbors = append(numberNeighbors, number)
    }
    // Must be exactly two.
    if len(numberNeighbors) != 2 {
      continue
    }
    numericalNum1, _ := strconv.Atoi(numberNeighbors[0].value)
    numericalNum2, _ := strconv.Atoi(numberNeighbors[1].value)
    totalSum += (numericalNum1 * numericalNum2)
  }
  fmt.Println(totalSum)
  // END: PART 2
}

func isNeighbor(number Element, symbol Element) bool {
	// any of the digits of the number can be a neighbor of the symbol
	for numberCol := number.start.col; numberCol <= number.end.col; numberCol++ {
		numberRow := number.start.row
		rowDiff := int(math.Abs(float64(numberCol - symbol.start.col)))
		colDiff := int(math.Abs(float64(numberRow - symbol.start.row)))
		if rowDiff <= 1 && colDiff <= 1 {
			return true
		}
	}
	return false
}

func parseGrid(lines []string) ([]Element, []Element) {
	var numberLocations []Element
	var symbolLocations []Element
	startCol := -1
	var currString strings.Builder
	for rowIdx, line := range lines {
		for colIdx, char := range strings.Split(line, "") {
			// build number if digit
			_, err := strconv.Atoi(string(char))
			if err == nil {
				if startCol == -1 {
					startCol = colIdx
				}
				currString.WriteString(string(char))
				// if it's the last digit on the line
				if colIdx == len(line)-1 {
					numberLocations = append(numberLocations, Element{
						value: currString.String(),
						start: Coord{row: rowIdx, col: startCol},
						end:   Coord{row: rowIdx, col: colIdx},
					})
					currString.Reset()
					startCol = -1
				}
				continue
			}
			// special symbols
			if char != "." {
				symbolLocations = append(symbolLocations, Element{
					value: string(char),
					start: Coord{row: rowIdx, col: colIdx},
					end:   Coord{row: rowIdx, col: colIdx},
				})
			}
			// now it's either a `.` or a symbol so we can parse the number
			if currString.Len() > 0 {
				numberLocations = append(numberLocations, Element{
					value: currString.String(),
					start: Coord{row: rowIdx, col: startCol},
					end:   Coord{row: rowIdx, col: colIdx - 1},
				})
				currString.Reset()
				startCol = -1
			}
		}
	}
	return numberLocations, symbolLocations
}
