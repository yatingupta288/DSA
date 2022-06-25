class Solution {
    public List<List<String>> solveNQueens(int n) {
        char seen[][] = new char[n][n];
       for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                seen[i][j] = '.';
        List<List<String>> list = new ArrayList<>();
        int col[] = new int[n];
        int updg[] = new int[2 * n - 1];
        int downdg[] = new int[2 * n - 1];
        solve(0,n, seen, list, col, updg, downdg);
        return list;
    }
    
    public void solve(int j, int n, char[][] seen, List<List<String>> list, int[] col, int[] updg, int[] downdg){
        if(j == n ){
            add(list, seen);
            return;
        }
        
        for(int i = 0; i < n; i++){
            if(col[i] == 0 && updg[i + j] == 0 && downdg[n - 1 + i - j] == 0){
                col[i] = 1;
                updg[i + j] = 1;
                downdg[n - 1 + i - j] = 1;
                seen[i][j] = 'Q';
                solve(j + 1, n, seen, list, col, updg, downdg);
                seen[i][j] = '.';
                col[i] = 0;
                updg[i + j] = 0;
                downdg[n - 1 + i - j] = 0;
            }
        }
    }
    
//     public boolean canFill(int i, int j, char seen[][], int n){
//         int duprow = i;
//         int dupcol = j;
        
//         while(duprow >= 0 && dupcol >= 0){
//             if(seen[duprow][dupcol] == 'Q'){
//                 return false;
//             }
//             duprow--;
//             dupcol--;
//         }
        
//         int row = i;
//         int col = j;
        
//         while(col >= 0){
//             if(seen[row][col] == 'Q'){
//                 return false;
//             }
//             col--;
//         }
        
//         row = i;
//         col = j;
        
//         while(row < n && col >= 0){
//             if(seen[row][col] == 'Q'){
//                 return false;
//             }
//             row++;
//             col--;
//         }
        
//         return true;
    
//     }
    
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