class Solution {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        ArrayList<Integer> sublist = new ArrayList<>();
        sets(sublist,nums,0);
        return list;
    }
    
    public void sets(ArrayList<Integer> slist, int[] nums, int idx){
        list.add(new ArrayList<>(slist));
        // slist.add(nums[idx]);
        if(idx == nums.length){
            return;
        } 
        for(int i = idx; i < nums.length; i++){
            slist.add(nums[i]);
            sets(slist, nums, i + 1);
            slist.remove(slist.size() - 1);
        }
        return;
    }
}