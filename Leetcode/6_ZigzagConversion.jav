// Java Solution
/*
 * Time Complexity: O(n) - where n is length of string
 * Space Complexity: O(n) - for storing result
 */
class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1 or greater than string length
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }
        
        // Create array of StringBuilders for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int currentRow = 0;
        boolean goingDown = false;
        
        // Traverse each character and place in appropriate row
        for (char c : s.toCharArray()) {
            rows[currentRow].append(c);
            
            // Change direction at first and last row
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            
            // Move to next row
            currentRow += goingDown ? 1 : -1;
        }
        
        // Combine all rows into result
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }
        
        return result.toString();
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - where n is length of string
 * Space Complexity: O(n) - for storing result only
 */
char* convert(char* s, int numRows) {
    int len = strlen(s);
    
    // Edge case: if numRows is 1 or greater than string length
    if (numRows == 1 || numRows >= len) {
        char* result = (char*)malloc((len + 1) * sizeof(char));
        strcpy(result, s);
        return result;
    }
    
    // Allocate result string
    char* result = (char*)malloc((len + 1) * sizeof(char));
    int index = 0;
    
    int cycleLen = 2 * numRows - 2; // Characters per complete zigzag cycle
    
    // Process each row
    for (int row = 0; row < numRows; row++) {
        for (int i = row; i < len; i += cycleLen) {
            // Add character from current position
            result[index++] = s[i];
            
            // Add diagonal character (for middle rows only)
            if (row != 0 && row != numRows - 1) {
                int diagonalIndex = i + cycleLen - 2 * row;
                if (diagonalIndex < len) {
                    result[index++] = s[diagonalIndex];
                }
            }
        }
    }
    
    result[index] = '\0';
    return result;
}