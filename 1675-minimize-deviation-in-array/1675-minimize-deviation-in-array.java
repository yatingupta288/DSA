class Solution {
    public int minimumDeviation(int[] nums) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] % 2 == 1){
                nums[i] = nums[i] * 2;
            }
            
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            pq.add(nums[i]);
        }
        int md = max - min;
        
        while(pq.peek() % 2 == 0){
            int MAX = pq.poll();
            MAX = MAX/2;
            
            min = Math.min(min, MAX);
            pq.offer(MAX);
            md = Math.min(md, pq.peek() - min);
        }
        
        return md;
    }
}