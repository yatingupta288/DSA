class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        char[][] board = new char[n][n];
        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){
                board[i][j] = '.';
            }
        }
        int[] col = new int[n];
        int[] up = new int[2 * n - 1];
        int[] down = new int[2 * n - 1];
        solve(0, n, col, up, down, board);
        return count;
    }
    
    public void solve(int j , int n, int[] col , int[] up, int[] down, char[][] board){
        if(j == n){
            count++;
        }
        
        for(int i = 0; i < n; i++){
            if(col[i] == 0 && up[i + j] == 0 && down[n - 1 + j - i] == 0){
                col[i] = 1;
                up[i + j] = 1;
                down[n - 1 + j - i] = 1;
                solve(j + 1, n, col, up, down, board);
                col[i] = 0;
                up[i + j] = 0;
                down[n - 1 + j - i] = 0;
            }
        }
    }
}