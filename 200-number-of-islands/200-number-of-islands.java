class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        boolean seen[][] = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && seen[i][j] == false){
                    count += dfs(seen, i, j, grid);
                }
            }
        }
        return count;
    }
    
    public int dfs(boolean[][] seen, int i, int j, char[][] grid){
        if(i > grid.length - 1 || j > grid[0].length - 1|| i < 0 || j < 0 || grid[i][j] == '0'|| seen[i][j]){
            return 0;
        }
        seen[i][j] = true;
        dfs(seen, i + 1, j, grid);
        dfs(seen, i - 1, j, grid);
        dfs(seen, i, j + 1, grid);
        dfs(seen, i, j - 1, grid);
        
        return 1;
    }
}