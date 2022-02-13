class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> slist = new ArrayList<>();
        sets(list, slist, 0, nums);
        return list;
    }
    
    public void sets(List<List<Integer>> list, List<Integer> slist, int idx, int[] nums){
        list.add(new ArrayList<>(slist));
        if(idx == nums.length){
            return;
        }
        
        for(int i = idx; i < nums.length; i++){
            if(i > idx && nums[i] == nums[i - 1])continue;
            slist.add(nums[i]);
            sets(list, slist, i + 1, nums);
            slist.remove(slist.size() - 1);
        }
    }
}