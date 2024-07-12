Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.

 

Example 1:

Input: s = "leetcode"
Output: 0
  
Example 2:

Input: s = "loveleetcode"
Output: 2
  
Example 3:

Input: s = "aabb"
Output: -1
 

Constraints:

1 <= s.length <= 10^5
s consists of only lowercase English letters.

class Solution 
{
    public int firstUniqChar(String s) 
    {
        int firstIndex = 0;
        int lastIndex = 0;

        // Find a char, if any, that only occurs once in a string
        for(int i = 0; i < s.length(); i++)
        {    
            char c = s.charAt(i);
            firstIndex = s.indexOf(c);
            lastIndex = s.lastIndexOf(c);

            // If the first and last index of a char is the same, the first non-repeating char is found
            if(firstIndex == lastIndex)
            {
                break;
            }
            // If char repeats in a string, set it to -1
            else
            {
                firstIndex = -1;
            }    
        }

        return firstIndex;
    }
}
