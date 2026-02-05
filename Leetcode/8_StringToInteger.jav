// Java Solution
/*
 * Time Complexity: O(n) - where n is length of string
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        int result = 0, sign = 1;
        
        // Step 1: Skip leading whitespaces
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        
        // Step 2: Check for sign
        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            sign = (s.charAt(i) == '-') ? -1 : 1;
            i++;
        }
        
        // Step 3: Convert digits and check for overflow
        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            
            // Check overflow before adding digit
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return (sign == 1) ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            
            result = result * 10 + digit;
            i++;
        }
        
        return result * sign;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - where n is length of string
 * Space Complexity: O(1) - constant space
 */
int myAtoi(char* s) {
    int i = 0;
    int result = 0, sign = 1;
    
    // Step 1: Skip leading whitespaces
    while (s[i] == ' ') {
        i++;
    }
    
    // Step 2: Check for sign
    if (s[i] == '+' || s[i] == '-') {
        sign = (s[i] == '-') ? -1 : 1;
        i++;
    }
    
    // Step 3: Convert digits and check for overflow
    while (s[i] >= '0' && s[i] <= '9') {
        int digit = s[i] - '0';
        
        // Check overflow before adding digit
        if (result > INT_MAX / 10 || 
            (result == INT_MAX / 10 && digit > 7)) {
            return (sign == 1) ? INT_MAX : INT_MIN;
        }
        
        result = result * 10 + digit;
        i++;
    }
    
    return result * sign;
}