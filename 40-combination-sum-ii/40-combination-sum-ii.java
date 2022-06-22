class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        Arrays.sort(candidates);
        helper(0, candidates, candidates.length,target, list, res);
        return res;
    }
    
    public void helper(int idx, int[] arr, int n,int t, List<Integer> list, List<List<Integer>> res){
        if(t == 0){
            res.add(new ArrayList<>(list));
            return;
        }
        
        for(int i = idx; i < n; i++){
            if(i > idx && arr[i] == arr[i - 1])continue;
            if(arr[i] > t){
                break;
            }
            list.add(arr[i]);
            helper(i + 1, arr, n, t - arr[i], list, res);
            list.remove(list.size() - 1);
        }
        
        return;
    }
}