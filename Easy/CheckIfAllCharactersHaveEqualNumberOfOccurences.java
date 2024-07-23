Given a string s, return true if s is a good string, or false otherwise.

A string s is good if all the characters that appear in s have the same number of occurrences (i.e., the same frequency).

 

Example 1:

Input: s = "abacbc"
Output: true
Explanation: The characters that appear in s are 'a', 'b', and 'c'. All characters occur 2 times in s.

  
Example 2:

Input: s = "aaabb"
Output: false
Explanation: The characters that appear in s are 'a' and 'b'.
'a' occurs 3 times while 'b' occurs 2 times, which is not the same number of times.
 

Constraints:

1 <= s.length <= 1000
s consists of lowercase English letters.

class Solution 
{
    public boolean areOccurrencesEqual(String s) 
    {
        Map<Character, Integer> map = new HashMap<>();

        // Map the occurence of each character in the string s
        for(int i = 0; i < s.length(); i++)
        {
            map.merge(s.charAt(i), 1, Integer::sum);
        }

        int min = Collections.min(map.values());
        int max = Collections.max(map.values());

        if(min == max)
        {
            return true;
        }
        return false;
    }
}
