Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

Example 1:

Input: words = ["bella","label","roller"]
Output: ["e","l","l"]

  
Example 2:

Input: words = ["cool","lock","cook"]
Output: ["c","o"]
 

Constraints:

1 <= words.length <= 100
1 <= words[i].length <= 100
words[i] consists of lowercase English letters.

import java.util.ArrayList;
import java.util.Collections;

class Solution 
{
    public List<String> commonChars(String[] words) 
    {
       
        int count = 0;
        int count2 = 0;
        
       List<Integer> numbers = new ArrayList<>();
       List<Character> chars = new ArrayList<>();

       ArrayList<Integer> numbers2 = new ArrayList<>();
       ArrayList<Character> chars2 = new ArrayList<>();

       // First word of the array
        for(int i = 0; i < words[0].length(); i++)
        {
            char c = words[0].charAt(i);
            count = 0;
            //System.out.println(c);

            for(int j = 0; j <words[0].length(); j++)
            if(c == words[0].charAt(j))
            {
                count++;
            }

            if(!chars.contains(c))
            {
                chars.add(c);
                numbers.add(count);
            }
           // System.out.println(numbers);
            //System.out.println(chars);
            //System.out.println();

        }

        // Rest of the array
        for(int i = 0; i < chars.size(); i++)
        {
            char k = chars.get(i);
            numbers2.add(numbers.get(i));

            for(int j = 1; j < words.length; j++)
            {
                for(int z = 0; z < words[j].length(); z++)
                {
                    if(words[j].charAt(z) == k)
                    {
                        count2++;
                    }
                }

                numbers2.add(count2);
                count2 = 0;
            }

            int min = Collections.min(numbers2);

            if(min > 0)
            {
                for(int p = 0; p < min; p++)
                {
                    chars2.add(chars.get(i));
                }
            }
            //System.out.println(min);
            //System.out.println(chars2);
            numbers2.clear();

        }

        // Convert ArrayList of Characters to ArrayList of Strings
        ArrayList<String> stringList = new ArrayList<>();
        for (Character ch : chars2) {
            stringList.add(ch.toString());
        }
        List<String> list = stringList;
        return list;
    }
}
