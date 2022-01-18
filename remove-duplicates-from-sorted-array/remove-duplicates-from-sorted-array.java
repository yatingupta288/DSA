// [0,0,1,1,1,2,2,3,3,4]
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < nums.length && j < nums.length){
            while(j < nums.length && nums[j] == nums[i]){
                j++;
            }
            i++;
            if(j < nums.length)nums[i] = nums[j];
            count++;
        }
        return count;
    }
}