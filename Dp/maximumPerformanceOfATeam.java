class Solution {
    public int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int es[][] = new int[n][2];
        for(int i = 0 ; i < n; i++){
            es[i] = new int[]{efficiency[i], speed[i]};
        }        
        Arrays.sort(es, (a,b) -> b[0] - a[0]);
        
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long totalSpeed = 0;
        long maxPerformance = 0;
        for(int[] hier : es){
            
            if(pq.size() == k){
                int slowGuy = pq.poll();
                totalSpeed -= slowGuy;
            }
            
            pq.add(hier[1]);
            totalSpeed += hier[1];
            
            long performanceWNewGuy = totalSpeed * hier[0];
            maxPerformance = Math.max(maxPerformance, performanceWNewGuy);
        }
        return (int)(maxPerformance % 1000000007);
    }
}