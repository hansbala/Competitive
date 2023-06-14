import java.util.*;

class Solution {
    // should be noted that the longestPalindromeSubseq in a string s
    // is just the LCS between s and reverse(s)
    public int longestPalindromeSubseq(String s) {
        String rev = new StringBuilder(s).reverse().toString();
        int n = s.length();
        int[][] dp = new int[n + 1][n + 1];
        // LCS between ("", <whatever>), or (<whatever>, "") is always 0
        for (int i = 0; i <= n; i++) {
            dp[n][i] = 0;
            dp[i][n] = 0;
        }

        for (int r = n - 1; r >= 0; r--) {
            for (int c = n - 1; c >= 0; c--) {
                if (s.charAt(r) == rev.charAt(c)) {
                    // max would be:
                    // [1 (since chars are equal) +
                    // longestPalindromeSubseq(remove char from s, remove char from rev(s))]
                    dp[r][c] = 1 + dp[r + 1][c + 1];
                } else {
                    // max would be either remove char from first string or remove from second string
                    dp[r][c] = Math.max(dp[r + 1][c], dp[r][c + 1]);
                }
            }
        }
        return dp[0][0];
    }
}


class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindromeSubseq("bbbab"));
    }
}
