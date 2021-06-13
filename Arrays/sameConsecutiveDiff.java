class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        ArrayList<Integer> res = new ArrayList<>();
        for(int i = 1; i <= 9 ; i++){
            dfs(n, k, i, 0, i, res);
        }
        int arr[] = new int[res.size()];
        for(int i = 0 ; i < res.size(); i++){
            arr[i] = res.get(i);
        }
        return arr;
    }
    
    public void dfs(int n ,int k, int curr, int i, int prev, ArrayList<Integer> res){
        if(i == n - 1){
            res.add(curr);
            return;
        }
        int next = prev + k; 
        if(next < 10){
            dfs(n, k, (curr * 10) + next, i + 1, next, res);
        }
        
        next = prev - k;
        if(k != 0 && next >= 0){
            dfs(n, k, (curr * 10) + next, i + 1, next, res);
        }
    }   
}