class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> res = new ArrayList<>();
        helper(0, candidates, target, list, 0, n, res);
        return res;
    }
    
    public void helper(int i, int[] arr, int target, List<Integer> list, int sum, int n, List<List<Integer>> res){
        if(i == n)return;
        if(sum > target)return;
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(arr[i]);
        sum += arr[i];
        helper(i, arr, target, list, sum, n, res);
        list.remove(list.size() - 1);
        sum -= arr[i];
        helper(i + 1, arr, target, list, sum, n, res);
        return;
    }
}