// Java Solution
/*
 * Time Complexity: O(n³) - three nested loops with two pointers
 * Space Complexity: O(1) excluding output space, O(k) for sorting
 * 
 * Approach:
 * 1. Sort the array to enable two-pointer technique and skip duplicates
 * 2. Fix first two numbers with two loops
 * 3. Use two pointers for remaining two numbers
 * 4. Skip duplicate values to avoid duplicate quadruplets
 * 5. Handle integer overflow by using long for sum calculation
 */
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        // Sort array to use two-pointer approach
        Arrays.sort(nums);
        int n = nums.length;
        
        // Fix first number
        for (int i = 0; i < n - 3; i++) {
            // Skip duplicates for first number
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            // Fix second number
            for (int j = i + 1; j < n - 2; j++) {
                // Skip duplicates for second number
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                // Two pointers for remaining two numbers
                int left = j + 1;
                int right = n - 1;
                
                while (left < right) {
                    // Use long to avoid integer overflow
                    long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                    
                    if (sum == target) {
                        // Found a valid quadruplet
                        result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        
                        // Skip duplicates for third number
                        while (left < right && nums[left] == nums[left + 1]) {
                            left++;
                        }
                        
                        // Skip duplicates for fourth number
                        while (left < right && nums[right] == nums[right - 1]) {
                            right--;
                        }
                        
                        left++;
                        right--;
                    } else if (sum < target) {
                        left++; // Need larger sum
                    } else {
                        right--; // Need smaller sum
                    }
                }
            }
        }
        
        return result;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Additional optimizations:
 * - Early termination when minimum possible sum > target
 * - Early termination when maximum possible sum < target
 */

static int compare(const void* a, const void* b) {
    return (*(int*)a - *(int*)b);
}

int** fourSum(int* nums, int numsSize, int target, int* returnSize, int** returnColumnSizes) {
    *returnSize = 0;
    
    if (nums == NULL || numsSize < 4) {
        *returnColumnSizes = NULL;
        return NULL;
    }
    
    qsort(nums, numsSize, sizeof(int), compare);
    
    int capacity = 100;
    int** results = (int**)malloc(capacity * sizeof(int*));
    *returnColumnSizes = (int*)malloc(capacity * sizeof(int));
    
    for (int first = 0; first < numsSize - 3; first++) {
        // Skip duplicates for first number
        if (first > 0 && nums[first] == nums[first - 1]) {
            continue;
        }
        
        // Early termination: minimum possible sum with first number
        if ((long long)nums[first] + nums[first + 1] + nums[first + 2] + nums[first + 3] > target) {
            break;
        }
        
        // Early continue: maximum possible sum with first number
        if ((long long)nums[first] + nums[numsSize - 3] + nums[numsSize - 2] + nums[numsSize - 1] < target) {
            continue;
        }
        
        for (int second = first + 1; second < numsSize - 2; second++) {
            // Skip duplicates for second number
            if (second > first + 1 && nums[second] == nums[second - 1]) {
                continue;
            }
            
            // Early termination for second loop
            if ((long long)nums[first] + nums[second] + nums[second + 1] + nums[second + 2] > target) {
                break;
            }
            
            // Early continue for second loop
            if ((long long)nums[first] + nums[second] + nums[numsSize - 2] + nums[numsSize - 1] < target) {
                continue;
            }
            
            int left = second + 1;
            int right = numsSize - 1;
            
            while (left < right) {
                long long sum = (long long)nums[first] + nums[second] + nums[left] + nums[right];
                
                if (sum == target) {
                    if (*returnSize >= capacity) {
                        capacity *= 2;
                        results = (int**)realloc(results, capacity * sizeof(int*));
                        *returnColumnSizes = (int*)realloc(*returnColumnSizes, capacity * sizeof(int));
                    }
                    
                    results[*returnSize] = (int*)malloc(4 * sizeof(int));
                    results[*returnSize][0] = nums[first];
                    results[*returnSize][1] = nums[second];
                    results[*returnSize][2] = nums[left];
                    results[*returnSize][3] = nums[right];
                    (*returnColumnSizes)[*returnSize] = 4;
                    (*returnSize)++;
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
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
    }
    
    return results;
}