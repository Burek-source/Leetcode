Given two strings s and goal, return true if and only if s can become goal after some number of shifts on s.
A shift on s consists of moving the leftmost character of s to the rightmost position.

For example, if s = "abcde", then it will be "bcdea" after one shift.
 

Example 1:

Input: s = "abcde", goal = "cdeab"
Output: true

  
Example 2:

Input: s = "abcde", goal = "abced"
Output: false
 

Constraints:

1 <= s.length, goal.length <= 100
s and goal consist of lowercase English letters.

class Solution 
{
    public boolean rotateString(String s, String goal) 
    {
        int totalRotations = s.length();
        boolean found = false;

        // If s and goal are of different lengths, return false
        if(s.length() != goal.length())
        {
            return false;
        }
        // If both s and goal are the same, return true
        if(s.contains(goal))
        {
            return true;
        }

        // Keep rotating the string s for s.length moves. If all moves are exceeded, return false.
        while(totalRotations > 0)
        {
            String temp = s.substring(1) + s.substring(0, 1);
            s = temp;

            if(temp.contains(goal))
            {
                found = true;
                totalRotations = 0;
            }
            totalRotations--;
        }

        return found;
    }
}
