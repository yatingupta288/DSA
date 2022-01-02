class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int dp[] = new int[n + 2];
        dp[0] = 1;
        dp[n + 1] = 1;
        for(int i = 0; i < nums.length; i++){
            dp[i + 1] = nums[i];
        }
        int memo[][] = new int[n + 2][n + 2];
        return burst(memo, dp, 0, n + 1);
    }
    
    public int burst(int memo[][], int dp[], int left, int right){
        if(left + 1 == right){
            return 0;
        }
        
        if(memo[left][right] != 0){
            return memo[left][right];
        }
        int ans = Integer.MIN_VALUE;
        for(int i = left + 1; i < right; i++){
            ans = Math.max(ans, (dp[left] * dp[i] * dp[right]) + burst(memo, dp, left, i) + burst(memo, dp, i, right));
        }
        memo[left][right] = ans;
        return ans;
    }
}