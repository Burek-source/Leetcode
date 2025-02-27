Given a string s, return the length of the longest substring between two equal characters, excluding the two characters. If there is no such substring return -1.

A substring is a contiguous sequence of characters within a string.

 

Example 1:

Input: s = "aa"
Output: 0
Explanation: The optimal substring here is an empty substring between the two 'a's.

  
Example 2:

Input: s = "abca"
Output: 2
Explanation: The optimal substring here is "bc".

  
Example 3:

Input: s = "cbzxy"
Output: -1
Explanation: There are no characters that appear twice in s.
 

Constraints:

1 <= s.length <= 300
s contains only lowercase English letters.

class Solution 
{
    public int maxLengthBetweenEqualCharacters(String s) 
    {
        
        int length = -1;
        int count = 0;

        // Find the length of the longest substring between two same letters
        for(int i = 0; i < s.length()-1; i++)
        {
            count = 0;

            for(int j = i+1; j < s.length(); j++)
            {
                if(s.charAt(j) != s.charAt(i))
                {
                    count++;
                }
                // Only triggers if two same letters have been found
                else if(s.charAt(j) == s.charAt(i))
                {
                    if(count > length)
                    {
                        length = count;         
                    }
                    count++;
                }
            }
        }
        return length;
    }
}
