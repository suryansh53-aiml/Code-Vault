// Java Solution
/*
 * Time Complexity: O(max(m, n)) - where m and n are lengths of two lists
 * Space Complexity: O(max(m, n)) - for the result list
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Dummy node to simplify result list construction
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        // Traverse both lists until both are null and no carry
        while (l1 != null || l2 != null || carry != 0) {
            // Get values from current nodes (0 if node is null)
            int val1 = (l1 != null) ? l1.val : 0;
            int val2 = (l2 != null) ? l2.val : 0;
            
            // Calculate sum and new carry
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            
            // Create new node with digit value
            current.next = new ListNode(sum % 10);
            current = current.next;
            
            // Move to next nodes if available
            if (l1 != null) l1 = l1.next;
            if (l2 != null) l2 = l2.next;
        }
        
        return dummy.next;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(max(m, n)) - where m and n are lengths of two lists
 * Space Complexity: O(max(m, n)) - for the result list
 */
struct ListNode* addTwoNumbers(struct ListNode* l1, struct ListNode* l2) {
    // Dummy node to simplify result list construction
    struct ListNode* dummy = (struct ListNode*)malloc(sizeof(struct ListNode));
    dummy->val = 0;
    dummy->next = NULL;
    
    struct ListNode* current = dummy;
    int carry = 0;
    
    // Traverse both lists until both are null and no carry
    while (l1 != NULL || l2 != NULL || carry != 0) {
        // Get values from current nodes (0 if node is null)
        int val1 = (l1 != NULL) ? l1->val : 0;
        int val2 = (l2 != NULL) ? l2->val : 0;
        
        // Calculate sum and new carry
        int sum = val1 + val2 + carry;
        carry = sum / 10;
        
        // Create new node with digit value
        struct ListNode* newNode = (struct ListNode*)malloc(sizeof(struct ListNode));
        newNode->val = sum % 10;
        newNode->next = NULL;
        
        current->next = newNode;
        current = current->next;
        
        // Move to next nodes if available
        if (l1 != NULL) l1 = l1->next;
        if (l2 != NULL) l2 = l2->next;
    }
    
    return dummy->next;
}