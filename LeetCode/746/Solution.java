class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return Math.min(
            minCost(cost, 0, n, memo),
            minCost(cost, 1, n, memo)
        );
    }
    int minCost(int[] cost, int currStep, int n, int[] memo) {
        if (currStep > n) {
            return Integer.MAX_VALUE;
        }
        if (currStep == n) {
            return 0;
        }
        if (memo[currStep] != -1) {
            return memo[currStep];
        }
        memo[currStep] = cost[currStep] + Math.min(
            minCost(cost, currStep + 1, n, memo),
            minCost(cost, currStep + 2, n, memo)
        );
        return memo[currStep];
    }
}
