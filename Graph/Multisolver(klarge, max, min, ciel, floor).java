public static void multisolver(ArrayList<Edge>[] graph, int src, int dest, boolean[] visited, int criteria, int k, String psf, int wsf) {
       
     if(src == dest){
         if(wsf < spathwt){
             spathwt = wsf;
             spath = psf;
         }
         
         if(wsf > lpathwt){
             lpathwt = wsf;
             lpath = psf;
         }
         
         if(wsf > criteria && wsf < cpathwt){
             cpathwt = wsf;
             cpath = psf;
         }
         
         if(wsf < criteria && wsf > fpathwt){
             fpathwt = wsf;
             fpath = psf;
         }
         
         if(pq.size() < k){
             pq.add(new Pair(wsf, psf));
         }else if(wsf > pq.peek().wsf){
             pq.remove();
             pq.add(new Pair(wsf,psf));
         }
         
         return;
     }  
       
      visited[src] = true;
      
      for(Edge e : graph[src]){
          if(visited[e.nbr] == false){
              multisolver(graph, e.nbr, dest, visited, criteria, k, psf + e.nbr , wsf + e.wt);
          }
      }
       visited[src] = false;
   }