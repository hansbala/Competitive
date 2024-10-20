from collections import deque

class Solution:
    def findLadders(self, beginWord: str, endWord: str, wordList: List[str]) -> List[List[str]]:
        if beginWord not in wordList:
            wordList.append(beginWord)
        n = len(beginWord)
        wordMap = self.computeWordMap(wordList)
        minPathLen = float('inf')
        ans = []
        visited = {}
        queue = deque([(beginWord, [beginWord], 1)])
        while queue:
            currWord, path, currLen = queue.popleft()
            visited[currWord] = True
            if currWord == endWord and currLen <= minPathLen:
                minPathLen = min(minPathLen, currLen)
                ans.append(path)
            for i in range(n):
                interWord = currWord[ : i] + "#" + currWord[i + 1 : ]
                nextWords = wordMap[interWord]
                for nextWord in nextWords:
                    if nextWord in visited:
                        continue
                    if (not minPathLen == float('inf')) and currLen + 1 > minPathLen:
                        continue 
                    newPath = path + [nextWord]
                    queue.append((nextWord, newPath, currLen + 1))
        return ans
                
    def computeWordMap(self, wordList: List[str]) -> Dict[str, List[str]]:
        wordMap = {}
        for word in wordList:
            n = len(word)
            for i in range(n):
                interWord = word[ : i] + "#" + word[i + 1 : ]
                if interWord not in wordMap:
                    wordMap[interWord] = [word]
                else:
                    wordMap[interWord].append(word)
        return wordMap
