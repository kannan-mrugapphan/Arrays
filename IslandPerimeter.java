// 463.
// time - O(n * m)
// space - constant
class Solution {
    public int islandPerimeter(int[][] grid) {
        //edge
        if(grid == null || grid.length == 0 || grid[0].length == 0)
        {
            return 0; //no grid -> no island -> return 0 as perimeter
        }
        int perimeter = 0; //return value
        for(int i = 0; i < grid.length; i++)
        {
            for(int j = 0; j < grid[0].length; j++)
            {
                if(grid[i][j] == 1) //current 1 part of island
                {
                    int currentPerimeter = 4;
                    currentPerimeter -= getNeighbors(grid, i, j); //reduce perimeter of current by # of neighbors
                    perimeter += currentPerimeter;
                }
            }
        }
        return perimeter;
    }
    
    //time - constant
    //space - constant
    private int getNeighbors(int[][] grid, int row, int col) {
        int neighbors = 0;
        int[][] dirs = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        for(int[] dir : dirs)
        {
            int nRow = row + dir[0];
            int nCol = col + dir[1];
            if(nRow >= 0 && nRow < grid.length && nCol >= 0 && nCol < grid[0].length && grid[nRow][nCol] == 1)
            {
                //neighbor within bounds
                neighbors++;
            }      
        }
        return neighbors;
    }
}
