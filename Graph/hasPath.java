public static boolean HasPath(ArrayList<Edge> graph[], int src, int dest, boolean [] visited){
       if(src == dest){
           return true;
       }
       
       visited[src] = true;
       
       for(Edge e : graph[src]){
           if(visited[e.nbr] == false){
               boolean b = HasPath(graph, e.nbr, dest, visited);
               if(b){
                   return true;
               }
           }
       }
       
       return false;
   }