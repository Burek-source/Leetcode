Given two strings ransomNote and magazine, return true if ransomNote can be constructed by using the letters from magazine and false otherwise.
Each letter in magazine can only be used once in ransomNote.

 

Example 1:

Input: ransomNote = "a", magazine = "b"
Output: false
  
Example 2:

Input: ransomNote = "aa", magazine = "ab"
Output: false
  
Example 3:

Input: ransomNote = "aa", magazine = "aab"
Output: true
 

Constraints:

1 <= ransomNote.length, magazine.length <= 10^5
ransomNote and magazine consist of lowercase English letters.

class Solution 
{
    public boolean canConstruct(String ransomNote, String magazine) 
    {
        boolean canCreateRansomNote = true;

        Map<Character, Integer> ransomNoteMap = new HashMap<>();
        Map<Character, Integer> magazineMap = new HashMap<>();

        // Char occurences in ransomNote
        for(int i = 0; i < ransomNote.length(); i++)
        {
            ransomNoteMap.merge(ransomNote.charAt(i), 1, Integer::sum); 
        }

        // Char occurences in magazine
        for(int i = 0; i < magazine.length(); i++)
        {
            magazineMap.merge(magazine.charAt(i), 1, Integer::sum); 
        }

        // Get individual keys and values from a  ransome note hashmap and check if keys occurs in magazine hashmap. If they do check that values in ransom note hashmap are equal or lower than in magazine hashmap
        for(char key : ransomNoteMap.keySet())
        {
           if(!magazineMap.containsKey(key))
           {
                canCreateRansomNote = false;
                break;
           }
           else if(magazineMap.containsKey(key))
           {
                if(ransomNoteMap.get(key) > magazineMap.get(key))
                {
                    canCreateRansomNote = false;
                    break;
                }
           }
        
        }

        return canCreateRansomNote;

    }
}
