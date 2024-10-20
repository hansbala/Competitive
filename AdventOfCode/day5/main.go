package main

import (
	"fmt"
	"math"
	"os"
	"strconv"
	"strings"
)

type RangeMapping struct {
	sourceStart      int
	sourceEnd        int
	destinationStart int
	destinationEnd   int
}
type SeedMapping struct {
	start int
	end   int
}

func getOgSeeds(line string) []SeedMapping {
	ogSeeds := []SeedMapping{}
	ogSeedsStr := strings.Split(line[strings.Index(line, " ")+1:], " ")
	for i := 0; i < len(ogSeedsStr); i += 2 {
		start, _ := strconv.Atoi(ogSeedsStr[i])
		rang, _ := strconv.Atoi(ogSeedsStr[i+1])
		ogSeeds = append(ogSeeds, SeedMapping{
			start: start,
			end:   rang + start,
		})
	}
	return ogSeeds
}

func main() {
	catmap := make(map[string][]RangeMapping, 0)
	catmapKeys := []string{}

	allData, _ := os.ReadFile("input.txt")
	lines := strings.Split(string(allData), "\n")
	ogSeeds := getOgSeeds(lines[0])
	totalCount := 0
	for _, seedRange := range ogSeeds {
		totalCount += (seedRange.end - seedRange.start)
	}
	fmt.Printf("going to look at %d number of seeds\n", totalCount)
	lines = lines[2:]
	currentMap := ""
	// Pre-processing.
	for _, line := range lines {
		if strings.Contains(line, "map:") {
			withoutMap := line[0:strings.Index(line, " ")]
			catmap[withoutMap] = []RangeMapping{}
			catmapKeys = append(catmapKeys, withoutMap)
			currentMap = withoutMap
			continue
		}
		if line == "" {
			continue
		}
		rangeMapping := getSourceAndDestinationRanges(line)
		catmap[currentMap] = append(catmap[currentMap], rangeMapping)
	}
	// Walk the path of each seed.
	ans := math.MaxInt
	for _, seedMapping := range ogSeeds {
		for ogSeed := seedMapping.start; ogSeed <= seedMapping.end; ogSeed++ {
			location := getLocationForSeed(catmap, catmapKeys, ogSeed)
			ans = int(math.Min(float64(ans), float64(location)))
		}
	}
	fmt.Println("ans: ", ans)
}

func getLocationForSeed(catmap map[string][]RangeMapping, keys []string, seed int) int {
	nextCategoryValue := seed
	for _, key := range keys {
		for _, rangeMap := range catmap[key] {
			mappedValue, ok := getMappedValue(rangeMap, nextCategoryValue)
			if ok {
				nextCategoryValue = mappedValue
				break
			}
		}
	}
	return nextCategoryValue
}

func getMappedValue(haystack RangeMapping, needle int) (int, bool) {
	if needle >= haystack.sourceStart && needle <= haystack.sourceEnd {
		return (haystack.destinationStart - haystack.sourceStart) + needle, true
	}
	return -1, false
}

func getSourceAndDestinationRanges(line string) RangeMapping {
	nums := strings.Split(line, " ")
	if len(nums) != 3 {
		panic("expected length 3")
	}
	destinationStart, _ := strconv.Atoi(nums[0])
	sourceStart, _ := strconv.Atoi(nums[1])
	rang, _ := strconv.Atoi(nums[2])
	return RangeMapping{
		sourceStart:      sourceStart,
		sourceEnd:        sourceStart + rang,
		destinationStart: destinationStart,
		destinationEnd:   destinationStart + rang,
	}
}
