// LeetCode 3: Longest Substring Without Repeating Characters
class Solution {
    public int lengthOfLongestSubstring(String s) 
    {
        int[] lastIndex = new int[128];
        for (int i = 0; i < 128; i++) 
        {
            lastIndex[i] = -1;
        }
        
        int maxLen = 0;
        int left = 0;
        
        for (int right = 0; right < s.length(); right++) 
        {
            char c = s.charAt(right);
            
            if (lastIndex[c] >= left) 
            {
                left = lastIndex[c] + 1;
            }
            
            lastIndex[c] = right;
            maxLen = Math.max(maxLen, right - left + 1);
        }
        
        return maxLen;
    }
}