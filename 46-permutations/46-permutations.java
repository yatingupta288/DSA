class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>(); 
        boolean[] seen = new boolean[nums.length];
        helper(0,nums, res, new ArrayList<>(),seen);
        return res;
    }
    
    public void helper(int idx, int[] nums, List<List<Integer>> res, List<Integer> list, boolean[] seen){
        if(idx == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(seen[i])continue;
            seen[i] = true;
            list.add(nums[i]);
            helper(idx + 1, nums, res, list, seen);
            list.remove(list.size() - 1);
            seen[i] = false;
        }
    }
}