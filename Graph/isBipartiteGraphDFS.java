class Solution {
    public boolean isBipartite(int[][] graph) {
        // Array representing the colors
        int[] colors = new int[graph.length];
        
        // DFS of each node
        for(int i=0; i<graph.length; i++) {
            // If uncolored, then perform DFS
            if(colors[i] == 0 && !hasEvenCycle(graph, colors, i, 1))
                return false;
        }
        
        return true;
    }
    
    // Return true when graph is bipartite
    public boolean hasEvenCycle(int[][] g, int[] colors, int node, int c) {
        // if node is colored, node color is same as sent in func definition, return true
        if(colors[node] != 0)
            return colors[node] == c;
        
        // Color the current node with color sent in func definition
        colors[node] = c;
        
        // Check for all the adjecent nodes of the current node "node"
        for(int n : g[node]) {
            if(!hasEvenCycle(g, colors, n, -c))
                return false;
        }
        
        return true;
        
    }