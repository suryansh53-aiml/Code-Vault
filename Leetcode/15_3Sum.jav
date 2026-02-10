// Java Solution
/*
 * Time Complexity: O(n²) - sorting O(n log n) + two pointer approach O(n²)
 * Space Complexity: O(1) - excluding output array
 */
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);  // Sort the array first
        
        for (int i = 0; i < nums.length - 2; i++) {
            // Skip duplicates for first element
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            
            // Early termination: if smallest element > 0, no solution
            if (nums[i] > 0) break;
            
            int left = i + 1;
            int right = nums.length - 1;
            int target = -nums[i];
            
            // Two pointer approach
            while (left < right) {
                int sum = nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                    
                    // Skip duplicates for second element
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    // Skip duplicates for third element
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        
        return result;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n²) - sorting O(n log n) + two pointer approach O(n²)
 * Space Complexity: O(1) - excluding output array
 */

// Comparator for qsort
int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int** threeSum(int* nums, int numsSize, int* returnSize, int** returnColumnSizes) {
    *returnSize = 0;
    if (numsSize < 3) return NULL;
    
    // Allocate memory for result
    int** result = (int**)malloc(numsSize * numsSize * sizeof(int*));
    *returnColumnSizes = (int*)malloc(numsSize * numsSize * sizeof(int));
    
    // Sort the array
    qsort(nums, numsSize, sizeof(int), compare);
    
    for (int i = 0; i < numsSize - 2; i++) {
        // Skip duplicates for first element
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        // Early termination: if smallest element > 0, no solution
        if (nums[i] > 0) break;
        
        int left = i + 1;
        int right = numsSize - 1;
        int target = -nums[i];
        
        // Two pointer approach
        while (left < right) {
            int sum = nums[left] + nums[right];
            
            if (sum == target) {
                // Allocate memory for triplet
                result[*returnSize] = (int*)malloc(3 * sizeof(int));
                result[*returnSize][0] = nums[i];
                result[*returnSize][1] = nums[left];
                result[*returnSize][2] = nums[right];
                (*returnColumnSizes)[*returnSize] = 3;
                (*returnSize)++;
                
                // Skip duplicates for second element
                while (left < right && nums[left] == nums[left + 1]) left++;
                // Skip duplicates for third element
                while (left < right && nums[right] == nums[right - 1]) right--;
                
                left++;
                right--;
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return result;
}