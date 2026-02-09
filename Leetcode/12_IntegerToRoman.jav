// Java Solution
/*
 * Time Complexity: O(1) - at most 13 iterations (max roman numeral length)
 * Space Complexity: O(1) - constant space for arrays
 */
class Solution {
    public String intToRoman(int num) {
        // Arrays for values and corresponding roman numerals in descending order
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        StringBuilder result = new StringBuilder();
        
        // Process each value-symbol pair
        for (int i = 0; i < values.length; i++) {
            // Add symbol while num is greater than or equal to current value
            while (num >= values[i]) {
                result.append(symbols[i]);
                num -= values[i];
            }
        }
        
        return result.toString();
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(1) - fixed iterations based on digit extraction
 * Space Complexity: O(1) - constant space
 */
char* intToRoman(int num) {
    // Lookup tables for each digit position
    char* thousands[] = {"", "M", "MM", "MMM"};
    char* hundreds[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
    char* tens[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
    char* ones[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
    
    char* result = (char*)malloc(16 * sizeof(char));
    int pos = 0;
    
    // Extract and convert thousands place
    char* str = thousands[num / 1000];
    while (*str) result[pos++] = *str++;
    
    // Extract and convert hundreds place
    str = hundreds[(num % 1000) / 100];
    while (*str) result[pos++] = *str++;
    
    // Extract and convert tens place
    str = tens[(num % 100) / 10];
    while (*str) result[pos++] = *str++;
    
    // Extract and convert ones place
    str = ones[num % 10];
    while (*str) result[pos++] = *str++;
    
    result[pos] = '\0';
    return result;
}