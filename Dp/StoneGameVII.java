class Solution {

    // TC : O(n2)
    // SC : O(n2)
    // Top Down approach
    public int stoneGameVII(int[] stones) {
        int n = stones.length;
        int[][] dp = new int[n][n];
        int sum = 0;
        for(int i = 0; i < n; i++){
            sum += stones[i];
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                dp[i][j] = -1;
            }
        }
        return dp(0, n - 1, stones, dp, sum);
    }
    
    public int dp(int left, int right, int[] stones, int dp[][], int sum){
        if(left == right){
            return 0;
        }
        
        if(right - left == 1){
            return Math.max(stones[left], stones[right]);
        }
        
        if(dp[left][right] != -1){
            return dp[left][right];
        }else{
            dp[left][right] = Math.max(sum - stones[left] - dp(left + 1, right, stones, dp, sum - stones[left]), sum - stones[right] - dp(left, right - 1, stones, dp, sum - stones[right]));
            return dp[left][right];
        }
        
    }
}


// class Solution {
//     int[] preSum;
//     public int stoneGameVII(int[] stones) {
//         int n = stones.length;
//         preSum = new int[n + 1];
//         for (int i = 0; i < n; i++) preSum[i + 1] = preSum[i] + stones[i];
        
//         int[][] dp = new int[n][n];
//         for (int l = n - 1; l >= 0; --l) {
//             for (int r = l + 1; r < n; ++r) {
//                 int scoreRemoveLeftMost = getSum(l + 1, r);
//                 int scoreRemoveRightMost = getSum(l, r - 1);
//                 dp[l][r] = Math.max(scoreRemoveLeftMost - dp[l + 1][r], scoreRemoveRightMost - dp[l][r - 1]);
//             }
//         }
//         return dp[0][n - 1];
//     }
//     int getSum(int left, int right) {
//         return preSum[right + 1] - preSum[left];
//     }
// }