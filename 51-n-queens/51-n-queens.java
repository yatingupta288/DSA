class Solution {
    public List<List<String>> solveNQueens(int n) {
        char seen[][] = new char[n][n];
       for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                seen[i][j] = '.';
        List<List<String>> list = new ArrayList<>();
        solve(0,n, seen, list);
        return list;
    }
    
    public void solve(int j, int n, char[][] seen, List<List<String>> list){
        if(j == n ){
            add(list, seen);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(canFill(i,j,seen,n)){
                seen[i][j] = 'Q';
                solve(j + 1, n, seen, list);
                seen[i][j] = '.';
            }
        }
    }
    
    public boolean canFill(int i, int j, char seen[][], int n){
        int duprow = i;
        int dupcol = j;
        
        while(duprow >= 0 && dupcol >= 0){
            if(seen[duprow][dupcol] == 'Q'){
                return false;
            }
            duprow--;
            dupcol--;
        }
        
        int row = i;
        int col = j;
        
        while(col >= 0){
            if(seen[row][col] == 'Q'){
                return false;
            }
            col--;
        }
        
        row = i;
        col = j;
        
        while(row < n && col >= 0){
            if(seen[row][col] == 'Q'){
                return false;
            }
            row++;
            col--;
        }
        
        return true;
    
    }
    
    public void add(List<List<String>> res, char[][] seen){
        List<String> list = new ArrayList<>();
        for(int i = 0; i < seen.length; i++){
            StringBuilder s = new StringBuilder(' ');
            for(int j = 0; j < seen.length; j++){
                s.append(seen[i][j]);
            }
            list.add(s.toString());
        }
        res.add(list);
        return;
    }
}