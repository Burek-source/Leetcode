Given a string s, partition the string into one or more substrings such that the characters in each substring are unique. That is, no letter appears in a single substring more than once.
Return the minimum number of substrings in such a partition.

Note that each character should belong to exactly one substring in a partition.

 

Example 1:

Input: s = "abacaba"
Output: 4
Explanation:
Two possible partitions are ("a","ba","cab","a") and ("ab","a","ca","ba").
It can be shown that 4 is the minimum number of substrings needed.

  
Example 2:

Input: s = "ssssss"
Output: 6
Explanation:
The only valid partition is ("s","s","s","s","s","s").
 

Constraints:

1 <= s.length <= 10^5
s consists of only English lowercase letters.

class Solution 
{
    public int partitionString(String s) 
    {
        int count = 1; // There is always going to be atleast a one non-repeating substring

        Map<Character, Integer> charCount = new HashMap<>(); // Keeps track of char occurence

        // Find the longest substring with non-repeating charaters
        for (char c : s.toCharArray()) 
        {
            // If a char repeats, start a new substring and increment count by 1
            if(charCount.containsKey(c))
            {
                count++;
                charCount.clear();
                charCount.merge(c, 1, Integer::sum);

            }
            // If a char is non-repeating, keep going
            else
            {
                charCount.merge(c, 1, Integer::sum); // Get the count of each letter in the string
            }
            
        }

        
        return count;

    }
}
