// Java Solution
/*
 * Time Complexity: O(n * m) - where n is number of strings, m is length of shortest string
 * Space Complexity: O(1) - constant space (excluding output)
 */
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        
        // Use first string as reference
        String prefix = strs[0];
        
        // Compare with each subsequent string
        for (int i = 1; i < strs.length; i++) {
            // Reduce prefix until it matches the start of current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                
                // If prefix becomes empty, no common prefix exists
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        
        return prefix;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n * m) - where n is number of strings, m is length of shortest string
 * Space Complexity: O(m) - for result string
 */
char* longestCommonPrefix(char** strs, int strsSize) {
    if (strsSize == 0) {
        char* result = (char*)malloc(1);
        result[0] = '\0';
        return result;
    }
    
    // Find minimum length among all strings
    int minLen = strlen(strs[0]);
    for (int i = 1; i < strsSize; i++) {
        int len = strlen(strs[i]);
        if (len < minLen) {
            minLen = len;
        }
    }
    
    // Check each character position
    int prefixLen = 0;
    for (int i = 0; i < minLen; i++) {
        char currentChar = strs[0][i];
        
        // Check if all strings have the same character at position i
        for (int j = 1; j < strsSize; j++) {
            if (strs[j][i] != currentChar) {
                // Mismatch found, create result and return
                char* result = (char*)malloc((prefixLen + 1) * sizeof(char));
                strncpy(result, strs[0], prefixLen);
                result[prefixLen] = '\0';
                return result;
            }
        }
        
        prefixLen++;
    }
    
    // All characters matched up to minLen
    char* result = (char*)malloc((prefixLen + 1) * sizeof(char));
    strncpy(result, strs[0], prefixLen);
    result[prefixLen] = '\0';
    return result;
}