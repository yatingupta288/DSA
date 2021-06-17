class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        long dp[] = new long[n + 1];
        dp[0] = startFuel;
        for(int i = 0; i < n; i++){
            for(int j = i; j >= 0; j--){
                if(dp[j] >= stations[i][0]){
                    dp[j + 1] = Math.max(dp[j + 1], dp[j] + stations[i][1]);
                }
            }
        }
        
        for(int i = 0; i <= n; i++){
            if(dp[i] >= target){
                return i;
            }
        }
        return -1;
    }
}

// class Solution {

//     // TC : O(nlogn)
//     // SC : O(n)
//     public int minRefuelStops(int target, int startFuel, int[][] stations) {
//         int dist = startFuel;
//         int noOfStops = 0;
        
//         PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
//         for(int next[] : stations){
//             int station = next[0];
//             int fuel = next[1];
            
//             while(dist < station){
//                 if(pq.isEmpty()){
//                     return -1;
//                 }
//                 int maxFuel = pq.poll();
//                 dist = dist + maxFuel;
//                 noOfStops++; 
//             }
            
//             pq.offer(fuel);
        
//         }
        
//         while(dist < target){
//             if(pq.isEmpty()){
//                 return -1;
//             }
//             int maxFuel = pq.poll();
//             dist = dist + maxFuel;
//             noOfStops++; 
//         }
        
//         return noOfStops;
//     }
// }