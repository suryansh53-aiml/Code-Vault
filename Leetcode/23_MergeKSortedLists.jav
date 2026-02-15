// Java Solution
/*
 * Time Complexity: O(N log k) where N = total nodes, k = number of lists
 *                  Each node inserted/extracted from heap: O(log k)
 * Space Complexity: O(k) - priority queue stores at most k nodes
 * 
 * Approach:
 * 1. Use min-heap (priority queue) to track smallest node among k lists
 * 2. Initialize heap with head of each non-null list
 * 3. Repeatedly extract minimum node from heap
 * 4. Add extracted node to result list
 * 5. If extracted node has next, add next node to heap
 * 6. Continue until heap is empty
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
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        // Min-heap to store nodes, ordered by value
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(
            (a, b) -> a.val - b.val
        );
        
        // Add head of each non-null list to heap
        for (ListNode head : lists) {
            if (head != null) {
                minHeap.offer(head);
            }
        }
        
        // Dummy node to build result list
        ListNode dummyHead = new ListNode(0);
        ListNode currentTail = dummyHead;
        
        // Extract minimum node repeatedly
        while (!minHeap.isEmpty()) {
            // Get node with smallest value
            ListNode smallestNode = minHeap.poll();
            
            // Attach to result list
            currentTail.next = smallestNode;
            currentTail = currentTail.next;
            
            // If this node has next, add it to heap
            if (smallestNode.next != null) {
                minHeap.offer(smallestNode.next);
            }
        }
        
        return dummyHead.next;
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(N log k) - merge pairs repeatedly
 * Space Complexity: O(log k) - recursion depth
 * 
 * More space-efficient approach using merge sort strategy
 */

// Merge two sorted linked lists
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {
    if (!list1) return list2;
    if (!list2) return list1;
    
    struct ListNode dummy = {0, NULL};
    struct ListNode* tail = &dummy;
    
    while (list1 && list2) {
        if (list1->val <= list2->val) {
            tail->next = list1;
            list1 = list1->next;
        } else {
            tail->next = list2;
            list2 = list2->next;
        }
        tail = tail->next;
    }
    
    tail->next = list1 ? list1 : list2;
    return dummy.next;
}

// Merge lists in range [left, right]
struct ListNode* mergeRange(struct ListNode** lists, int left, int right) {
    if (left == right) {
        return lists[left];
    }
    
    if (left > right) {
        return NULL;
    }
    
    int mid = left + (right - left) / 2;
    struct ListNode* leftMerged = mergeRange(lists, left, mid);
    struct ListNode* rightMerged = mergeRange(lists, mid + 1, right);
    
    return mergeTwoLists(leftMerged, rightMerged);
}

struct ListNode* mergeKLists(struct ListNode** lists, int listsSize) {
    if (lists == NULL || listsSize == 0) {
        return NULL;
    }
    
    return mergeRange(lists, 0, listsSize - 1);
}