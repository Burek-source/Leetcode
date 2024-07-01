Write a function to find the longest common prefix string amongst an array of strings. If there is no common prefix, return an empty string "".

  
Example 1:

Input: strs = ["flower","flow","flight"]
Output: "fl"
  
Example 2:

Input: strs = ["dog","racecar","car"]
Output: ""
Explanation: There is no common prefix among the input strings.
 

Constraints:

1 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] consists of only lowercase English letters.


class Solution 
{
    public String longestCommonPrefix(String[] strs) 
    {
        
        String longestCommonPrefix = new String("");
        String baseCase = strs[0];
        int count = 0;

        char[] chars = new char[baseCase.length()];

        // Make an array of chars from the first string in the strs array
        for(int i = 0; i < baseCase.length(); i++)
        {
            chars[i] = baseCase.charAt(i);
        }

        // Check if each char appears in each word in the index order
        for(int i = 0; i < baseCase.length(); i++)
        {
            char c = baseCase.charAt(i);

            for(int j = 1; j < strs.length; j++)
            {
                // if the word checked is lower than the index to be checked, no longer prefix possible. Exit the loops
                if(strs[j].length() <= i)
                {
                    i = baseCase.length();
                    break;
                }

                // Else if the char c and char being checked are the same, possible prefix match exists
                else if(strs[j].charAt(i) == c)
                {
                    count++;   
                }

                // Else, there is a mismatch between the chars compared. Exit the loops
                else
                {
                    i = baseCase.length();
                    break;
                }
            }

            // If current char checked appears in all words, add it to the longestPrefix string
            if(count == strs.length-1)
            {
                longestCommonPrefix += c;
            }
            
            count = 0;  // reset count after each iteration
        }
        return longestCommonPrefix;
    }
}
