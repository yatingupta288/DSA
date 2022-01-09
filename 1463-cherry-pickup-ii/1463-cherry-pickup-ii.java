class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][] dp = new int[grid.length][grid[0].length][grid[0].length];
        return path(grid, 0, 0, grid[0].length - 1, dp);
    }
    
    public int path(int[][] grid, int i, int j, int k, int[][][] dp){
        if(i == grid.length){
            return 0;
        }
        if(dp[i][j][k] != 0){
            return dp[i][j][k];
        }
        int ans = 0;
        for(int a = -1; a <= 1; a++){
            for(int b= -1; b <= 1; b++){
                int c1 = j + a;
                int c2 = k + b;
                if(c1 >= 0 && c2 >= 0 && c1 < grid[0].length && c2 < grid[0].length){
                    ans = Math.max(ans, path(grid, i + 1, c1, c2, dp));
                }
            }
        }
        
        int cherries = j == k ? grid[i][j] : grid[i][j] + grid[i][k];
        return dp[i][j][k] = ans + cherries;
    }
    
}