class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int color[] = new int[n];
        Arrays.fill(color, -1);
        for(int i = 0; i < n; i++){
            if(color[i] == -1){
                if(!dfs(i, graph, color))return false;
            }
        }
        return true;
    }
    
    boolean dfs(int src, int graph[][], int[] color){
        Queue<Integer> q = new LinkedList<>();
        q.add(src);
        color[src] = 0;
        while(!q.isEmpty()){
            int curr = q.poll();
            for(int nei : graph[curr]){
                if(color[nei] == color[curr]){
                    return false;
                }
                else if(color[nei] == -1){
                    color[nei] = 1 - color[curr];
                    q.add(nei);
                }
            }
        }
        return true;
    }
}