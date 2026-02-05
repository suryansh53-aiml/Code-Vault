// Java Solution
/*
 * Time Complexity: O(log(x)) - number of digits in x
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int reverse(int x) {
        int result = 0;
        
        while (x != 0) {
            int digit = x % 10;
            x /= 10;
            
            // Check for overflow before multiplying by 10
            // Integer.MAX_VALUE = 2147483647, Integer.MIN_VALUE = -2147483648
            if (result > Integer.MAX_VALUE / 10 || 
                (result == Integer.MAX_VALUE / 10 && digit > 7)) {
                return 0;
            }
            if (result < Integer.MIN_VALUE / 10 || 
                (result == Integer.MIN_VALUE / 10 && digit < -8)) {
                return 0;
            }
            
            result = result * 10 + digit;
        }
        
        return result;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(log(x)) - number of digits in x
 * Space Complexity: O(1) - constant space
 */
int reverse(int x) {
    int result = 0;
    
    while (x != 0) {
        int digit = x % 10;
        x /= 10;
        
        // Check for overflow before multiplying by 10
        // INT_MAX = 2147483647, INT_MIN = -2147483648
        if (result > INT_MAX / 10 || 
            (result == INT_MAX / 10 && digit > 7)) {
            return 0;
        }
        if (result < INT_MIN / 10 || 
            (result == INT_MIN / 10 && digit < -8)) {
            return 0;
        }
        
        result = result * 10 + digit;
    }
    
    return result;
}