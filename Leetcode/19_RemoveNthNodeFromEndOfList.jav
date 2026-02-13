// Java Solution
/*
 * Time Complexity: O(n) - single pass through list
 * Space Complexity: O(1) - only pointer variables
 * 
 * Approach:
 * 1. Use two pointers (fast and slow) with n+1 gap between them
 * 2. Move fast pointer n steps ahead first
 * 3. Then move both pointers until fast reaches end
 * 4. Slow pointer will be at node before the one to remove
 * 5. Use dummy node to handle edge case of removing head
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // Create dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode fast = dummy;
        ListNode slow = dummy;
        
        // Move fast pointer n+1 steps ahead
        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // Move both pointers until fast reaches end
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        // Remove the nth node from end
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - single pass through linked list
 * Space Complexity: O(1) - constant extra space
 * 
 * Approach:
 * 1. Create dummy node pointing to head (handles removing first node)
 * 2. Use two pointers: fast and slow
 * 3. Advance fast pointer n+1 steps ahead
 * 4. Move both pointers together until fast reaches NULL
 * 5. Slow pointer will be just before node to remove
 * 6. Skip the target node by adjusting pointers
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* removeNthFromEnd(struct ListNode* head, int n) {
    // Create dummy node to simplify edge cases
    struct ListNode dummy;
    dummy.val = 0;
    dummy.next = head;
    
    struct ListNode* fastPtr = &dummy;
    struct ListNode* slowPtr = &dummy;
    
    // Move fast pointer n+1 steps ahead
    for (int i = 0; i <= n; i++) {
        fastPtr = fastPtr->next;
    }
    
    // Move both pointers until fast reaches end
    while (fastPtr != NULL) {
        fastPtr = fastPtr->next;
        slowPtr = slowPtr->next;
    }
    
    // Remove the nth node from end
    struct ListNode* nodeToRemove = slowPtr->next;
    slowPtr->next = slowPtr->next->next;
    
    // Optional: free the removed node (if managing memory)
    // free(nodeToRemove);
    
    return dummy.next;
}