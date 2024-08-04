You are given two 0-indexed strings s and target. You can take some letters from s and rearrange them to form new strings.

Return the maximum number of copies of target that can be formed by taking letters from s and rearranging them.

 

Example 1:

Input: s = "ilovecodingonleetcode", target = "code"
Output: 2
Explanation:
For the first copy of "code", take the letters at indices 4, 5, 6, and 7.
For the second copy of "code", take the letters at indices 17, 18, 19, and 20.
The strings that are formed are "ecod" and "code" which can both be rearranged into "code".
We can make at most two copies of "code", so we return 2.

  
Example 2:

Input: s = "abcba", target = "abc"
Output: 1
Explanation:
We can make one copy of "abc" by taking the letters at indices 0, 1, and 2.
We can make at most one copy of "abc", so we return 1.
Note that while there is an extra 'a' and 'b' at indices 3 and 4, we cannot reuse the letter 'c' at index 2, so we cannot make a second copy of "abc".

  
Example 3:

Input: s = "abbaccaddaeea", target = "aaaaa"
Output: 1
Explanation:
We can make one copy of "aaaaa" by taking the letters at indices 0, 3, 6, 9, and 12.
We can make at most one copy of "aaaaa", so we return 1.
 

Constraints:

1 <= s.length <= 100
1 <= target.length <= 10
s and target consist of lowercase English letters.


class Solution 
{
    public int rearrangeCharacters(String s, String target) 
    {
        int numOfTargetWords = 0;

        // Edge case: if s is shorter than target, the target word cannot be made
        if(s.length() < target.length())
        {     
            return numOfTargetWords;
        }

        Map<Character, Integer> targetMap = new HashMap<>();
        Map<Character, Integer> sMap = new HashMap<>();

        // Map occurences of each letter in the target word
        for(int i = 0; i < target.length(); i++)
        {
            targetMap.merge(target.charAt(i), 1, Integer::sum);
        }

        // Map occurences of the target letters in the s string
        for(int i = 0; i < s.length(); i++)
        {
            if(targetMap.containsKey(s.charAt(i)))
            {
                sMap.merge(s.charAt(i), 1, Integer::sum);
            }
        }

        // Case 1: if the s map doesn't contain all keys from the target map, no words can be formed
        if(sMap.size() < targetMap.size())
        {
            return numOfTargetWords;
        }

        // Equalize frequencies of letters in sMap to match with frequencies of letters in target map
        for(char key : sMap.keySet())
        {
            if(targetMap.get(key) > 1)
            {
                sMap.replace(key, sMap.get(key) / targetMap.get(key));
            }
        }
        numOfTargetWords = Collections.min(sMap.values()); // Min value of a key is the number of the target words that can be formed
        return numOfTargetWords;
    }
}
