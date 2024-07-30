You are given a string word that consists of digits and lowercase English letters.

You will replace every non-digit character with a space. For example, "a123bc34d8ef34" will become " 123  34 8  34". Notice that you are left with some integers that are separated by at least one space: "123", "34", "8", and "34".

Return the number of different integers after performing the replacement operations on word.

Two integers are considered different if their decimal representations without any leading zeros are different.

 

Example 1:

Input: word = "a123bc34d8ef34"
Output: 3
Explanation: The three different integers are "123", "34", and "8". Notice that "34" is only counted once.

  
Example 2:

Input: word = "leet1234code234"
Output: 2

  
Example 3:

Input: word = "a1b01c001"
Output: 1
Explanation: The three integers "1", "01", and "001" all represent the same integer because
the leading zeros are ignored when comparing their decimal values.
 

Constraints:

1 <= word.length <= 1000
word consists of digits and lowercase English letters.

class Solution 
{
    public int numDifferentIntegers(String word) 
    {   
        String temp = "";
        boolean zero = false; // Keeps track if the first digit in a number is zero
        
        Map<String, Integer> map = new HashMap<>();

        // Find the number of unique numbers in a string
        for(int i = 0; i < word.length(); i++)
        {
            // If a char is a digit
            if(word.charAt(i) - 48 < 10)
            {
                // If the first digit is not 0 create a number
                if(temp.length() == 0 && word.charAt(i) != '0')
                {
                    temp += word.charAt(i);
                }
                // If the first digit is 0, flag it. Used to add it to the map if it is the only digit in the number.
                else if(temp.length() == 0 && word.charAt(i) == '0')
                {
                    zero = true;
                }
                else if(temp.length() > 0)
                {
                    temp += word.charAt(i);
                }
            }

            // If non-digit char found, check if any number is found.
            else if(temp.length() > 0)
            {
               zero = false; // When length of a number is > 0, zero is not one of the numbers
                map.put(temp, 1);

                temp = "";
            }

            // If zero has been found, add it to the map
            else if(zero == true)
            {
                map.put("0", 1);
                zero = false;
            }

          
            // If the number is at the end of the string, add it to the map
            if(temp.length() > 0 && i == word.length()-1)
            {  
                map.put(temp, 1);         
            }
            // If zero is at the last position in the string and is the only number, add it to the map
            else if(zero == true && i == word.length()-1)
            {         
                map.put("0", 1);
            }     
        }
        return map.size(); // Returns the number of unique numbers present in the string
    }
}
