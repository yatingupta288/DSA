class Solution {
    public int findJudge(int N, int[][] trust) {
        if(N == 1){
            return 1;
        }
        int n = trust.length;
        int dp[] = new int[N + 1];
        if (n < N - 1) return -1;
        int max = 0;
        HashSet<Integer> h = new HashSet<>();
        for(int i = 0; i < n; i++){
            dp[trust[i][1]]++;
            h.add(trust[i][0]);
            if(dp[max] < dp[trust[i][1]]){
                max = trust[i][1];
            }
        }
        if(h.contains(max)){
            return -1;
        }
        return dp[max] == N-1 ? max : -1;
    }
}
