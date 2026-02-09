// Java Solution
/*
 * Time Complexity: O(n) - single pass with two pointers
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int maxArea = 0;
        
        // Use two pointers approaching from both ends
        while (left < right) {
            // Calculate area with current left and right pointers
            int width = right - left;
            int currentHeight = Math.min(height[left], height[right]);
            int currentArea = width * currentHeight;
            
            // Update maximum area
            maxArea = Math.max(maxArea, currentArea);
            
            // Move pointer with smaller height (to potentially find taller line)
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - single pass with two pointers
 * Space Complexity: O(1) - constant space
 */
int maxArea(int* height, int heightSize) {
    int left = 0;
    int right = heightSize - 1;
    int maxArea = 0;
    
    // Use two pointers approaching from both ends
    while (left < right) {
        // Calculate area with current left and right pointers
        int width = right - left;
        int currentHeight = (height[left] < height[right]) ? height[left] : height[right];
        int currentArea = width * currentHeight;
        
        // Update maximum area
        if (currentArea > maxArea) {
            maxArea = currentArea;
        }
        
        // Move pointer with smaller height (to potentially find taller line)
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxArea;
}