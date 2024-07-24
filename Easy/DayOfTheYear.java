Given a string date representing a Gregorian calendar date formatted as YYYY-MM-DD, return the day number of the year.

 

Example 1:

Input: date = "2019-01-09"
Output: 9
Explanation: Given date is the 9th day of the year in 2019.

  
Example 2:

Input: date = "2019-02-10"
Output: 41
 

Constraints:

date.length == 10
date[4] == date[7] == '-', and all other date[i]'s are digits
date represents a calendar date between Jan 1st, 1900 and Dec 31th, 2019.

class Solution 
{
    public int dayOfYear(String date) 
    {
        int days = Integer.parseInt(date.substring(8));
        int month = Integer.parseInt(date.substring(5, 7));
        int year = Integer.parseInt(date.substring(0,4));

        month = month - 1;
        int m = 0;

        // Get the number of days before the current month
        switch (month) 
        {
            case 1 : m = 31; break;
            case 2:  m = 59; break;
            case 3: m = 90; break;
            case 4: m = 120; break;
            case 5: m = 151; break;
            case 6: m = 181; break;
            case 7: m = 212; break;
            case 8: m = 243; break;
            case 9: m = 273; break;
            case 10: m = 304; break;
            case 11: m = 334; break;
            case 12: m = 365; break;
            default: m = 0; break;
        }

        // Add the days in the month checked to all previous days
        m = m + days;

        // Check if the year is the leap year and the month is March or onwards. If it is, add one extra day
        if(year % 400 == 0 || (year % 4 == 0 && year % 100 != 0 ))
        {
            if(month > 1)
            {
                m++;
            }  
        }
        return m;
    }
}
