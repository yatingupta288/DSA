class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        boolean visited[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length ; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 1 && visited[i][j] == false){
                    ans = Math.max(ans, helper(grid, i, j, visited));
                }
            }
        }
        return ans;
    }
    
    public int helper(int[][] grid, int i, int j, boolean visited[][]){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || visited[i][j] == true){
            return 0;
        }
        visited[i][j] = true;
        return  1 + helper(grid, i + 1, j ,visited) + helper(grid, i, j + 1, visited) + helper(grid, i - 1, j, visited) + helper(grid, i, j - 1, visited);
    }
}