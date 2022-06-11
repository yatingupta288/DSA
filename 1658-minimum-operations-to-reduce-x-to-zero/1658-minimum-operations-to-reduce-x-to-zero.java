class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        
        int l =0, r =0, currsum = 0, ans =-1;
        while(r < nums.length){
            currsum += nums[r++];
            while( l < r && currsum > sum - x){
                currsum -= nums[l++];
            }
            if(currsum == sum - x){
                ans = Math.max(ans, r-l); 
            }
        }
        
        return ans == -1 ? -1 : nums.length - ans;
    }
}