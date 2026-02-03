// Java Solution
/*
 * Time Complexity: O(log(min(m, n))) - binary search on smaller array
 * Space Complexity: O(1) - constant space
 */
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Ensure nums1 is the smaller array for efficiency
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int m = nums1.length;
        int n = nums2.length;
        int low = 0, high = m;
        
        while (low <= high) {
            // Partition positions in both arrays
            int partition1 = (low + high) / 2;
            int partition2 = (m + n + 1) / 2 - partition1;
            
            // Handle edge cases for partitions
            int maxLeft1 = (partition1 == 0) ? Integer.MIN_VALUE : nums1[partition1 - 1];
            int minRight1 = (partition1 == m) ? Integer.MAX_VALUE : nums1[partition1];
            
            int maxLeft2 = (partition2 == 0) ? Integer.MIN_VALUE : nums2[partition2 - 1];
            int minRight2 = (partition2 == n) ? Integer.MAX_VALUE : nums2[partition2];
            
            // Check if we found the correct partition
            if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
                // If total length is even
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxLeft1, maxLeft2) + Math.min(minRight1, minRight2)) / 2.0;
                } else {
                    // If total length is odd
                    return Math.max(maxLeft1, maxLeft2);
                }
            } else if (maxLeft1 > minRight2) {
                // Move partition1 to left
                high = partition1 - 1;
            } else {
                // Move partition1 to right
                low = partition1 + 1;
            }
        }
        
        return 0.0;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(log(min(m, n))) - binary search on smaller array
 * Space Complexity: O(1) - constant space
 */
double findMedianSortedArrays(int* nums1, int nums1Size, int* nums2, int nums2Size) {
    // Ensure nums1 is the smaller array
    if (nums1Size > nums2Size) {
        return findMedianSortedArrays(nums2, nums2Size, nums1, nums1Size);
    }
    
    int m = nums1Size;
    int n = nums2Size;
    int low = 0, high = m;
    
    while (low <= high) {
        // Partition positions in both arrays
        int partition1 = (low + high) / 2;
        int partition2 = (m + n + 1) / 2 - partition1;
        
        // Handle edge cases for partitions
        int maxLeft1 = (partition1 == 0) ? INT_MIN : nums1[partition1 - 1];
        int minRight1 = (partition1 == m) ? INT_MAX : nums1[partition1];
        
        int maxLeft2 = (partition2 == 0) ? INT_MIN : nums2[partition2 - 1];
        int minRight2 = (partition2 == n) ? INT_MAX : nums2[partition2];
        
        // Check if we found the correct partition
        if (maxLeft1 <= minRight2 && maxLeft2 <= minRight1) {
            // If total length is even
            if ((m + n) % 2 == 0) {
                int maxLeft = (maxLeft1 > maxLeft2) ? maxLeft1 : maxLeft2;
                int minRight = (minRight1 < minRight2) ? minRight1 : minRight2;
                return (maxLeft + minRight) / 2.0;
            } else {
                // If total length is odd
                return (maxLeft1 > maxLeft2) ? maxLeft1 : maxLeft2;
            }
        } else if (maxLeft1 > minRight2) {
            // Move partition1 to left
            high = partition1 - 1;
        } else {
            // Move partition1 to right
            low = partition1 + 1;
        }
    }
    
    return 0.0;
}