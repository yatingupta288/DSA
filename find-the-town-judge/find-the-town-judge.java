class Solution {
    public int findJudge(int n, int[][] trust) {
        int judgeFinder[] = new int[n + 1];
        for(int relation[] : trust){
            judgeFinder[relation[1]]++;
            judgeFinder[relation[0]]--;
        }
        
        for(int i = 1; i < judgeFinder.length; i++){
            System.out.print(judgeFinder[i] + " ");
            if(judgeFinder[i] == n - 1){
                return i;
            }
        }
        return -1;
    }
}