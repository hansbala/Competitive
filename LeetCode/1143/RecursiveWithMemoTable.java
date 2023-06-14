// recursive solution with memo table (TLEs on leetcode for a large input)

import java.util.*;

class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        Map<List<String>, Integer> memo = new HashMap<>();
        return findLongest(text1, text2, memo);
    }
    int findLongest(String s1, String s2, Map<List<String>, Integer> memo) {
        List<String> pair1 = Arrays.asList(s1, s2);
        List<String> pair2 = Arrays.asList(s2, s1);
        int ans = -1;

        if (memo.containsKey(pair1)) {
            return memo.get(pair1);
        } else if (memo.containsKey(pair2)) {
            return memo.get(pair2);
        }
        if (s1 == "" || s2 == "") {
            ans = 0;
        } else if (s1.charAt(0) == s2.charAt(0)) {
            ans = 1 + findLongest(s1.substring(1, s1.length()), s2.substring(1, s2.length()), memo);
        } else {
            int removeFromFirst  = findLongest(s1.substring(1, s1.length()), s2, memo);
            int removeFromSecond = findLongest(s1, s2.substring(1, s2.length()), memo);
            ans = Math.max(removeFromFirst, removeFromSecond);
        }
        memo.put(pair1, ans);
        memo.put(pair2, ans);
        return ans;
    }
}
