class Solution:
    def numSquares(self, n: int) -> int:
        perfectSquares = []
        for i in range(1, n + 1):
            sq = i ** 2
            if sq > n:
                break
            perfectSquares.append(i * i)
        dp = [float('inf')] * (n + 1)
        dp[0] = 0
        for i in range(1, n + 1):
            for sq in perfectSquares:
                if sq <= i:
                    dp[i] = min(dp[i], dp[i - sq] + 1)
        return dp[n]
