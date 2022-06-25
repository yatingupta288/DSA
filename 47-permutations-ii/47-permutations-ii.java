class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        boolean seen[] = new boolean[nums.length];
        helper(0, nums, new ArrayList<>(), res, seen);
        return res;
    }
    
    public void helper(int idx, int nums[], List<Integer> list, List<List<Integer>> res, boolean[] seen){
        if(idx == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(i > 0 && nums[i] == nums[i - 1] && !seen[i - 1])continue;
            if(seen[i])continue;
            list.add(nums[i]);
            seen[i] = true;
            helper(idx + 1, nums, list, res, seen);
            list.remove(list.size() - 1);
            seen[i] = false;
        }
    }
}