// Java Solution
/*
 * Time Complexity: O(m * n) - where m is text length, n is pattern length
 * Space Complexity: O(m * n) - for DP table
 */
class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] = true if first i characters of s match first j characters of p
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char currentS = s.charAt(i - 1);
                char currentP = p.charAt(j - 1);
                
                if (currentP == '*') {
                    // '*' can match zero or more of the preceding element
                    char prevP = p.charAt(j - 2);
                    
                    // Zero occurrence: ignore pattern[j-2] and pattern[j-1]
                    dp[i][j] = dp[i][j - 2];
                    
                    // One or more occurrence: check if current char matches
                    if (prevP == currentS || prevP == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else if (currentP == '.' || currentP == currentS) {
                    // Current characters match
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }
        
        return dp[m][n];
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(m * n) - where m is text length, n is pattern length
 * Space Complexity: O(m * n) - for DP table
 */
bool isMatch(char* s, char* p) {
    int m = strlen(s);
    int n = strlen(p);
    
    // dp[i][j] = true if first i characters of s match first j characters of p
    bool** dp = (bool**)malloc((m + 1) * sizeof(bool*));
    for (int i = 0; i <= m; i++) {
        dp[i] = (bool*)calloc(n + 1, sizeof(bool));
    }
    
    // Empty string matches empty pattern
    dp[0][0] = true;
    
    // Handle patterns like a*, a*b*, a*b*c* that can match empty string
    for (int j = 2; j <= n; j++) {
        if (p[j - 1] == '*') {
            dp[0][j] = dp[0][j - 2];
        }
    }
    
    // Fill the DP table
    for (int i = 1; i <= m; i++) {
        for (int j = 1; j <= n; j++) {
            char currentS = s[i - 1];
            char currentP = p[j - 1];
            
            if (currentP == '*') {
                // '*' can match zero or more of the preceding element
                char prevP = p[j - 2];
                
                // Zero occurrence: ignore pattern[j-2] and pattern[j-1]
                dp[i][j] = dp[i][j - 2];
                
                // One or more occurrence: check if current char matches
                if (prevP == currentS || prevP == '.') {
                    dp[i][j] = dp[i][j] || dp[i - 1][j];
                }
            } else if (currentP == '.' || currentP == currentS) {
                // Current characters match
                dp[i][j] = dp[i - 1][j - 1];
            }
        }
    }
    
    bool result = dp[m][n];
    
    // Free memory
    for (int i = 0; i <= m; i++) {
        free(dp[i]);
    }
    free(dp);
    
    return result;
}