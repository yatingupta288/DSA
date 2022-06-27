class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
        return;
    }
    
    public boolean solve(char board[][]){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board.length; j++){
                if(board[i][j] == '.'){
                    for(char ch = '1'; ch <= '9' ; ch++){
                        if(isValid(ch, i, j, board)){
                            board[i][j] = ch;
                            if(solve(board)){
                                return true;
                            }else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    
    public boolean isValid(char ch, int i, int j, char[][] board){
        for(int a = 0; a < board.length; a++){
            for(int b = 0; b < board.length; b++){
                if(board[i][b] == ch){
                    return false;
                }else if(board[a][j] == ch){
                    return false;
                }else if(board[3 * (i/3) + a/3][3 * (j/3) + b % 3] == ch){
                    return false;
                }
            }
        }
        
        return true;
    }
}