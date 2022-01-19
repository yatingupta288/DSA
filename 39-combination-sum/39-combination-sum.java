class Solution {
    public List<List<Integer>> combinationSum(int[] c, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        helper(list, temp, target, 0, c);
        return list;
    }
    
    public void helper(List<List<Integer>> list, List<Integer> temp, int remain, int start, int[] c){
        if(remain < 0){
            return;
        }
        
        if(remain == 0){
            list.add(new ArrayList<>(temp));
            return;
        }
        for(int i = start; i < c.length; i++){
            temp.add(c[i]);
            helper(list, temp, remain - c[i], i, c);
            temp.remove(temp.size() - 1);
        }
        return;
    }
}