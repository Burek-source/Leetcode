You are given an array of strings words and a string chars.

A string is good if it can be formed by characters from chars (each character can only be used once).

Return the sum of lengths of all good strings in words.

 

Example 1:

Input: words = ["cat","bt","hat","tree"], chars = "atach"
Output: 6
Explanation: The strings that can be formed are "cat" and "hat" so the answer is 3 + 3 = 6.

  
Example 2:

Input: words = ["hello","world","leetcode"], chars = "welldonehoneyr"
Output: 10
Explanation: The strings that can be formed are "hello" and "world" so the answer is 5 + 5 = 10.
 

Constraints:

1 <= words.length <= 1000
1 <= words[i].length, chars.length <= 100
words[i] and chars consist of lowercase English letters.

class Solution 
{
    public int countCharacters(String[] words, String chars) 
    {   
        boolean canBeMade = true;
        int sum = 0;
        
        Map<Character, Integer> charsMap = new HashMap<>(); 
        Map<Character, Integer> wordsMap = new HashMap<>(); 

        // Map occurences of each letter in chars string
        for(int i = 0; i < chars.length(); i++)
        {
            charsMap.merge(chars.charAt(i), 1, Integer::sum);
        }

        // Map occurences of each letter in each word in the words array and check if they exist in the chars map
        for(int i = 0; i < words.length; i++)
        {
            String temp = words[i];
            canBeMade = true;
            wordsMap.clear();

            for(int j = 0; j < temp.length(); j++)
            {
                wordsMap.merge(temp.charAt(j), 1, Integer::sum);
            }

            for(char key : wordsMap.keySet())
            {
                // If the letter in words map doesn't exist in chars map, the word is not possible to be formed
                if(!charsMap.containsKey(key))
                {   
                    canBeMade = false;
                    break;
                }
                // If the letter in words map exists in the chars map but it occurs less times in the chars map than in the words map, the word is not possible to be formed
                else if(charsMap.get(key) < wordsMap.get(key))
                {
                    canBeMade = false;
                    break;
                }
            }

            if(canBeMade == true)
            {
                sum += temp.length();
            }
        }
        return sum;
    }
}
