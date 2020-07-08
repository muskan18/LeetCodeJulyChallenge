/*
You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.

Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water, and there is exactly one island (i.e., one or more connected land 

cells).

The island doesn't have "lakes" (water inside that isn't connected to the water around the island). One cell is a square with side length 1. The grid is rectangular, width and 

height don't exceed 100. Determine the perimeter of the island.
*/
class Solution {
    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
         
        int m = grid.length;
        int n = grid[0].length;
         
        int perimeter = 0;
         
        boolean[][] visited = new boolean[m][n];
         
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == false && grid[i][j] == 1) {
                    perimeter = islandPerimeterHelper(i, j, grid, visited);
                    break;
                }
            }
        }
         
        return perimeter;
    }
     
    private int islandPerimeterHelper(int row, int col, int[][] grid, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
         
        if (row < 0 || row >= m || col < 0 || col >= n) {
            return 1;
        }
         
        if (grid[row][col] == 0) {
            return 1;
        }
         
        if (visited[row][col] == true) {
            return 0;
        }
         
        visited[row][col] = true;
         
        return islandPerimeterHelper(row - 1, col, grid, visited) + 
            islandPerimeterHelper(row + 1, col, grid, visited) + 
            islandPerimeterHelper(row, col - 1, grid, visited) + 
            islandPerimeterHelper(row, col + 1, grid, visited);
    }
}
