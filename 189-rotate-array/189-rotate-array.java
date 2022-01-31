class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;
        
        invert(nums, 0, nums.length - 1);
        invert(nums, 0, k - 1);
        invert(nums, k, nums.length - 1);
    }
    
    public void invert(int[] nums, int lo, int hi){
        while(lo <= hi){
            int temp = nums[lo];
            nums[lo] = nums[hi];
            nums[hi] = temp;
            lo++;
            hi--;
        }
    }
}