class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for(int i = 0; i < stones.length; i++){
            pq.offer(stones[i]);
        }
        int remainingStone = 0;
        while(pq.size() != 1){
            int y = pq.poll();
            int x = pq.poll();
            
            remainingStone = y - x;
            pq.offer(remainingStone);
        }
        
        return pq.poll();
    }
}