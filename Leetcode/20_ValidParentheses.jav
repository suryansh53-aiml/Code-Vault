// Java Solution
/*
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(n) - stack can contain up to n/2 elements
 * 
 * Approach:
 * 1. Use stack to track opening brackets
 * 2. For opening brackets: push to stack
 * 3. For closing brackets: check if matches top of stack
 * 4. Valid if stack is empty at end and all brackets matched
 */
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            // Push opening brackets onto stack
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } 
            // For closing brackets, check matching
            else {
                // Stack empty means no matching opening bracket
                if (stack.isEmpty()) {
                    return false;
                }
                
                char top = stack.pop();
                
                // Check if brackets match
                if (c == ')' && top != '(') return false;
                if (c == ']' && top != '[') return false;
                if (c == '}' && top != '{') return false;
            }
        }
        
        // Valid only if all brackets were matched (stack empty)
        return stack.isEmpty();
    }
}
// -------------------------------------------------------------------------------

// C Solution
/*
 * Time Complexity: O(n) - single pass through string
 * Space Complexity: O(n) - stack array
 * 
 * Approach:
 * 1. Implement stack using array
 * 2. Push opening brackets onto stack
 * 3. For closing brackets, pop and verify match
 * 4. Return true if stack empty at end
 */

bool isValid(char* s) {
    int len = 0;
    while (s[len] != '\0') len++;
    
    // Edge case: odd length can't be valid
    if (len % 2 != 0) {
        return false;
    }
    
    // Stack to store opening brackets
    char* stack = (char*)malloc(len * sizeof(char));
    int top = -1; // Stack pointer (-1 means empty)
    
    for (int i = 0; i < len; i++) {
        char current = s[i];
        
        // Push opening brackets onto stack
        if (current == '(' || current == '[' || current == '{') {
            stack[++top] = current;
        }
        // Handle closing brackets
        else {
            // Stack empty: no matching opening bracket
            if (top == -1) {
                free(stack);
                return false;
            }
            
            char topChar = stack[top--];
            
            // Check if brackets match
            if (current == ')' && topChar != '(') {
                free(stack);
                return false;
            }
            if (current == ']' && topChar != '[') {
                free(stack);
                return false;
            }
            if (current == '}' && topChar != '{') {
                free(stack);
                return false;
            }
        }
    }
    
    // Valid only if stack is empty (all matched)
    bool result = (top == -1);
    free(stack);
    return result;
}