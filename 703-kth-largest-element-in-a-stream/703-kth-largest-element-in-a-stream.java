class KthLargest {
    private int kth;
    private PriorityQueue<Integer> pq;
    public KthLargest(int k, int[] nums) {
        this.kth = k;
        pq = new PriorityQueue<>();
        
        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
    }
    
    public int add(int val) {
        while(pq.size() > kth){
            pq.poll();
        }
        pq.add(val);
        while(pq.size() > kth){
            pq.poll();
        }        
        return pq.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */