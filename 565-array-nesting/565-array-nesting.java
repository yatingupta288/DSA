class Solution {
    public int arrayNesting(int[] nums) {
        boolean seen[] = new boolean[nums.length];
        int count = 0;
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            while(seen[i] != true){
                seen[i] = true;
                count++;
                i = nums[i];
            }
            res = Math.max(res, count);
            count = 0;
        }
        
        return res;
    }
}