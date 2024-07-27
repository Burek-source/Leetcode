You are given a phone number as a string number. number consists of digits, spaces ' ', and/or dashes '-'.

You would like to reformat the phone number in a certain manner. Firstly, remove all spaces and dashes. Then, group the digits from left to right into blocks of length 3 until there are 4 or fewer digits. The final digits are then grouped as follows:

2 digits: A single block of length 2.
3 digits: A single block of length 3.
4 digits: Two blocks of length 2 each.
The blocks are then joined by dashes. Notice that the reformatting process should never produce any blocks of length 1 and produce at most two blocks of length 2.

Return the phone number after formatting.

 

Example 1:

Input: number = "1-23-45 6"
Output: "123-456"
Explanation: The digits are "123456".
Step 1: There are more than 4 digits, so group the next 3 digits. The 1st block is "123".
Step 2: There are 3 digits remaining, so put them in a single block of length 3. The 2nd block is "456".
Joining the blocks gives "123-456".

  
Example 2:

Input: number = "123 4-567"
Output: "123-45-67"
Explanation: The digits are "1234567".
Step 1: There are more than 4 digits, so group the next 3 digits. The 1st block is "123".
Step 2: There are 4 digits left, so split them into two blocks of length 2. The blocks are "45" and "67".
Joining the blocks gives "123-45-67".

  
Example 3:

Input: number = "123 4-5678"
Output: "123-456-78"
Explanation: The digits are "12345678".
Step 1: The 1st block is "123".
Step 2: The 2nd block is "456".
Step 3: There are 2 digits left, so put them in a single block of length 2. The 3rd block is "78".
Joining the blocks gives "123-456-78".
 

Constraints:

2 <= number.length <= 100
number consists of digits and the characters '-' and ' '.
There are at least two digits in number.

class Solution 
{
    public String reformatNumber(String number) 
    {
        String onlyNumbers = "";
        String phoneNumber = "";
        String lengthThree = "";

        int three = 0;
        int index = 0;

        // Remove non-numeric characters from the number string
        for(int i = 0; i < number.length(); i++)
        {
            if(number.charAt(i) -48> -1 && number.charAt(i) - 48 < 10)
            {
                onlyNumbers += number.charAt(i);        
            }
        }

        // Case 1: the number consists of 2 or 3 digits
        if(onlyNumbers.length() == 2 || onlyNumbers.length() == 3)
        {
            return onlyNumbers;
        }

        // Case 2: the number consists of 4 digits
        else if(onlyNumbers.length() == 4)
        {
            phoneNumber = onlyNumbers.substring(0, 2) + "-" + onlyNumbers.substring(2);
            return phoneNumber;
        }
  
        index = onlyNumbers.length()-4; // Index for the last 4 digits

        // Case 3: the number is of length > 4
        for(int i = 0; i < onlyNumbers.length()-4; i++)
        {
            lengthThree += onlyNumbers.charAt(i);
            three++;

            if(three == 3)
            {
                phoneNumber+= lengthThree + "-";
                lengthThree = "";
                three = 0;
            }  
        }

        // Add two digits to the temp string to make it of length 3 and add last two digits after the dash
        if(lengthThree.length() == 1)
        {
            lengthThree += onlyNumbers.substring(index, index+2);
            phoneNumber += lengthThree + "-" + onlyNumbers.substring(index+2);
            
        }
        // Add one extra digit to the temp stirng to make it of length 3 and add last 3 digits after the dash
        else if(lengthThree.length() == 2)
        {
            lengthThree += onlyNumbers.substring(index, index + 1);
            phoneNumber += lengthThree + "-" + onlyNumbers.substring(index+1);
        }
        // Add last 4 digits in groups of two the the phone number
        else
        {
            phoneNumber += onlyNumbers.substring(index, index+2) + "-" + onlyNumbers.substring(index + 2);
        }
        return phoneNumber;      
    }
}
