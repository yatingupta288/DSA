// index of the next place
// visited array
// count to store the max length
class Solution {
    int res = 0;
    public int arrayNesting(int[] nums) {
        int seen[] = new int[nums.length];
        int idx = 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(seen[i] != -1){
                dfs(nums, i, seen, count);
            }
        }

        return res;
    }
    
    public void dfs(int[] nums, int idx, int[] seen, int count){
        // System.out.print(nums[idx] + " ");
        if(seen[idx] == -1){
            res = Math.max(res, count);
            return;
        }
        
        seen[idx] = -1;
        dfs(nums, nums[idx], seen, count + 1);
        // seen[idx] = 0;
        return;
    }
}