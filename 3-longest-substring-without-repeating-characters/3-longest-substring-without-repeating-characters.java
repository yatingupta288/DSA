class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0;
        int j = 0;
        int freq[] = new int[95];
        int count = 0;
        int ans = Integer.MIN_VALUE;
        while(j < s.length()){
            while(j < s.length() && freq[s.charAt(j) - ' '] < 1){
                freq[s.charAt(j++) - ' ']++;
            }
            ans = Math.max(ans, j - i);
            i++;
            j = i;
            freq = new int[95];
        }
        return ans == Integer.MIN_VALUE ? 0 : ans;
    }
}