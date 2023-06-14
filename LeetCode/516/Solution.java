import java.util.*;

class Solution {
    public int longestPalindromeSubseq(String s) {
        Map<String, Integer> memo = new HashMap();
        return findLongest(s, memo);
    }
    int findLongest(String s, Map<String, Integer> memo) {
        System.out.println(s);
        if (isPalindrome(s)) {
            return s.length();
        }
        if (s == "") {
            return 0;
        }
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            String newString = s.substring(0, i) + s.substring(i + 1, s.length());
            int currLen = findLongest(newString, memo);
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
    boolean isPalindrome(String s) {
        int lo = 0;
        int hi = s.length() - 1;
        while (lo < hi) {
            if (s.charAt(lo++) != s.charAt(hi--)) {
                return false;
            }
        }
        return true;
    }
}

class Main {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.longestPalindromeSubseq("bbab"));
    }
}
