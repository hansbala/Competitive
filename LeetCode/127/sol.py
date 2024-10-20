from collections import deque

class Solution:
    def ladderLength(self, beginWord: str, endWord: str, wordList: List[str]) -> int:
        queue = deque([(beginWord, 1)])
        visited = {}
        wordList.append(beginWord)
        wordMap = self.computeNextWordMap(wordList)
        n = len(beginWord)
        while queue:
            currWord, transforms = queue.popleft()
            visited[currWord] = True
            if currWord == endWord:
                return transforms
            for i in range(n):
                intermediateWord = currWord[:i] + "#" + currWord[i + 1:]
                nextWords = wordMap[intermediateWord]
                for nextWord in nextWords:
                    if nextWord not in visited:
                        queue.append((nextWord, transforms + 1))
        return 0

    def computeNextWordMap(self, wordList) -> Dict[str, List[str]]:
        wordMap = {}
        for word in wordList:
            n = len(word)
            for i in range(n):
                intermediateWord = word[:i] + "#" + word[i + 1:]
                if intermediateWord not in wordMap:
                    wordMap[intermediateWord] = [word]
                else:
                    wordMap[intermediateWord].append(word)
        return wordMap

    def numDiffChars(self, word1: str, word2: str) -> int:
        numDiff = 0
        for i, ch in enumerate(word1):
            if not ch == word2[i]:
                numDiff += 1
        return numDiff
        
