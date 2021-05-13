public static void printAllPaths(ArrayList<Edge> graph[], int src, int dest, String psf, boolean[] visited){
        if(src == dest){
            System.out.println(psf);
            return;
        }
        
        visited[src] = true;
        
        for(Edge e : graph[src]){
            if(visited[e.nbr] == false){
                printAllPaths(graph, e.nbr, dest, psf + e.nbr , visited);
            }
        }
        visited[src] = false;
    }