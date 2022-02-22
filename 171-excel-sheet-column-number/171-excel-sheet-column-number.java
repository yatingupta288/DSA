class Solution {
    public int titleToNumber(String c) {
        int ans = 0; 
        int count = 0;
        for(int i = c.length() - 1; i >= 0; i--){
            int idx = c.charAt(i) - 'A' + 1;
            // System.out.print(idx + " ");
            ans  += Math.pow(26, count) * idx;
            count++;
        }
        
        return ans;
    }
}