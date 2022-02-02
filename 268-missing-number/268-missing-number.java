class Solution {
    public int missingNumber(int[] nums) {
        int i = 0;
        while(i < nums.length){
            int idx = nums[i];
            if(idx < nums.length && nums[i] != nums[idx]){
                int temp = nums[i];
                nums[i] = nums[idx];
                nums[idx] = temp; 
            }else{
                i++;
            }
        }
        
        int j = 0;
        for(j = 0; j < nums.length; j++){
            if(nums[j] != j){
                return j;
            }
        }
        
        return nums.length;
    }
}