class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(0,nums,nums.length,res, new ArrayList<>());
        return res;
    }
    
    public void helper(int idx, int[] nums, int n, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));
        if(idx == n){
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1])continue;
            list.add(nums[i]);
            helper(i + 1, nums, n, res, list);
            list.remove(list.size() - 1);
        }
        
        return;
    }
}