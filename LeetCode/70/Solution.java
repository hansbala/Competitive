class Solution {
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return numWays(n, memo);
    }
    int numWays(int n, int[] memo) {
        if (memo[n] != -1) {
            return memo[n];
        }
        if (n <= 2) {
            memo[n] = n;
            return n;
        }
        memo[n] = numWays(n - 1, memo) + numWays(n - 2, memo);
        return memo[n];
    }
}
