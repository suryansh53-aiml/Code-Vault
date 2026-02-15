// Java Solution
/*
 * Time Complexity: O(n) - single pass through list
 * Space Complexity: O(1) - only pointer manipulation
 * 
 * Approach:
 * 1. Use dummy node to handle edge cases (swapping head)
 * 2. Use three pointers: previous, first, second
 * 3. For each pair, rewire pointers to swap nodes
 * 4. Move to next pair and repeat
 * 5. If odd number of nodes, last node remains unchanged
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
    public ListNode swapPairs(ListNode head) {
        // Dummy node to simplify edge cases
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode prevNode = dummyHead;
        
        // Process pairs while at least 2 nodes remain
        while (prevNode.next != null && prevNode.next.next != null) {
            // Identify nodes to swap
            ListNode firstNode = prevNode.next;
            ListNode secondNode = prevNode.next.next;
            
            // Perform the swap
            // Before: prev -> first -> second -> remaining
            // After:  prev -> second -> first -> remaining
            
            firstNode.next = secondNode.next;  // first points to node after second
            secondNode.next = firstNode;        // second points to first
            prevNode.next = secondNode;         // prev points to second
            
            // Move to next pair (first is now after second)
            prevNode = firstNode;
        }
        
        return dummyHead.next;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - traverse list once
 * Space Complexity: O(1) - constant space (iterative)
 * 
 * Approach:
 * 1. Create dummy node pointing to head
 * 2. Use prevNode to track node before pair to swap
 * 3. For each pair (node1, node2):
 *    - Rewire: prev -> node2 -> node1 -> rest
 * 4. Move prevNode to node1 (now after node2)
 * 5. Continue until fewer than 2 nodes remain
 */

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */

struct ListNode* swapPairs(struct ListNode* head) {
    // Create dummy node to simplify head swapping
    struct ListNode dummyNode;
    dummyNode.val = 0;
    dummyNode.next = head;
    
    struct ListNode* previousNode = &dummyNode;
    
    // Continue while at least 2 nodes available to swap
    while (previousNode->next != NULL && previousNode->next->next != NULL) {
        // Identify the two nodes to swap
        struct ListNode* firstNode = previousNode->next;
        struct ListNode* secondNode = previousNode->next->next;
        
        // Perform pointer rewiring for swap
        // Original: prev -> first -> second -> remaining
        // Target:   prev -> second -> first -> remaining
        
        firstNode->next = secondNode->next;   // first points to node after second
        secondNode->next = firstNode;          // second points back to first
        previousNode->next = secondNode;       // prev now points to second
        
        // Move previous pointer to firstNode (now second in pair)
        previousNode = firstNode;
    }
    
    return dummyNode.next;
}