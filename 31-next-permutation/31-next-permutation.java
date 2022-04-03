class Solution {
    public void nextPermutation(int[] nums) {
        int max = 0;
        int idx = 0;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i - 1] < nums[i]){
                max = nums[i - 1];
                idx = i;
                break;
            }
        }
        if(idx == 0){
            Arrays.sort(nums);
            return;
        }
        int smallest = nums[idx];
        int j = 0;
        for(int i = idx; i < nums.length; i++){
            if(nums[i] > max && nums[i] <= smallest){
                smallest = nums[i];
                j = i;
            }
        }
        int temp = nums[idx - 1];
        nums[idx - 1] = nums[j];
        nums[j] = temp;
        
        Arrays.sort(nums, idx, nums.length);
    }
}