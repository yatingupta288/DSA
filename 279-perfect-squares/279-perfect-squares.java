class Solution {
    int dp[] = new int[10000];
    public int numSquares(int n) {
        if(n < 0)return Integer.MAX_VALUE;
        if(n == 0)return 0;
        if(dp[n] != 0){
            return dp[n];
        }
        int min = n;
        for(int i = 1; i * i <= n; i++){
            min = Math.min(min, numSquares(n - i *i));
        }
        dp[n] = min + 1;
        return dp[n];
    }
    
}