The power of the string is the maximum length of a non-empty substring that contains only one unique character.

  Given a string s, return the power of s.

 

Example 1:

Input: s = "leetcode"
Output: 2
Explanation: The substring "ee" is of length 2 with the character 'e' only.

  
Example 2:

Input: s = "abbcccddddeeeeedcba"
Output: 5
Explanation: The substring "eeeee" is of length 5 with the character 'e' only.
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters.

class Solution 
{
    public int maxPower(String s) 
    {
        char charBefore = s.charAt(0);

        int count = 1;
        int highestCount = 1;

        // Find the highest consecutive occurence of the same char in a given string
        for(int i = 1; i < s.length(); i++)
        {
            // If the current and preceeding chars are same, increase the counter
            if(s.charAt(i) == charBefore)
            {
                count++;
            }

            // If the current and preeceding chars are different, check if the count is higher than the current highest count. Reset counter afterwards.
            else
            {
                charBefore = s.charAt(i);

                if(count > highestCount)
                {
                    highestCount = count;
                }

                count = 1;
            }

            // If the end of the string is reached, check if the count is higher than the current highest count
            if(i == s.length() -1 && count > highestCount)
            {
                highestCount = count;
            }
        }

        return highestCount;
    }
}
