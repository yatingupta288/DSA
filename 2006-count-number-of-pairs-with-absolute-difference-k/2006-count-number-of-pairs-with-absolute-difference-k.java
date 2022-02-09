class Solution {
    public int countKDifference(int[] nums, int k) {
        int freq[] = new int[101];
        int count = 0;
        for(int i : nums){
            freq[i]++;
        }
        
        for(int i = 0; i + k < 101; i++){
            count += freq[i] * freq[i + k];
        }
        
        return count;
    }
}