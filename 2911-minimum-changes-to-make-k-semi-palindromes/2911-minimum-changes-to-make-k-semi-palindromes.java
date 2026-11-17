import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int INF = 1_000_000_000;
        
        // cost[i][j] = min changes to make s[i..j] a semi-palindrome
        int[][] cost = new int[n][n];
        for (int[] row : cost) {
            Arrays.fill(row, INF);
        }
        
        // 1. Precompute semi-palindrome cost for all substrings of length >= 2
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                cost[i][j] = getSemiPalindromeCost(s, i, j);
            }
        }
        
        // 2. DP to partition prefix of length i into p semi-palindromes
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;
        
        for (int p = 1; p <= k; p++) {
            // Minimum length required for p parts is 2 * p
            for (int i = 2 * p; i <= n; i++) {
                // m is the starting index of the p-th substring
                for (int m = 2 * (p - 1); m <= i - 2; m++) {
                    if (dp[m][p - 1] != INF) {
                        dp[i][p] = Math.min(dp[i][p], dp[m][p - 1] + cost[m][i - 1]);
                    }
                }
            }
        }
        
        return dp[n][k];
    }
    
    private int getSemiPalindromeCost(String s, int start, int end) {
        int len = end - start + 1;
        int minChanges = Integer.MAX_VALUE;
        
        // Test every proper divisor d of len
        for (int d = 1; d < len; d++) {
            if (len % d == 0) {
                int currentChanges = 0;
                // Check each of the d interleaved groups
                for (int offset = 0; offset < d; offset++) {
                    int left = start + offset;
                    int right = end - d + 1 + offset;
                    
                    while (left < right) {
                        if (s.charAt(left) != s.charAt(right)) {
                            currentChanges++;
                        }
                        left += d;
                        right -= d;
                    }
                }
                minChanges = Math.min(minChanges, currentChanges);
            }
        }
        
        return minChanges;
    }
}