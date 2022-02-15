class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> slist = new ArrayList<>();
        solve(list, slist, nums);
        return list;
    }
    
    public void solve(List<List<Integer>> list, List<Integer> slist, int[] nums){
        if(slist.size() == nums.length){
            list.add(new ArrayList<>(slist));
            return;
        }
        
        for(int i = 0; i < nums.length; i++){
            if(slist.contains(nums[i]))continue;
            slist.add(nums[i]);
            solve(list, slist, nums);
            slist.remove(slist.size() - 1);
        }
    }
}