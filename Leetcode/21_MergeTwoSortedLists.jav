// Java Solution
/*
 * Time Complexity: O(n + m) - traverse both lists once
 * Space Complexity: O(1) - only pointer manipulation, no extra space
 * 
 * Approach:
 * 1. Create dummy node to simplify edge cases
 * 2. Use pointer to track current position in merged list
 * 3. Compare values from both lists, attach smaller node
 * 4. Move pointer in list that provided the node
 * 5. Attach remaining nodes from non-empty list
 * 6. Return dummy.next as the merged list head
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // Dummy node to simplify list building
        ListNode dummyHead = new ListNode(0);
        ListNode currentNode = dummyHead;
        
        // Merge nodes while both lists have elements
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                currentNode.next = list1;
                list1 = list1.next;
            } else {
                currentNode.next = list2;
                list2 = list2.next;
            }
            currentNode = currentNode.next;
        }
        
        // Attach remaining nodes from non-empty list
        if (list1 != null) {
            currentNode.next = list1;
        } else {
            currentNode.next = list2;
        }
        
        return dummyHead.next;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n + m) - single pass through both lists
 * Space Complexity: O(1) - constant extra space (iterative approach)
 * 
 * Approach:
 * 1. Use dummy node to avoid special handling for head
 * 2. Compare values from both lists
 * 3. Attach node with smaller value to result list
 * 4. Advance pointer in the list that provided the node
 * 5. When one list exhausted, attach remainder of other list
 * 6. Return merged list starting from dummy.next
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    // Create dummy node to simplify list construction
    struct ListNode dummyNode;
    dummyNode.val = 0;
    dummyNode.next = NULL;
    
    struct ListNode* currentPtr = &dummyNode;
    
    // Merge while both lists have nodes
    while (list1 != NULL && list2 != NULL) {
        if (list1->val <= list2->val) {
            // Attach node from list1
            currentPtr->next = list1;
            list1 = list1->next;
        } else {
            // Attach node from list2
            currentPtr->next = list2;
            list2 = list2->next;
        }
        // Move to newly attached node
        currentPtr = currentPtr->next;
    }
    
    // Attach remaining nodes from whichever list is non-empty
    if (list1 != NULL) {
        currentPtr->next = list1;
    } else {
        currentPtr->next = list2;
    }
    
    return dummyNode.next;
}