// Java Solution
/*
 * Time Complexity: O(n) - where n is length of string
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int romanToInt(String s) {
        int result = 0;
        int prevValue = 0;
        
        // Traverse from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            int currentValue = getValue(s.charAt(i));
            
            // If current value is less than previous, subtract it (e.g., IV = 5 - 1)
            // Otherwise add it
            if (currentValue < prevValue) {
                result -= currentValue;
            } else {
                result += currentValue;
            }
            
            prevValue = currentValue;
        }
        
        return result;
    }
    
    private int getValue(char c) {
        switch (c) {
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return 0;
        }
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - where n is length of string
 * Space Complexity: O(1) - constant space
 */

// Helper function to get integer value of roman character
int getValue(char c) {
    switch (c) {
        case 'I': return 1;
        case 'V': return 5;
        case 'X': return 10;
        case 'L': return 50;
        case 'C': return 100;
        case 'D': return 500;
        case 'M': return 1000;
        default: return 0;
    }
}

int romanToInt(char* s) {
    int result = 0;
    int prevValue = 0;
    int len = strlen(s);
    
    // Traverse from right to left
    for (int i = len - 1; i >= 0; i--) {
        int currentValue = getValue(s[i]);
        
        // If current value is less than previous, subtract it (e.g., IV = 5 - 1)
        // Otherwise add it
        if (currentValue < prevValue) {
            result -= currentValue;
        } else {
            result += currentValue;
        }
        
        prevValue = currentValue;
    }
    
    return result;
}