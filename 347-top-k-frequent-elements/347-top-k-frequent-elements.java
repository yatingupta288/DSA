class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map= new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (map.get(b) - map.get(a)));
        int[] arr = new int[k];
        for(int keys : map.keySet()){
            pq.add(keys);
        }
        int i = 0;
        while(k-- > 0){
            arr[i++] = pq.poll();
        }
        
        return arr;
    }
}