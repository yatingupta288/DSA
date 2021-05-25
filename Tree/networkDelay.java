class Solution {
       public int networkDelayTime(int[][] times, int N, int K) {
           List<int []>graph[] = new ArrayList[N + 1];
           for(int i = 1; i <= N; i++){
               graph[i] = new ArrayList<>();
           }
           
           for(int [] vertex : times){
               graph[vertex[0]].add(new int[]{vertex[1], vertex[2]});
           }
           
           
           int[] dis = new int[N + 1];
           Arrays.fill(dis, Integer.MAX_VALUE);
           dis[K] = 0;
           TreeSet<Integer> q = new TreeSet<>((a,b) -> dis[a] != dis[b] ? dis[a] - dis[b] : a - b);
           for(int i = 1 ; i <= N; i++){ //ADDING ALL ELEMENTS TO THE SET
               q.add(i);
           }
           // HERE WEIGHT REPRESENTS TIME
               int res = 0;
               while(!q.isEmpty()){
                   int c = q.pollFirst(); //POPING THE  ELEMENT WITH SHORTEST WEIGHT ACC. TO DIS[]
                   res = Math.max(dis[c], res); // UPDATING RES WITH MAXIMUM VALUES OF DIS
                   for(int curr[] : graph[c]){
                       int v = curr[0];
                       int w = curr[1];
                       
                       if(dis[v] > dis[c] + w){
                           q.remove(v); // REMOVING THE VALUES FIRST FOR SORTING THEM 
                           dis[v] = dis[c] + w;
                           q.add(v);
                       }
                   }
               }
          return res == Integer.MAX_VALUE ? -1 : res;
       }
}
