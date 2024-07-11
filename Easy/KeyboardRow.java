Given an array of strings words, return the words that can be typed using letters of the alphabet on only one row of American keyboard like the image below.

In the American keyboard:

the first row consists of the characters "qwertyuiop",
the second row consists of the characters "asdfghjkl", and
the third row consists of the characters "zxcvbnm".

 

Example 1:

Input: words = ["Hello","Alaska","Dad","Peace"]
Output: ["Alaska","Dad"]

  
Example 2:

Input: words = ["omk"]
Output: []

  
Example 3:

Input: words = ["adsdf","sfd"]
Output: ["adsdf","sfd"]
 

Constraints:

1 <= words.length <= 20
1 <= words[i].length <= 100
words[i] consists of English letters (both lowercase and uppercase). 

class Solution 
{
    public String[] findWords(String[] words) 
    {
        String firstRow = "qwertyuiop";
        String secondRow = "asdfghjkl";
        String thirdRow = "zxcvbnm";

        int countFirstRow = 0;
        int countSecondRow = 0;
        int countThirdRow = 0;

        ArrayList<String> list = new ArrayList<>();

        // Check which words can be typed using just one out of three rows
        for(int i = 0; i < words.length; i++)
        {
            String temp = words[i].toLowerCase();

            for(int j = 0; j < words[i].length(); j++)
            {
                if(firstRow.indexOf(temp.charAt(j)) != -1)
                {
                    countFirstRow++;
                }

                if(secondRow.indexOf(temp.charAt(j)) != -1)
                {
                    countSecondRow++;
                }

                if(thirdRow.indexOf(temp.charAt(j)) != -1)
                {
                    countThirdRow++;
                }
            }
            // Add a word to the list that can be typed using just one row
            if(countFirstRow == temp.length() || countSecondRow == temp.length() || countThirdRow == temp.length())
            {
                list.add(words[i]);
            }

            countFirstRow = 0;
            countSecondRow = 0;
            countThirdRow = 0;
        }

        String[] wordsThatCanBeTyped = new String[list.size()];
    
        for(int i = 0; i < list.size(); i++)
        {
            wordsThatCanBeTyped[i] = list.get(i);
        }

        return wordsThatCanBeTyped;
 
    }
}
