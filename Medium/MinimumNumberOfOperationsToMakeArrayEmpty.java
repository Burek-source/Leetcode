class Solution 
{
    public int minOperations(int[] nums) 
    {
        int minNumOfRounds = 0;
        int n = 0;
        int remainder = 0;

        Map<Integer, Integer> map = new HashMap<>();

        // Map integers and their occurence
        for (int c : nums) 
        {
            map.merge(c, 1, Integer::sum);  
        }

        int min = Collections.min(map.values()); // Get the min key value

        // If any key has a value of 1, the array cannot be made empty
        if(min < 2)
        {
            return -1;
        }

        // Find the minimum number of operations it takes to make the array empty
        for(int key : map.keySet())
        {
            n = map.get(key);
            remainder = n % 3;

            // If the occurence of a digit is divisible by 3, add it to the minimum number of rounds
            if(remainder == 0)
            {
                minNumOfRounds = minNumOfRounds + (n / 3);
            }

            // If the occurence of a digit is not divisible by 3, add the the result of division and add one more extra round
            else
            {
                minNumOfRounds = minNumOfRounds +(n / 3) +1;
            }
        }
        return minNumOfRounds;
    }
}
