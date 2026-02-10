// Java Solution
/*
 * Time Complexity: O(n²) - sorting O(n log n) + two pointer approach O(n²)
 * Space Complexity: O(1) - constant space
 * 
 * Approach:
 * 1. Sort the array
 * 2. Fix first element, use two pointers for remaining two
 * 3. Track closest sum by comparing absolute differences with target
 * 4. Move pointers based on whether current sum is less than or greater than target
 * 5. Early return if exact match found
 */
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closestSum = nums[0] + nums[1] + nums[2];
        
        for (int i = 0; i < nums.length - 2; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            
            while (left < right) {
                int currentSum = nums[i] + nums[left] + nums[right];
                
                if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                    closestSum = currentSum;
                }
                
                if (currentSum == target) {
                    return currentSum;
                } else if (currentSum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return closestSum;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n²) - sorting O(n log n) + two pointer approach O(n²)
 * Space Complexity: O(1) - constant space
 * 
 * Approach:
 * 1. Sort the array
 * 2. Fix first element, use two pointers for remaining two
 * 3. Track closest sum by comparing absolute differences with target
 * 4. Move pointers based on whether current sum is less than or greater than target
 * 5. Early return if exact match found
 */

int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int abs(int x) {
    return x < 0 ? -x : x;
}

int threeSumClosest(int* nums, int numsSize, int target) {
    qsort(nums, numsSize, sizeof(int), compare);
    
    int closestSum = nums[0] + nums[1] + nums[2];
    
    for (int i = 0; i < numsSize - 2; i++) {
        int left = i + 1;
        int right = numsSize - 1;
        
        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];
            
            if (abs(currentSum - target) < abs(closestSum - target)) {
                closestSum = currentSum;
            }
            
            if (currentSum == target) {
                return currentSum;
            } else if (currentSum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return closestSum;
}