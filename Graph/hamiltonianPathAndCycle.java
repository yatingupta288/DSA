public static void hamiltonian(ArrayList<Edge> graph[], int src, HashSet<Integer> visited, String psf, int osrc){
       
       if(visited.size() == graph.length - 1){
           System.out.print(psf);
           boolean closingEdge = false;
           for(Edge e : graph[src]){
               if(e.nbr == osrc){
                   closingEdge = true;
                   break;
               }
           }
           
           if(closingEdge == true){
               System.out.println("*");
           }else{
               System.out.println(".");
           }
       }
       visited.add(src);
       
       for(Edge e : graph[src]){
           if(visited.contains(e.nbr) == false){
               hamiltonian(graph, e.nbr, visited, psf + e.nbr, osrc);
           }
       }
       visited.remove(src);
   }