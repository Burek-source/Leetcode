There is an n x n grid, with the top-left cell at (0, 0) and the bottom-right cell at (n - 1, n - 1). You are given the integer n and an integer array startPos where 
startPos = [startrow, startcol] indicates that a robot is initially at cell (startrow, startcol).

You are also given a 0-indexed string s of length m where s[i] is the ith instruction for the robot: 'L' (move left), 'R' (move right), 'U' (move up), and 'D' (move down).

The robot can begin executing from any ith instruction in s. It executes the instructions one by one towards the end of s but it stops if either of these conditions is met:

The next instruction will move the robot off the grid.
There are no more instructions left to execute.
Return an array answer of length m where answer[i] is the number of instructions the robot can execute if the robot begins executing from the ith instruction in s.

 

Example 1:


Input: n = 3, startPos = [0,1], s = "RRDDLU"
Output: [1,5,4,3,1,0]
Explanation: Starting from startPos and beginning execution from the ith instruction:
- 0th: "RRDDLU". Only one instruction "R" can be executed before it moves off the grid.
- 1st:  "RDDLU". All five instructions can be executed while it stays in the grid and ends at (1, 1).
- 2nd:   "DDLU". All four instructions can be executed while it stays in the grid and ends at (1, 0).
- 3rd:    "DLU". All three instructions can be executed while it stays in the grid and ends at (0, 0).
- 4th:     "LU". Only one instruction "L" can be executed before it moves off the grid.
- 5th:      "U". If moving up, it would move off the grid.


Example 2:


Input: n = 2, startPos = [1,1], s = "LURD"
Output: [4,1,0,0]
Explanation:
- 0th: "LURD".
- 1st:  "URD".
- 2nd:   "RD".
- 3rd:    "D".


Example 3:


Input: n = 1, startPos = [0,0], s = "LRUD"
Output: [0,0,0,0]
Explanation: No matter which instruction the robot begins execution from, it would move off the grid.
 

Constraints:

m == s.length
1 <= n, m <= 500
startPos.length == 2
0 <= startrow, startcol < n
s consists of 'L', 'R', 'U', and 'D'.

class Solution 
{
    public int[] executeInstructions(int n, int[] startPos, String s) 
    {
        int[] answer = new int[s.length()];

        int row = startPos[0] + 1;
        int column = startPos[1] + 1;

        // Find them max possible moves for each letter before it goes off the grid
        for(int i = 0; i < s.length(); i++)
        {     
            int numOfMoves = 0;

            for(int j = i; j < s.length(); j++)
            {
                numOfMoves++;
                char c = s.charAt(j);

                // 'R' moves the robot to the right, hence increasing the column by 1
                if(c == 'R')
                {
                    column++;

                    // If the robot goes off the column, add total number of moves it has done until it moved off the grid
                    if(column > n)
                    {
                       
                        answer[i] = numOfMoves - 1;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;
                       
                        j = s.length();
                        
                    }

                    // If the robot does not go off the grid, the total number of moves is s.length - i
                    else if(j == s.length()-1)
                    {
                        answer[i] = numOfMoves;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;             
                    }
                }

                // 'L' moves the robot to the left, hence decreasing the column by 1
                else if(c == 'L')
                {
                    column--;

                     // If the robot goes off the column, add total number of moves it has done until it moved off the grid
                    if(column < 1)
                    {
                        answer[i] = numOfMoves - 1;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;

                        j = s.length();      
                    }

                    // If the robot does not go off the grid, the total number of moves is s.length - i
                    else if(j == s.length()-1)
                    {
                        answer[i] = numOfMoves;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;     
                    }
                }

                // 'D' moves the robot down, hence increasing the row by 1
                else if(c == 'D')
                {
                    row++;

                    // If the robot goes off the row, add total number of moves it has done until it moved off the grid
                    if(row > n)
                    {
                        answer[i] = numOfMoves - 1;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;

                        j = s.length();      
                    }

                    // If the robot does not go off the grid, the total number of moves is s.length - i
                    else if(j == s.length()-1)
                    {
                        answer[i] = numOfMoves;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;          
                    }
                }

                // 'U' moves the robot up, hence decreasing the row by 1
                else if(c == 'U')
                { 
                    row--;

                    // If the robot goes off the row, add total number of moves it has done until it moved off the grid
                    if(row < 1)
                    {
                        answer[i] = numOfMoves - 1;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;

                        j = s.length();  
                    }

                    // If the robot does not go off the grid, the total number of moves is s.length - i
                    else if(j == s.length()-1)
                    {
                        answer[i] = numOfMoves;
                        row = startPos[0] + 1;
                        column = startPos[1] + 1;           
                    }
                }
            }
        }     
        return answer;       
    }
}
