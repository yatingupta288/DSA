class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid == null || grid.length == 0) return -1;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 2){
                    dfs(grid, i, j, 2);
                }
            }
        }
        
        
        int time = 2;
        for(int row[]: grid){
            for(int col : row){
                if(col == 1)return -1;
                time = Math.max(time, col);
            }
        }
        return time - 2;
    }
    
    public void dfs(int [][]grid, int i, int j, int time){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0 || (grid[i][j] > 1 && grid[i][j] < time)){
            return;
        }
        
        grid[i][j] = time;
        dfs(grid, i - 1, j, time + 1);
        dfs(grid, i + 1, j, time + 1);
        dfs(grid, i, j - 1, time + 1);
        dfs(grid, i, j + 1, time + 1);
    }
}