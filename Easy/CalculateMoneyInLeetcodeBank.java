Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.

He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. On every subsequent Monday, he will put in $1 more than the previous Monday.
Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

 

Example 1:

Input: n = 4
Output: 10
Explanation: After the 4th day, the total is 1 + 2 + 3 + 4 = 10.

  
Example 2:

Input: n = 10
Output: 37
Explanation: After the 10th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4) = 37. Notice that on the 2nd Monday, Hercy only puts in $2.

  
Example 3:

Input: n = 20
Output: 96
Explanation: After the 20th day, the total is (1 + 2 + 3 + 4 + 5 + 6 + 7) + (2 + 3 + 4 + 5 + 6 + 7 + 8) + (3 + 4 + 5 + 6 + 7 + 8) = 96.
 

Constraints:

1 <= n <= 1000

class Solution 
{
    public int totalMoney(int n) 
    {

        int moneyOnMonday = 1; // Money on every next Monday increases by 1 from previous Monday
        int moneyToAdd = 1; // Each Monday, money to start the week is +1 from previous Monday
        int days = 0; 
        int totalAmountOfMoney = 0;

        // Find the total amount of money in the leetcode bank
        while(n > 0)
        {  
            if(days == 7)
            {
                moneyOnMonday += 1;
                moneyToAdd = moneyOnMonday;
                days = 0;
            }

            totalAmountOfMoney += moneyToAdd;

            moneyToAdd++;
            days++;
            n--;
        }

        return totalAmountOfMoney;
    }
}
