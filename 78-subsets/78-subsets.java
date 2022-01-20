class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(list, res, 0, nums);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> res, int j, int[] nums){
        list.add(new ArrayList<>(res));
        if(j == nums.length)return;
        for(int i = j; i < nums.length; i++){
            res.add(nums[i]);
            System.out.print(res);
            helper(list, res, i + 1, nums);
            res.remove(res.size() - 1);
        }
        
        return;
    }
}