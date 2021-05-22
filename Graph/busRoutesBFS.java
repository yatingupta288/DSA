class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if(source==target)return 0;
        boolean[] visited=new boolean[routes.length];
        
        HashMap<Integer,ArrayList<Integer>> ht=new HashMap<>();
        
        for(int i=0;i<routes.length;i++){
            for(int j=0;j<routes[i].length;j++){
                ArrayList<Integer> buses=ht.getOrDefault(routes[i][j],new ArrayList<>());
                buses.add(i);
                ht.put(routes[i][j],buses);
            }
        }
        
        Queue<Integer> q=new ArrayDeque<>();
        int ret=0;
        q.add(source);
        while(!q.isEmpty()){
            int len=q.size();
            ret++;
            for(int i=0;i<len;i++){
                int cur=q.poll();
                
                ArrayList<Integer> al=ht.get(cur);
                for(int bus:al){
                    if(visited[bus]==true)continue;
                    visited[bus]=true;
                    for(int j=0;j<routes[bus].length;j++){
                        if(routes[bus][j]==target)return ret;
                        q.add(routes[bus][j]);
                    }
                }
            }
        }
        return -1;
    }
}