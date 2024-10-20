from collections import deque
class Solution:
    def solve(self, board: List[List[str]]) -> None:
        for row in board:
            print(row)
        print()
        self.numRows = len(board)
        self.numCols = len(board[0])
        for r in range(self.numRows):
            for c in range(self.numCols):
                if (r == 0 or c == 0 or r == self.numRows - 1 or c == self.numCols - 1) and board[r][c] == "O":
                    board[r][c] = "#"
        for row in board:
            print(row)
        for r in range(self.numRows):
            for c in range(self.numCols):
                if board[r][c] == '#':
                    self.dfs(board, r, c)
        for r in range(self.numRows):
            for c in range(self.numCols):
                # order matters here
                if board[r][c] == 'O':
                    board[r][c] = 'X'
                if board[r][c] == '#':
                    board[r][c] = 'O'
    def dfs(self, board, r, c):
        visited = {}
        stack = deque([(r, c)])
        while stack:
            currRow, currCol = stack.pop()
            if board[currRow][currCol] == 'O':
                board[currRow][currCol] = '#'
            visited[(currRow, currCol)] = True
            neighbors = self.getValidNeighbors(currRow, currCol, board)
            for neighbor in neighbors:
                nextRow, nextCol = neighbor
                if (nextRow, nextCol) not in visited:
                    stack.append(neighbor)
    def getValidNeighbors(self, r, c, board):
        dirs = [(0, 1), (1, 0), (0, -1), (-1, 0)]
        ans = []
        for dirr in dirs:
            deltaR, deltaC = dirr
            newR, newC = r + deltaR, c + deltaC
            if newR < 0 or newR >= self.numRows or newC < 0 or newC >= self.numCols:
                continue
            if board[newR][newC] != 'O':
                continue
            ans.append((newR, newC))
        return ans
            
