You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots. Given an integer array flowerbed containing 0's and 1's,
where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.

 

Example 1:

Input: flowerbed = [1,0,0,0,1], n = 1
Output: true

  
Example 2:

Input: flowerbed = [1,0,0,0,1], n = 2
Output: false
 

Constraints:

1 <= flowerbed.length <= 2 * 10^4
flowerbed[i] is 0 or 1.
There are no two adjacent flowers in flowerbed.
0 <= n <= flowerbed.length

class Solution {
    public boolean canPlaceFlowers(int[] flowerbed, int n) 
    {
       
        int count = 0;
        int total = 0;
        
        // Edge case
        if(flowerbed.length == 1 && n < 2 && flowerbed[0] == 0) // if n is 0 or 1 and the only element is 0
        {
            return true;
        }
        else if(flowerbed.length == 1 && flowerbed[0] == 1 && n != 0) // if n is not 0
        {
            return false;
        }

        for(int i = 0; i < flowerbed.length; i++)
        {
            // Edge case; If the first element is 0, only check the next number
            if(flowerbed[i] == 0 && i == 0)
            {
                if(flowerbed[i+1] != 1)
                {
                    count++;
                }  
            }
            // Edge case; If the last element is 0, only check the previous number
            else if(flowerbed[i] == 0 && i == flowerbed.length-1)
            {
                if(flowerbed[i-1] != 1)
                {
                    count++;
                }
            }
            // Otherwise, check the number before and after 0
            // If both of them are 0, increment count by 1
            else if(flowerbed[i] == 0 && flowerbed[i-1] != 1 && flowerbed[i+1] != 1)
            {
                count++;
            }



            // Determining number of possible flowers if the last element is 0
            if(count > 0 && i == flowerbed.length-1)
            {
                if(count == 1)
                {
                    total = total + count;
                    
                }
                else if(count % 2 == 0)
                {
                    total = total + (count /2);
                    
                }
                else if(count % 2 != 0)
                {
                    total = total + 1 + (count/2);
                    
                }
            }

            // Determining number of possible flowers if the current element is 1
            else if(flowerbed[i] == 1 && count != 0)
            {
                if(count == 1)
                {
                    total = total + count;
                }
                else if(count % 2 == 0)
                {
                    total = total + (count /2);
                }
                else if(count % 2 != 0)
                {
                    total = total + 1 + (count/2);
                }
                count = 0;
            }
 
        }

        // If n is lower or equal then the total number of possible plants, return true
        if(n <= total)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
}
