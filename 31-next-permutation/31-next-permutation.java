class Solution {
    public void nextPermutation(int[] nums) {
        int min = Integer.MAX_VALUE;
        int swap = 0;
        int idx = 0;
        int minidx = 0;
        int i = 0;
        for(i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i - 1]){
                idx = i - 1; //1
                break;
            }
        }
        if(i == 0){
            Arrays.sort(nums);
            return;
        }
        int number = nums[idx]; 
        for(int j = nums.length - 1; j >= idx + 1; j--){
            if(min > nums[j] && nums[j] > number){
                min = nums[j];
                minidx = j;
            }
        }
        
        int temp = nums[idx];
        nums[idx] = nums[minidx];
        nums[minidx] = temp;
        
        Arrays.sort(nums, idx+1,nums.length);
        return;
    }
}