// Java Solution
/*
 * Time Complexity: O(4^n) where n is length of digits
 *                  Each digit maps to 3-4 letters, worst case is 4^n combinations
 * Space Complexity: O(n) for recursion stack depth
 * 
 * Approach:
 * 1. Use backtracking to generate all possible combinations
 * 2. Map each digit to its corresponding letters (like old phone keypad)
 * 3. Build combinations character by character recursively
 * 4. Add complete combination when we've processed all digits
 */
class Solution {
    // Mapping of digits to letters (phone keypad)
    private static final String[] DIGIT_TO_LETTERS = {
        "",     // 0
        "",     // 1
        "abc",  // 2
        "def",  // 3
        "ghi",  // 4
        "jkl",  // 5
        "mno",  // 6
        "pqrs", // 7
        "tuv",  // 8
        "wxyz"  // 9
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        // Handle empty input
        if (digits == null || digits.length() == 0) {
            return result;
        }
        
        // Start backtracking from index 0
        backtrack(digits, 0, new StringBuilder(), result);
        return result;
    }
    
    private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
        // Base case: built a complete combination
        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }
        
        // Get the letters that current digit maps to
        char digit = digits.charAt(index);
        String letters = DIGIT_TO_LETTERS[digit - '0'];
        
        // Try each possible letter for this digit
        for (int i = 0; i < letters.length(); i++) {
            char letter = letters.charAt(i);
            
            // Add current letter to combination
            current.append(letter);
            
            // Recurse to next digit
            backtrack(digits, index + 1, current, result);
            
            // Backtrack: remove last letter to try next option
            current.deleteCharAt(current.length() - 1);
        }
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(4^n) where n is length of digits
 * Space Complexity: O(4^n) for storing all combinations
 * 
 * Approach:
 * 1. Create digit-to-letter mapping array
 * 2. Use recursive backtracking to build combinations
 * 3. Allocate memory for result array and individual strings
 * 4. Build combinations character by character
 */

// Mapping of digits to their corresponding letters
static const char* digitMap[10] = {
    "",      // 0
    "",      // 1
    "abc",   // 2
    "def",   // 3
    "ghi",   // 4
    "jkl",   // 5
    "mno",   // 6
    "pqrs",  // 7
    "tuv",   // 8
    "wxyz"   // 9
};

// Helper function to perform backtracking
static void generateCombinations(char* digits, int digitIndex, char* currentCombo, 
                                 int comboIndex, char** results, int* resultCount) {
    // Base case: processed all digits, add combination to results
    if (digits[digitIndex] == '\0') {
        currentCombo[comboIndex] = '\0'; // Null-terminate the string
        results[*resultCount] = (char*)malloc((comboIndex + 1) * sizeof(char));
        strcpy(results[*resultCount], currentCombo);
        (*resultCount)++;
        return;
    }
    
    // Get current digit and its corresponding letters
    int digit = digits[digitIndex] - '0';
    const char* letters = digitMap[digit];
    
    // Try each letter mapped to current digit
    for (int i = 0; letters[i] != '\0'; i++) {
        // Add current letter to combination
        currentCombo[comboIndex] = letters[i];
        
        // Recurse to process next digit
        generateCombinations(digits, digitIndex + 1, currentCombo, 
                            comboIndex + 1, results, resultCount);
    }
}

char** letterCombinations(char* digits, int* returnSize) {
    *returnSize = 0;
    
    // Handle empty input
    if (digits == NULL || digits[0] == '\0') {
        return NULL;
    }
    
    // Calculate maximum possible combinations
    int digitsLen = 0;
    int maxCombinations = 1;
    
    while (digits[digitsLen] != '\0') {
        int digit = digits[digitsLen] - '0';
        int letterCount = 0;
        while (digitMap[digit][letterCount] != '\0') letterCount++;
        maxCombinations *= letterCount;
        digitsLen++;
    }
    
    // Allocate memory for results
    char** results = (char**)malloc(maxCombinations * sizeof(char*));
    char* currentCombo = (char*)malloc((digitsLen + 1) * sizeof(char));
    
    // Generate all combinations
    generateCombinations(digits, 0, currentCombo, 0, results, returnSize);
    
    free(currentCombo);
    return results;
}