class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int count = 0;
        for(int n : nums){
            count++;
            if(i == 0 || n > nums[i - 1]){
                nums[i++] = n;
                count= 1;
            }
            if(count == 2){
                nums[i] = nums[i - 1];
                i++;
            }
        }
        return i;
    }
}