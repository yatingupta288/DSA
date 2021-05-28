public class Solution {
        public boolean canPartition(int[] nums) {
        int sum = 0;

        for (int num : nums) {
            sum += num;
        }

        if ((sum & 1) == 1) {
            return false;
        }
        sum /= 2;

        int n = nums.length;
        boolean[] dp = new boolean[sum+1];
        dp[0] = true;

        for (int num : nums) {
            for (int i = sum; i >= num; i--) {
                
                dp[i] = dp[i] || dp[i-num];
            }
        }

        return dp[sum];
    }

}

// class Solution {
//     public boolean canPartition(int[] nums) {
        
//         if (nums.length == 0) {
//             return true;
//         }
        
//         int n = nums.length;
//         int sum = 0;
        
//         for (int i = 0; i < nums.length; i++) {
//             sum += nums[i];
//         }
        
//         if (sum % 2 == 1) {
//             return false;
//         } 
        
//         sum = sum / 2;
        
//         boolean[][] t  = new boolean[n+1][sum+1];
        
//         for (int i = 0; i <= n; i++) {
//             t[i][0] = true;
//         }
        
//         for (int i = 1; i <= n; i++) {
//             for (int j = 1; j <= sum; j++) {
//                 if (nums[i-1] > j) {
//                     t[i][j] = t[i-1][j]; 
//                  } else {
//                     t[i][j] = t[i-1][j] || t[i-1][j - nums[i-1]];
//                 }
//             }
//         }
        
        
//         return t[n][sum];
//     } 
// }