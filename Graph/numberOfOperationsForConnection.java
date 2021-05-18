class Solution {
    
    public int dfs(List<Integer> graph[], int src, boolean[] visited){
        if(visited[src] == true){
            return 0;
        }
        visited[src] = true;
        for(int e : graph[src]){
                dfs(graph, e, visited);
        }
        return 1;
    }
    
    public int makeConnected(int n, int[][] connections) {
        int N = connections.length;
        if(n - 1 > N){
            return -1;
        }
        List<Integer>graph[] = new ArrayList[n];
        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] c : connections){
            graph[c[0]].add(c[1]);
            graph[c[1]].add(c[0]);
        }
        
        int component = 0;
        boolean visited[] = new boolean[n];
        for(int i = 0; i < n; i++){
            component += dfs(graph, i, visited);
        }
        return component - 1;
    }
}