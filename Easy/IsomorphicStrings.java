Given two strings s and t, determine if they are isomorphic.

Two strings s and t are isomorphic if the characters in s can be replaced to get t.

All occurrences of a character must be replaced with another character while preserving the order of characters. No two characters may map to the same character, but a character may map to itself.

 

Example 1:

Input: s = "egg", t = "add"
Output: true

  
Example 2:

Input: s = "foo", t = "bar"
Output: false

  
Example 3:

Input: s = "paper", t = "title"
Output: true
 

Constraints:

1 <= s.length <= 5 * 10^4
t.length == s.length
s and t consist of any valid ascii character.

class Solution {
    public boolean isIsomorphic(String s, String t) 
    {
        Map<Character, Character> map = new HashMap<>();

        // Check if two strings are isomorphic
        for(int i = 0; i < s.length(); i++)
        {
            // If the key doesn't exist check if the value that is supposed to be stored in it is unique. If not unique, two strings are not isomorphic
            if(!map.containsKey(s.charAt(i)) && map.containsValue(t.charAt(i)))
            {
                return false;         
            }
            // If key exists, and the value that is supposed to be stored in it is not the same as the value that is already in it, two strings are not isomorphic
            else if(map.containsKey(s.charAt(i)) && map.get(s.charAt(i)) != t.charAt(i))
            {
                return false;    
            }
            else
            {
                map.put(s.charAt(i), t.charAt(i));
            }
        } 
        return true;
    }
}
