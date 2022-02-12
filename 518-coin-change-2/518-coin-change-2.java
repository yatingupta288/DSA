class Solution {
    public int change(int amount, int[] coins) {
        if(amount == 0)return 1;
        if(coins.length == 0)return 0;
        Integer dp[][] = new Integer[amount + 1][coins.length + 1];
        return dphelper(dp, amount, 0, coins);
    }
    
    public int dphelper(Integer[][] dp, int amount, int n, int coins[]){
        if(amount == 0){
            return 1;
        }
        
        if(amount < 0 || n == coins.length){
            return 0;
        }
        
        if(dp[amount][n] != null){
            return dp[amount][n];
        }
        int sum1 = dphelper(dp, amount - coins[n], n, coins);
        int sum2 = dphelper(dp, amount, n + 1, coins);
        
        return dp[amount][n] = sum1 + sum2;
    }
}