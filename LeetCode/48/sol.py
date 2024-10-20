class Solution:
    def rotate(self, matrix: List[List[int]]) -> None:
        n = len(matrix)
        # transpose
        for r in range(n):
            for c in range(r, n):
                matrix[r][c], matrix[c][r] = matrix[c][r], matrix[r][c]
        # flip rows backwards
        for r in range(n):
            left, right = 0, n - 1
            while left < right:
                matrix[r][left], matrix[r][right] = matrix[r][right], matrix[r][left]
                left, right = left + 1, right - 1

