class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,nums, nums.length, new ArrayList<>(), res);
        return res;
    }
    
    public void helper(int i, int[] nums, int n,List<Integer> list, List<List<Integer>> res){
        if(i == n){
            res.add(new ArrayList<>(list));
            return;
        }
        
        list.add(nums[i]);
        helper(i + 1, nums, n, list, res);
        list.remove(list.size() - 1);
        
        helper(i + 1, nums, n, list, res);
        
        return;
    }
}