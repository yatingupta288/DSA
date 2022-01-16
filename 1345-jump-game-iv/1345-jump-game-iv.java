class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        if(n == 0)return 0;
        
        HashMap<Integer, LinkedList<Integer>> map = new HashMap<>();
        
        for(int i = 0; i < n; i++){
            map.computeIfAbsent(arr[i], v -> new LinkedList<>()).add(i);
        }
        
        ArrayList<Integer> curr = new ArrayList<>();
        boolean visited[] = new boolean[n];
        int step = 0;
        curr.add(0);
        while(curr.size() != 0){
            ArrayList<Integer> list = new ArrayList<>();
            for(int node : curr){
                if(!visited[node]){
                    list.add(node);
                    visited[node] = true;
                }
                if(node == arr.length - 1){
                    return step;
                }
                for(int nei : map.get(arr[node])){
                    if(!visited[nei]){
                        list.add(nei);
                        visited[nei] = true;
                    }
                }
                map.get(arr[node]).clear();
                
                if(node - 1 >= 0 && !visited[node-1]){
                    list.add(node - 1);
                    visited[node - 1] = true;
                }
                
                if(node + 1 < arr.length && !visited[node + 1]){
                    list.add(node + 1);
                    visited[node + 1] = true;
                }
            }
            step++;
            curr = list;
        }
        return -1;
    }
}