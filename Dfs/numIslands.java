/*
	Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

	Example 1:

	11110
	11010
	11000
	00000
	Answer: 1

	Example 2:

	11000
	11000
	00100
	00011
*/

class Solution {
    public int numIslands(char[][] grid) {
        int totalNumberOfIsland = 0;
        for(int i=0;i< grid.length; i++) {
            for(int j=0;j< grid[0].length;j++) {
                if(grid[i][j] == '1') {
                    numberOfIslands(grid,i,j);
                    totalNumberOfIsland++;
                }
            }
        }
        return totalNumberOfIsland;
    }
    
    public void numberOfIslands(char[][] grid,int i,int j) {
        if(i>=0 && i < grid.length && j >=0 && j< grid[0].length && grid[i][j] == '1'){
             grid[i][j] = '0';
             numberOfIslands(grid,i+1,j);
             numberOfIslands(grid,i-1,j); 
             numberOfIslands(grid,i,j-1); 
             numberOfIslands(grid,i,j+1);
        }
        return;
    }
}