/*
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(min(n, m)) - where m is charset size
 */
class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store character and its latest index
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0; // Start of current window
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // If character already exists in current window, move start
            if (map.containsKey(currentChar)) {
                start = Math.max(start, map.get(currentChar) + 1);
            }
            
            // Update character's latest position
            map.put(currentChar, end);
            
            // Update max length
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(1) - fixed size array for ASCII characters
 */
int lengthOfLongestSubstring(char* s) {
    // Array to store last index of each character (-1 if not seen)
    int lastIndex[128];
    for (int i = 0; i < 128; i++) {
        lastIndex[i] = -1;
    }
    
    int maxLength = 0;
    int start = 0; // Start of current window
    
    for (int end = 0; s[end] != '\0'; end++) {
        char currentChar = s[end];
        
        // If character seen in current window, move start
        if (lastIndex[currentChar] >= start) {
            start = lastIndex[currentChar] + 1;
        }
        
        // Update character's latest position
        lastIndex[currentChar] = end;
        
        // Update max length
        int currentLength = end - start + 1;
        if (currentLength > maxLength) {
            maxLength = currentLength;
        }
    }
    
    return maxLength;
}