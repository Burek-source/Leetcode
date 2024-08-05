Given two string arrays words1 and words2, return the number of strings that appear exactly once in each of the two arrays.

 

Example 1:

Input: words1 = ["leetcode","is","amazing","as","is"], words2 = ["amazing","leetcode","is"]
Output: 2
Explanation:
- "leetcode" appears exactly once in each of the two arrays. We count this string.
- "amazing" appears exactly once in each of the two arrays. We count this string.
- "is" appears in each of the two arrays, but there are 2 occurrences of it in words1. We do not count this string.
- "as" appears once in words1, but does not appear in words2. We do not count this string.
Thus, there are 2 strings that appear exactly once in each of the two arrays.

  
Example 2:

Input: words1 = ["b","bb","bbb"], words2 = ["a","aa","aaa"]
Output: 0
Explanation: There are no strings that appear in each of the two arrays.

  
Example 3:

Input: words1 = ["a","ab"], words2 = ["a","a","a","ab"]
Output: 1
Explanation: The only string that appears exactly once in each of the two arrays is "ab".
 

Constraints:

1 <= words1.length, words2.length <= 1000
1 <= words1[i].length, words2[j].length <= 30
words1[i] and words2[j] consists only of lowercase English letters.


class Solution 
{
    public int countWords(String[] words1, String[] words2) 
    {
        int number = 0;

        Map<String, Integer> words1Map = new HashMap<>();
        Map<String, Integer> words2Map = new HashMap<>();

        // Map word occurences in the words1 array
        for(int i = 0; i < words1.length; i++)
        {
            words1Map.merge(words1[i], 1, Integer::sum);
        }

        // Map word occurences in the words2 array
        for(int i = 0; i < words2.length; i++)
        {
            words2Map.merge(words2[i], 1, Integer::sum);
        }

        // Check which map has less keys
        if(words1Map.size() < words2Map.size())
        {
            // Check if both hash maps contain the same key and the key's value is 1
            for(String key : words1Map.keySet())
            {
                if(words1Map.get(key) == 1 && words2Map.containsKey(key) && words2Map.get(key) == 1)
                {
                    number++;
                }
            }
        }
        else
        {
            for(String key : words2Map.keySet())
            {
                // Check if both hash maps contain the same key and the key's value is 1
                if(words2Map.get(key) == 1 && words1Map.containsKey(key) && words1Map.get(key) == 1)
                {
                    number++;
                }
            }
        }
        return number;
    }
}
