You are given a 0-indexed integer array nums of size 3 which can form the sides of a triangle.

A triangle is called equilateral if it has all sides of equal length.
A triangle is called isosceles if it has exactly two sides of equal length.
A triangle is called scalene if all its sides are of different lengths.
Return a string representing the type of triangle that can be formed or "none" if it cannot form a triangle.

 

Example 1:

Input: nums = [3,3,3]
Output: "equilateral"
Explanation: Since all the sides are of equal length, therefore, it will form an equilateral triangle.

  
Example 2:

Input: nums = [3,4,5]
Output: "scalene"
Explanation: 
nums[0] + nums[1] = 3 + 4 = 7, which is greater than nums[2] = 5.
nums[0] + nums[2] = 3 + 5 = 8, which is greater than nums[1] = 4.
nums[1] + nums[2] = 4 + 5 = 9, which is greater than nums[0] = 3. 
Since the sum of the two sides is greater than the third side for all three cases, therefore, it can form a triangle.
As all the sides are of different lengths, it will form a scalene triangle.
 

Constraints:

nums.length == 3
1 <= nums[i] <= 100

class Solution 
{
    public String triangleType(int[] nums) 
    {
        String typeOfATriangle = "none"; // Returns none if a triangle cannot be formed
        Arrays.sort(nums);

        // Case 1: equilateral triangle
        if(nums[0] == nums[1] && nums[1] == nums[2])
        {
            typeOfATriangle = "equilateral";
        }

        // Case 2: isosceles triangle
        else if(nums[0] == nums[1] && nums[0] + nums[1] > nums[2])
        {
            typeOfATriangle = "isosceles";
        }
        else if(nums[1] == nums[2])
        {
            typeOfATriangle = "isosceles";
        }

        // Case 3: scalene triangle
        else if(nums[0] + nums[1] > nums[2])
        {
            typeOfATriangle = "scalene";
        }
        return typeOfATriangle;
    }
}
