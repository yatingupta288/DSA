// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int dp[] = new int[amount + 1];
//         Arrays.fill(dp, amount + 1);
//         dp[0] = 0;
//         for(int coin : coins){
//             for(int i = coin ; i < amount + 1; i++){ // starting the count from the given denomination because even if start from first denomination it will not be the same coins(using which we want to count the sum) and we want a particular denomination 
//                 dp[i] = Math.min(dp[i], dp[i - coin] + 1); 
//             }
//         }
//         return dp[amount] > amount ? -1 : dp[amount];
//     }
// }

class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int dp[][] = new int[n + 1][amount + 1];
        for(int i = 0; i <=n; i++){
            dp[i][0] = 0;
        }
        
        for(int i = 1; i <=amount ; i++){
            dp[0][i] =Integer.MAX_VALUE-1; // we subtacted 1 in case 1 is added in the any of these value then it will then it will change integer.Max_value to integer.min_value so in order to prevent it we subtract 1 
        }
        
        for(int i = 1; i < n + 1; i++){
            for(int j = 1; j < amount + 1; j++){
                if(coins[i - 1] > j ){
                    dp[i][j] = dp[i - 1][j];
                }else{
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]);
                }
            }
        }
        
        return dp[n][amount] > 10000? -1 : dp[n][amount];
    }
}

// class Solution {
//     public int coinChange(int[] coins, int amount) {
//         int n = coins.length;
        
//         int dp[][] = new int[n+1][amount+1];
        
//         for(int i=0;i<=n;++i)
//         {
//             for(int j=0;j<=amount;++j)
//             {
//                 if(j==0)
//                     dp[i][j] = 0;
//                 else if(i==0)
//                     dp[i][j] = 100000;
//                 else if(coins[i-1]>j)
//                     dp[i][j] = dp[i-1][j];
//                 else
//                     dp[i][j] = Math.min(1 + dp[i][j-coins[i-1]], dp[i-1][j]);
//             }
//         }
//         return dp[n][amount]>1e4 ? -1:dp[n][amount];
//     }
// }
    
dp[0][i] =Integer.MAX_VALUE-1; // we subtacted 1 in case 1 is added in the any of these value then it will then it will change integer.Max_value to integer.min_value so in order to prevent it we subtract 1 