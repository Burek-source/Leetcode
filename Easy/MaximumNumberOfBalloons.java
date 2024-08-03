Given a string text, you want to use the characters of text to form as many instances of the word "balloon" as possible.

You can use each character in text at most once. Return the maximum number of instances that can be formed.

 

Example 1:

Input: text = "nlaebolko"
Output: 1

  
Example 2:

Input: text = "loonbalxballpoon"
Output: 2

  
Example 3:

Input: text = "leetcode"
Output: 0
 

Constraints:

1 <= text.length <= 10^4
text consists of lower case English letters only.


class Solution 
{
    public int maxNumberOfBalloons(String text) 
    {
        Map<Character, Integer> map = new HashMap<>();

        // Map occurences of 'b', 'a', 'l', 'o', 'n'
        for(int i = 0; i < text.length(); i++)
        {
            if(text.charAt(i) == 'b' || text.charAt(i) == 'a' || text.charAt(i) == 'l' || text.charAt(i) == 'o' || text.charAt(i) == 'n') 
            {
                map.merge(text.charAt(i), 1, Integer::sum);
            }
        }

        // Case 1: if the size of map is lower than 5 (the number of distinct letters in balloon)
        if(map.size() < 5)
        {
            return 0;
        }

        // Case 2: if either 'l' or 'o' appears once, no balloons possible
        if(map.get('l') < 2 || map.get('o') < 2)
        {
            return 0;
        }

        // Adjust frequencies of 'l's and 'o's to 1 frequency per 2 letters
        // Letter 'l'
        if(map.get('l') % 2 == 0)
        {
            map.put('l', map.get('l') / 2);
        }
        else if(map.get('l') % 2 != 0)
        {
            map.put('l', (map.get('l')-1) / 2);
        }

        // Letter 'o'
        if(map.get('o') % 2 == 0)
        {
            map.put('o', map.get('o') / 2);
        }
        else if(map.get('o') % 2 != 0)
        {
            map.put('o', (map.get('o')-1) / 2);
        }
      
        int max = Collections.max(map.values());
        int min = Collections.min(map.values());

        // Solution 1: if the min and max value in the map are the same - return either.
        if(min == max)
        {
            return max;
        }
        return min; // Solution 2: otherwise return the min value
 
    }
}
