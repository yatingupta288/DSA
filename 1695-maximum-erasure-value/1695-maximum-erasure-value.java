class Solution {
    // sliding window
    public int maximumUniqueSubarray(int[] nums) {
        int l = 0;
        int max = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int r = 0; r < nums.length; r++){
            if(map.containsKey(nums[r])){
                l = Math.max(l, map.get(nums[r]) + 1);
            }
            map.put(nums[r], r);
            int sum = 0;
            for(int j = l; j <=r; j++){
                sum += nums[j];
            }
            max = Math.max(max, sum);
        }
        
        return max;
    }
}