// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int tc = scan.nextInt();

        while (tc-- > 0) {
            int N = scan.nextInt();
            int M = scan.nextInt();
            int E = scan.nextInt();

            boolean graph[][] = new boolean[N][N];

            for (int i = 0; i < E; i++) {
                int u = scan.nextInt() - 1;
                int v = scan.nextInt() - 1;
                graph[u][v] = true;
                graph[v][u] = true;
            }

            System.out.println(new solve().graphColoring(graph, M, N) ? 1 : 0);
        }
    }
}
// } Driver Code Ends


class solve {
    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    
    public boolean canColor(int colr, int node, boolean[][] graph, int n, int[] color){
        for(int i = 0; i < n; i++){
            if(i != node && graph[i][node] && color[i] == colr){
                return false;
            }
        }
        
        return true;
    }
    public boolean graphColoring(boolean graph[][], int m, int n) {
        // Your code here
        int color[] = new int[n];
        if(solve(0, graph, m, n, color))return true;
        return false;
    }
    
    public boolean solve(int node, boolean[][] graph, int m, int n, int[] color){
        if(node == n){
            return true;
        }
        
        for(int colr = 1; colr <= m ; colr++){
            if(canColor(colr, node, graph,n, color)){
                color[node] = colr;
                if(solve(node + 1, graph, m, n, color))return true;
                color[node] = 0;
            }
        }
        
        return false;
    }
}