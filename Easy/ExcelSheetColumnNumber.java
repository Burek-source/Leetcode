Given a string columnTitle that represents the column title as appears in an Excel sheet, return its corresponding column number.

For example:

A -> 1
B -> 2
C -> 3
...
Z -> 26
AA -> 27
AB -> 28 
...
 

Example 1:

Input: columnTitle = "A"
Output: 1
Example 2:

Input: columnTitle = "AB"
Output: 28
Example 3:

Input: columnTitle = "ZY"
Output: 701
 

Constraints:

1 <= columnTitle.length <= 7
columnTitle consists only of uppercase English letters.
columnTitle is in the range ["A", "FXSHRXW"].

class Solution 
{
    public int titleToNumber(String columnTitle) 
    {
       String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"; 

       int columnNumber = 0;
       int power = columnTitle.length()-1;
       
       // Find the column number for a given string
       for(int i = 0; i < columnTitle.length(); i++)
       {
            char c = columnTitle.charAt(i); // Get each char from the column
            int n = alphabet.indexOf(c) + 1; // Get char's corresponding index value + 1
            columnNumber += n * (Math.pow(26, power));
            power--;
       }

       return columnNumber;
    }
}
