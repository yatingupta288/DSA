class Solution {
    public int minPathSum(int[][] grid) {
        int dp[][] = new int[grid.length + 1][grid[0].length + 1];
        for(int col[] : dp){
            Arrays.fill(col, -1);
        }
        int i = 0,j = 0;
        int n =  helper(grid, i, j, dp);
        return n;
    }
    
    int helper(int[][] grid, int i, int j, int[][] dp){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length){
            return Integer.MAX_VALUE;
        }else if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j]; // last element is returned 
        }
        if(dp[i][j] != -1)return dp[i][j];
        int down = helper(grid, i + 1, j, dp);
        int right = helper(grid, i, j + 1, dp);
        dp[i][j] = grid[i][j] + Math.min(down, right); // here grid[i][j] added for the elements before last like 2 in first iteration. Math.min helps is choosing the best path at every step.
        
        // System.out.println(i + " " + j);
        return dp[i][j];
        // we are filling the matrix from down to up.
    }
}
























// int dp[][] = new int[grid.length][grid[0].length];
//         dp[0][0] = grid[0][0];
//         for(int i = 0; i < grid.length; i++){
//             for(int j = 0; j < grid[0].length; j++){
//                 if(i == 0 && j != 0){
//                     dp[i][j] = dp[i][j - 1] + grid[i][j];
//                 }else if(j == 0 && i != 0){
//                     dp[i][j] = dp[i - 1][j] + grid[i][j];
//                 }else if(i - 1 >= 0 && j - 1 >= 0){
//                     dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
//                 }
//             }
//         }
//         return dp[grid.length - 1][grid[0].length - 1];


















// public int minPathSum(int[][] grid) {
//         boolean visited[][] = new boolean[grid.length][grid[0].length];
//         return dfs(grid, 0, 0);
//     }
    
    
//     public int dfs(int[][] grid, int i, int j){ 
//         if(i < 0 || i >= grid.length || j < 0 || j >= grid[0].length){
//             return Integer.MAX_VALUE;
//         }else if(i == grid.length - 1 && j == grid[0].length - 1){
//             return grid[i][j];
//         }
//         int op1 = dfs(grid, i + 1, j);
//         int op2 = dfs(grid, i, j + 1);
//         System.out.print(op1 + " ");
//         return grid[i][j] + Math.min(op1, op2);   
//     }