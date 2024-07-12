Given a string s, return the number of segments in the string.
A segment is defined to be a contiguous sequence of non-space characters.

 

Example 1:

Input: s = "Hello, my name is John"
Output: 5
Explanation: The five segments are ["Hello,", "my", "name", "is", "John"]

Example 2:

Input: s = "Hello"
Output: 1
 

Constraints:

0 <= s.length <= 300
s consists of lowercase and uppercase English letters, digits, or one of the following characters "!@#$%^&*()_+-=',.:".
The only space character in s is ' '.

class Solution 
{
    public int countSegments(String s) 
    {       
        int count = 0;       
        s = s.trim(); // Get rid off of extra spaces from the start and the end of a string

        if(s.length() == 0)
        {
            return 0;
        }

        String temp = "start"; // Once all empty spaces are removed from the start and the end of a string, the string will always start with a character. "start" here is a placeholder.

        // Find how many segments are in a string
        for(int i = 1; i < s.length(); i++)
        {
            // Once an empty space is encountered and a segment exists, increment the counter by 1 and reset the current segment
            if(s.charAt(i) == ' ' && temp.length() != 0)
            {
                count++;
                temp = "";
            }
            else if(s.charAt(i) != ' ')
            {
                temp += s.charAt(i);
            }

           
        }

        if(temp.length() != 0)
        {
            count++;
        }

        return count;
    }
}
