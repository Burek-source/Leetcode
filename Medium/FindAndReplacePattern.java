Given a list of strings words and a string pattern, return a list of words[i] that match pattern. You may return the answer in any order.

A word matches the pattern if there exists a permutation of letters p so that after replacing every letter x in the pattern with p(x), we get the desired word.

Recall that a permutation of letters is a bijection from letters to letters: every letter maps to another letter, and no two letters map to the same letter.

 

Example 1:

Input: words = ["abc","deq","mee","aqq","dkd","ccc"], pattern = "abb"
Output: ["mee","aqq"]
Explanation: "mee" matches the pattern because there is a permutation {a -> m, b -> e, ...}. 
"ccc" does not match the pattern because {a -> c, b -> c, ...} is not a permutation, since a and b map to the same letter.

  
Example 2:

Input: words = ["a","b","c"], pattern = "a"
Output: ["a","b","c"]
 

Constraints:

1 <= pattern.length <= 20
1 <= words.length <= 50
words[i].length == pattern.length
pattern and words[i] are lowercase English letters.


class Solution 
{
    public List<String> findAndReplacePattern(String[] words, String pattern) 
    {
        boolean validPattern = true;

        char[] patternLetters = pattern.toCharArray();
        ArrayList<String> wordsThatMatchPattern = new ArrayList<>();
        Map<Character, Character> map = new HashMap<>();

        // Find words that match the given pattern
        for(int i = 0; i < words.length; i++)
        {
           map.put(patternLetters[0], words[i].charAt(0)); // Make the first kv pair

            // Check if the key exists or not
            for(int j = 1; j < patternLetters.length; j++)
            {
                // If the key doesn't exist, check that the value it is supposed to store is unique
                if(!map.containsKey(patternLetters[j]))
                {
                    // If the value that is supposed to be stored in the new key already exists, the current word doesn't match the given pattern
                    if(map.containsValue(words[i].charAt(j)))
                    {
                        j = patternLetters.length;
                        validPattern = false ;      
                    }
                    // If the value doesn't exist anywhere in the map, create a new kv pair
                    else
                    {
                        map.put(patternLetters[j], words[i].charAt(j));
                    }
                    
                }
                // If the key already exists, check if the value stored in the key is the same as the value currently checked
                else if(map.containsKey(patternLetters[j]))
                {
                    // If two different values are to have the same key, the current word doesn't match the pattern
                    if(map.get(patternLetters[j]) != words[i].charAt(j))
                    {
                        j = patternLetters.length;
                        validPattern = false;
                    }
                   
                } 
            }

            if(validPattern == true)
            {
                wordsThatMatchPattern.add(words[i]);
            }
            validPattern = true;
            map.clear();
        }
        return wordsThatMatchPattern;
    }
}
