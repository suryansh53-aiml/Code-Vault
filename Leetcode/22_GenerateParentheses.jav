// Java Solution
/*
 * Time Complexity: O(4^n / √n) - Catalan number, approximately exponential
 * Space Complexity: O(n) - recursion depth and string builder
 * 
 * Approach:
 * 1. Use backtracking to generate all valid combinations
 * 2. Track count of open '(' and close ')' parentheses used
 * 3. Add '(' if we haven't used all n opening parentheses
 * 4. Add ')' only if it won't exceed number of '(' (maintains validity)
 * 5. When string length reaches 2*n, add to result
 */
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtrack(result, new StringBuilder(), 0, 0, n);
        return result;
    }
    
    private void backtrack(List<String> result, StringBuilder current, 
                          int openCount, int closeCount, int maxPairs) {
        // Base case: generated valid combination of n pairs
        if (current.length() == maxPairs * 2) {
            result.add(current.toString());
            return;
        }
        
        // Add opening parenthesis if we haven't used all n
        if (openCount < maxPairs) {
            current.append('(');
            backtrack(result, current, openCount + 1, closeCount, maxPairs);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
        
        // Add closing parenthesis only if it doesn't exceed opening count
        if (closeCount < openCount) {
            current.append(')');
            backtrack(result, current, openCount, closeCount + 1, maxPairs);
            current.deleteCharAt(current.length() - 1); // Backtrack
        }
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(4^n / √n) - Catalan number sequence
 * Space Complexity: O(n) - recursion stack and string buffer
 * 
 * Approach:
 * 1. Use backtracking to build valid parentheses strings
 * 2. Maintain counts: openUsed (how many '(' added), closeUsed (how many ')' added)
 * 3. Can add '(' if openUsed < n
 * 4. Can add ')' only if closeUsed < openUsed (ensures validity)
 * 5. When length = 2*n, store the valid combination
 */

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */

// Helper function to perform backtracking
void generateCombinations(char** results, int* resultCount, char* currentStr, 
                         int position, int openUsed, int closeUsed, int maxPairs) {
    // Base case: generated complete valid string
    if (position == maxPairs * 2) {
        currentStr[position] = '\0';
        results[*resultCount] = (char*)malloc((position + 1) * sizeof(char));
        strcpy(results[*resultCount], currentStr);
        (*resultCount)++;
        return;
    }
    
    // Try adding opening parenthesis
    if (openUsed < maxPairs) {
        currentStr[position] = '(';
        generateCombinations(results, resultCount, currentStr, position + 1, 
                           openUsed + 1, closeUsed, maxPairs);
    }
    
    // Try adding closing parenthesis (only if valid)
    if (closeUsed < openUsed) {
        currentStr[position] = ')';
        generateCombinations(results, resultCount, currentStr, position + 1, 
                           openUsed, closeUsed + 1, maxPairs);
    }
}

char** generateParenthesis(int n, int* returnSize) {
    // Calculate max possible combinations (Catalan number)
    // For n=3, we get 5 combinations; for safety, allocate more
    int maxCombinations = 1;
    for (int i = 0; i < n; i++) {
        maxCombinations *= 4; // Upper bound approximation
    }
    
    char** results = (char**)malloc(maxCombinations * sizeof(char*));
    char* currentStr = (char*)malloc((2 * n + 1) * sizeof(char));
    *returnSize = 0;
    
    generateCombinations(results, returnSize, currentStr, 0, 0, 0, n);
    
    free(currentStr);
    return results;
}

// Optimised: More Efficient Memory Location
void backtrack(char** ans, int* count, char* str, int pos, int open, int close, int n) {
    if (pos == n * 2) {
        str[pos] = '\0';
        ans[*count] = (char*)malloc((pos + 1) * sizeof(char));
        strcpy(ans[*count], str);
        (*count)++;
        return;
    }
    
    if (open < n) {
        str[pos] = '(';
        backtrack(ans, count, str, pos + 1, open + 1, close, n);
    }
    
    if (close < open) {
        str[pos] = ')';
        backtrack(ans, count, str, pos + 1, open, close + 1, n);
    }
}

char** generateParenthesis(int n, int* returnSize) {
    // Catalan number C_n = (2n)! / ((n+1)! * n!)
    // For n=1: 1, n=2: 2, n=3: 5, n=4: 14
    int capacity = 2000; // Safe upper bound for reasonable n
    
    char** result = (char**)malloc(capacity * sizeof(char*));
    char* buffer = (char*)malloc((2 * n + 1) * sizeof(char));
    *returnSize = 0;
    
    backtrack(result, returnSize, buffer, 0, 0, 0, n);
    
    free(buffer);
    return result;
}