// Java Solution
/*
 * Time Complexity: O(n²) - expand around center for each position
 * Space Complexity: O(1) - only storing indices
 */
class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;
        
        for (int i = 0; i < s.length(); i++) {
            // Check for odd length palindromes (center is single character)
            int len1 = expandAroundCenter(s, i, i);
            // Check for even length palindromes (center is between two characters)
            int len2 = expandAroundCenter(s, i, i + 1);
            
            int len = Math.max(len1, len2);
            
            // Update start and end if longer palindrome found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        
        return s.substring(start, end + 1);
    }
    
    // Helper function to expand around center and return palindrome length
    private int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n²) - expand around center for each position
 * Space Complexity: O(n) - for result string
 */

// Helper function to expand around center and return palindrome length
int expandAroundCenter(char* s, int left, int right, int len) {
    while (left >= 0 && right < len && s[left] == s[right]) {
        left--;
        right++;
    }
    return right - left - 1;
}

char* longestPalindrome(char* s) {
    int len = strlen(s);
    if (len < 1) {
        char* result = (char*)malloc(1);
        result[0] = '\0';
        return result;
    }
    
    int start = 0, maxLen = 1;
    
    for (int i = 0; i < len; i++) {
        // Check for odd length palindromes (center is single character)
        int len1 = expandAroundCenter(s, i, i, len);
        // Check for even length palindromes (center is between two characters)
        int len2 = expandAroundCenter(s, i, i + 1, len);
        
        int currentLen = (len1 > len2) ? len1 : len2;
        
        // Update start and maxLen if longer palindrome found
        if (currentLen > maxLen) {
            maxLen = currentLen;
            start = i - (currentLen - 1) / 2;
        }
    }
    
    // Create result substring
    char* result = (char*)malloc((maxLen + 1) * sizeof(char));
    strncpy(result, s + start, maxLen);
    result[maxLen] = '\0';
    
    return result;
}