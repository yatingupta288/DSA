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

//for(int i=1; i<=nums.length; i++){
//        if(nums[i-1]==0)
//            dp[i][0] = dp[i-1][0] * 2;
//        else
//            dp[i][0] = dp[i-1][0];
//    }

// BELOW IS THE REASON FOR THIS STATEMENT -> dp[i][0] = dp[i-1][0] * 2;

//it is for '0's in the array. If we have n number of zeroes then we need to multiply out result of count of subsets with a sum to 2^n.
//For example: If we have 2(cnt=2) zeroes in the example array for which we calculate count of subset with a sum then there are 4(2^cnt) ways that is either selecting first zero, second selecting second 0 present in array, third not selecting both, fourth selecting both.
//Hope this will be helpful.