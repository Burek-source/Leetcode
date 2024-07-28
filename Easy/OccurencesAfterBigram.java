Given two strings first and second, consider occurrences in some text of the form "first second third", where second comes immediately after first, and third comes immediately after second.

Return an array of all the words third for each occurrence of "first second third".

 

Example 1:

Input: text = "alice is a good girl she is a good student", first = "a", second = "good"
Output: ["girl","student"]

  
Example 2:

Input: text = "we will we will rock you", first = "we", second = "will"
Output: ["we","rock"]
 

Constraints:

1 <= text.length <= 1000
text consists of lowercase English letters and spaces.
All the words in text a separated by a single space.
1 <= first.length, second.length <= 10
first and second consist of lowercase English letters.

class Solution 
{
    public String[] findOcurrences(String text, String first, String second) 
    {
        ArrayList<String> list = new ArrayList<>();
        String[] words = text.split(" ");
        
        boolean firstFound = false;
        boolean secondFound = false;
        boolean roundPassed = false; // Triggers once the first word has been found

        // Find all words that follow after the first and second word have been found in a row
        for(int i = 0; i < words.length; i++)
        {
            // If two words in a row are the first and second word, add the third word to the list
            if(firstFound == true && secondFound == true)
            {
                list.add(words[i]);

                // Flag the first word false only if the first word is not the same as the second word
                if(!first.equals(second))
                {
                    firstFound = false;
                }
                secondFound = false;
            }

            // If the second word comes immedietaly afther the first, flag it as found
            if(words[i].equals(second) && firstFound == true)
            {
                secondFound = true;  
                roundPassed = false; // Indicate that the next word will be added to the list
            }

            // If the second word doesn't come after the first word, flag both words as not found
            if(firstFound == true && secondFound == false)
            {
                firstFound = false;
                secondFound = false;
            }

            // Flag the first word as found and trigger the event to check if the next word is the second word
            if(words[i].equals(first))
            {
                firstFound = true;
                roundPassed = true;
            }   
        }
      
        String[] arr = new String[list.size()];

        for(int i = 0; i < list.size(); i++)
        {
            arr[i] = list.get(i);
        }
        return arr;
    }
}
