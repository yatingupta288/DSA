// DP
class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] = new int[m][n];
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 1;
                }else{
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
// RECURSIVE
// class Solution {
//   public int uniquePaths(int m, int n) {
//       int[][] dp=new int[m][n];
//      uniquePathsHelper(m-1,n-1 ,dp);
//       return dp[m-1][n-1];
//   }
  
//   private int uniquePathsHelper(int m, int n,int[][] dp) {
//     if (m == 0 || n == 0) {
//       return dp[m][n]=1;
        
//     } 
//     if(dp[m][n]>0){return dp[m][n];
//     }
//     else {
//       return dp[m][n]=uniquePathsHelper(m - 1, n,dp) + uniquePathsHelper(m, n - 1,dp);
//     }
//   }
// }