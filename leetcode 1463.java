class Solution {
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        Integer[][][] memo = new Integer[rows][cols][cols];
        return helper(grid, 0, 0, cols-1, memo);
    }
    
    private int helper(int[][] grid, int row, int colA, int colB, Integer[][][] memo) {
        int cols = grid[0].length;
        
        
        if(colA < 0 || colA >= cols || colB < 0 || colB >= cols) return 0;
        
        
        if(memo[row][colA][colB] != null) return memo[row][colA][colB];
        
        
        int result = grid[row][colA];
        if(colA != colB) result += grid[row][colB];
        
        int maxNext = 0;
        if(row < grid.length - 1) {
            for(int newA = colA - 1; newA <= colA + 1; newA++) {
                for(int newB = colB - 1; newB <= colB + 1; newB++) {
                    maxNext = Math.max(maxNext, helper(grid, row + 1, newA, newB, memo));
                }
            }
        }
        
        result += maxNext;
        memo[row][colA][colB] = result;
        return result;
    }
}
