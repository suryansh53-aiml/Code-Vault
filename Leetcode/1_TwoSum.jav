// Java Solution
/*
 * Time Complexity: O(n) - single pass through array
 * Space Complexity: O(n) - HashMap storage
 */
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // Store number and its index for quick lookup
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            
            // Check if complement exists in map
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            
            map.put(nums[i], i);
        }
        
        return new int[] {};
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n²) - nested loops
 * Space Complexity: O(1) - only result array
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* twoSum(int* nums, int numsSize, int target, int* returnSize) {
    int* result = (int*)malloc(2 * sizeof(int));
    *returnSize = 2;
    
    // Brute force: check all pairs
    for (int i = 0; i < numsSize - 1; i++) {
        for (int j = i + 1; j < numsSize; j++) {
            if (nums[i] + nums[j] == target) {
                result[0] = i;
                result[1] = j;
                return result;
            }
        }
    }
    
    return result;
}