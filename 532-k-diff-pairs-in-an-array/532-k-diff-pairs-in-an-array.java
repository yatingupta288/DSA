class Solution {
    public int findPairs(int[] nums, int k) {
        int count = 0;
        Map<Integer,  Integer> map = new HashMap<>();
        for(int i : nums){
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        
        for(int i : map.keySet()){
            if(k == 0){
                if(map.get(i) >= 2){
                    count++;
                }
            }else{
                if(map.containsKey(i + k)){
                    count++;
                }
            }
        }
        return count;
    }
}