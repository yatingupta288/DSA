// [0,0,1,1,1,2,2,3,3,4]
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        for(int num : nums){
            if(i < 1 || num > nums[i - 1]){
                nums[i++] = num;
            }
        }
        
        return i;
    }
}