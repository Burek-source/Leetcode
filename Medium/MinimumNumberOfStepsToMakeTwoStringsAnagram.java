You are given two strings of the same length s and t. In one step you can choose any character of t and replace it with another character.

Return the minimum number of steps to make t an anagram of s.

An Anagram of a string is a string that contains the same characters with a different (or the same) ordering.

 

Example 1:

Input: s = "bab", t = "aba"
Output: 1
Explanation: Replace the first 'a' in t with b, t = "bba" which is anagram of s.

  
Example 2:

Input: s = "leetcode", t = "practice"
Output: 5
Explanation: Replace 'p', 'r', 'a', 'i' and 'c' from t with proper characters to make t anagram of s.

  
Example 3:

Input: s = "anagram", t = "mangaar"
Output: 0
Explanation: "anagram" and "mangaar" are anagrams. 
 

Constraints:

1 <= s.length <= 5 * 10^4
s.length == t.length
s and t consist of lowercase English letters only.


class Solution 
{
    public int minSteps(String s, String t) 
    {

        int numOfMoves = 0;

        Map<Character, Integer> sMap = new HashMap<>();
        Map<Character, Integer> tMap = new HashMap<>();

        // Get char occurence in s and t
        for(int i = 0; i < s.length(); i++)
        {
            sMap.merge(s.charAt(i), 1, Integer::sum);
            tMap.merge(t.charAt(i), 1, Integer::sum);
        }

        // Find how many chars in t it takes to make it s
        for(char key : sMap.keySet())
        {
            // If the char is present in both hashmaps and there are more of them in the s hashmap, add the difference between the two hashmaps
            if(tMap.containsKey(key) && sMap.get(key) > tMap.get(key))
            {
                numOfMoves += sMap.get(key) - tMap.get(key);
            }
            // If char is present in the s hashmap but not in the t hashmap, add the value of char in s hashmap
            else if(!tMap.containsKey(key))
            {
                numOfMoves += sMap.get(key);
            }
        }

        return numOfMoves;
    }
}
