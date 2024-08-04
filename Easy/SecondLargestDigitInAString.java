Given an alphanumeric string s, return the second largest numerical digit that appears in s, or -1 if it does not exist.

An alphanumeric string is a string consisting of lowercase English letters and digits.

 

Example 1:

Input: s = "dfa12321afd"
Output: 2
Explanation: The digits that appear in s are [1, 2, 3]. The second largest digit is 2.

  
Example 2:

Input: s = "abc1111"
Output: -1
Explanation: The digits that appear in s are [1]. There is no second largest digit. 
 

Constraints:

1 <= s.length <= 500
s consists of only lowercase English letters and/or digits.

class Solution 
{
    public int secondHighest(String s) 
    {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        int count = 0; // Int used to get the second largest element from the tree map

        // Find all digits in the string s and put them in a treemap
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) - '0' < 10)
            {
                treeMap.put(s.charAt(i) - '0', 1);
            }
        }

        // Edge case: if the length of treemap is 1 or 0, return -1.
        if(treeMap.size() <= 1)
        {
            return -1;
        }

        // Find the second highest key in the treemap
        for(int key : treeMap.keySet())
        {
            count++;
            if(count == treeMap.size()-1)
            {
                count = key;
                break;
            }
        }
        return count; // Return the second highest key in the treemap
    }
}
