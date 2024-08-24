// Program to print if a rat is in maze 


package com.practice;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
	Test1 rat = new Test1();
	        int maze[][] = { { 1, 0, 0, 0 },
	                         { 1, 1, 0, 1 },
	                         { 0, 1, 0, 0 },
	                         { 1, 1, 1, 1 } };
	  
	     
	        System.out.print(solveMaze(maze));

	}

	static boolean solveMaze(int maze[][])
	
    {
      //  printSolution(maze);
		int sol[][] = new int[maze.length][maze[0].length];
  
        if (solveMazeUtil(maze, 0, 0, sol) == false) {
            System.out.print("Solution doesn't exist");
            return false;
        }
  
        printSolution(sol);
        return true;
    }

	static boolean solveMazeUtil(int maze[][], int x, int y,
			int sol[][])
{
// if (x, y is goal) return true
if (x == maze.length - 1 && y == maze.length - 1
&& maze[x][y] == 1) {
sol[x][y] = 1;
return true;
}

// Check if maze[x][y] is valid
if (isSafe(maze, x, y) == true) {
// Check if the current block is already part of solution path.	
if (sol[x][y] == 1)
	return false;

// mark x, y as part of solution path
sol[x][y] = 1;

/* Move forward in x direction */
if (solveMazeUtil(maze, x + 1, y, sol))
	return true;

/* If moving in x direction doesn't give
solution then Move down in y direction */
if (solveMazeUtil(maze, x, y + 1, sol))
	return true;

/* If none of the above movements works then
BACKTRACK: unmark x, y as part of solution
path */
sol[x][y] = 0;
return false;
}

return false;
}

	static boolean isSafe(
	        int maze[][], int x, int y)
	    {
	        // if (x, y outside maze) return false
		return (x >= 0 && x < maze.length && y >= 0
                && y < maze.length && maze[x][y] == 1);
	       
	    }
	 static void printSolution(int sol[][])
	    {
	        for (int i = 0; i < sol.length; i++) {
	            for (int j = 0; j < sol.length ; j++)
	                System.out.print(
	                    " " + sol[i][j] + " ");
	            System.out.println();
	        }
	    }

}
