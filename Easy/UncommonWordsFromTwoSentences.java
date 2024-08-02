A sentence is a string of single-space separated words where each word consists only of lowercase letters.

A word is uncommon if it appears exactly once in one of the sentences, and does not appear in the other sentence.

Given two sentences s1 and s2, return a list of all the uncommon words. You may return the answer in any order.

 

Example 1:

Input: s1 = "this apple is sweet", s2 = "this apple is sour"
Output: ["sweet","sour"]

  
Example 2:

Input: s1 = "apple apple", s2 = "banana"
Output: ["banana"]
 

Constraints:

1 <= s1.length, s2.length <= 200
s1 and s2 consist of lowercase English letters and spaces.
s1 and s2 do not have leading or trailing spaces.
All the words in s1 and s2 are separated by a single space.


class Solution 
{
    public String[] uncommonFromSentences(String s1, String s2) 
    {
        String[] arrS1 = s1.split(" ");
        String[] arrS2 = s2.split(" ");

        Map<String, Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();

        // Map occurences of each word from both strings
        for(String s : arrS1)
        {
            map.merge(s, 1, Integer::sum);
        }
        for(String s : arrS2)
        {
            map.merge(s, 1, Integer::sum);
        }

        // Find all words that only appear once
        for(String key : map.keySet())
        {
            if(map.get(key) == 1)
            {
                list.add(key);
            }
        }
      
        String[] result = new String[list.size()];

        for(int i = 0; i < list.size(); i++)
        {
            result[i] = list.get(i);
        }
        return result;
    }
}
