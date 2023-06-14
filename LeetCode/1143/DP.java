class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n1 = text1.length();
        int n2 = text2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];

        // used for out-of-bounds values like comparing ("", "<whatever>")
        for (int i = 0; i <= n2; i++) {
            dp[n1][i] = 0;
        }
        for (int i = 0; i <= n1; i++) {
            dp[i][n2] = 0;
        }

        for (int r = n1 - 1; r >= 0; r--) {
            for (int c = n2 - 1; c >= 0; c--) {
                if (text1.charAt(r) == text2.charAt(c)) {
                    // if they are equal, do 1 + best by removing equal characters from both
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                } else {
                    // if they are not, then best would be remove characters from each of them
                    // and get the max value
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }
        return dp[0][0];
    }
}

