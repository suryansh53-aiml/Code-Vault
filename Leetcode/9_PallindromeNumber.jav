// Java Solution
/*
 * Time Complexity: O(log(x)) - number of digits in x
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public boolean isPalindrome(int x) {
        // Negative numbers are not palindromes
        // Numbers ending in 0 (except 0 itself) are not palindromes
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        
        int reversedHalf = 0;
        
        // Reverse only half of the number
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }
        
        // For even length: x == reversedHalf
        // For odd length: x == reversedHalf / 10 (middle digit doesn't matter)
        return x == reversedHalf || x == reversedHalf / 10;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(log(x)) - number of digits in x
 * Space Complexity: O(1) - constant space
 */
bool isPalindrome(int x) {
    // Negative numbers are not palindromes
    // Numbers ending in 0 (except 0 itself) are not palindromes
    if (x < 0 || (x % 10 == 0 && x != 0)) {
        return false;
    }
    
    int reversedHalf = 0;
    
    // Reverse only half of the number
    while (x > reversedHalf) {
        reversedHalf = reversedHalf * 10 + x % 10;
        x /= 10;
    }
    
    // For even length: x == reversedHalf
    // For odd length: x == reversedHalf / 10 (middle digit doesn't matter)
    return x == reversedHalf || x == reversedHalf / 10;
}