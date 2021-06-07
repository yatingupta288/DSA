class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i < n; i++){
            map.add(nums[i]);
        }
        for(int i = 0; i < n; i++){
            if(!map.contains(nums[i] - 1)){
                int count = nums[i];
                while(map.contains(count)){
                    count++;
                }
                max = Math.max(max, count - nums[i]);
            }
        }
    return max == Integer.MIN_VALUE ? 0 : max;
    }
}