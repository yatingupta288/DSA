class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0; i < n ; i++){
            sum = sum + nums[i];
        }
        
        int diff = (target + sum)/2;
        if(target > sum || (sum + target) % 2 == 1)   return 0;
        
        return subSetSum(nums, diff);
    }
    
    public int subSetSum(int[] nums, int diff){
        int n = nums.length;
        int dp[][] = new int[n + 1][diff + 1];
        
        for(int i=0; i< nums.length; i++){ 
            dp[i][0] = 1;
    }
        
        for(int i=1; i<=nums.length; i++){
            for(int j=0; j<=diff; j++){
                if(j>=nums[i-1])
                    dp[i][j] = dp[i-1][j-nums[i-1]] + dp[i-1][j];
                else
                    dp[i][j] = dp[i-1][j];
            }
        }
        return dp[n][diff];
    }
}
