class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        int maxLen = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = i == j ? true : false;
            }
        }

        int best_i = -1;
        int best_j = -1;
        for (int length = 2; length <= n; length++) {
            for (int i = 0; i < n; i++) {
                int j = i + length - 1;
                if (j >= n) {
                    continue;
                }
                if (s.charAt(i) == s.charAt(j) && (length == 2 || dp[i + 1][j - 1])) {
                    dp[i][j] = true;
                    if (length > maxLen) {
                        maxLen = length;
                        best_i = i;
                        best_j = j;
                    }
                }
            }
        }
        if (maxLen == 1) {
            return s.charAt(0) + "";
        }
        return s.substring(best_i, best_j + 1);
    }
}
