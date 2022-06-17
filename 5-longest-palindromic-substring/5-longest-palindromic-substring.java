// diagonal traversal or gap strategy involved.
// refer to pepcoding video for idea.
class Solution {
    public String longestPalindrome(String s) {
        String str = "";
        boolean dp[][] = new boolean[s.length()][s.length()];
        for(int gap = 0; gap < s.length(); gap++){
            for(int k = 0, j = gap; j < s.length(); j++, k++){
                if(gap == 0){
                    dp[k][j] = true;
                }else if( gap == 1){
                    if(s.charAt(k) == s.charAt(j)){
                        dp[k][j] = true;
                    }else{
                        dp[k][j] = false;
                    }
                }else{
                    if(s.charAt(k) == s.charAt(j) && dp[k + 1][j - 1]){
                        dp[k][j] = true;
                    }else{
                        dp[k][j] = false;
                    }
                }
                if(dp[k][j]){
                    str = s.substring(k, j + 1);
                }
            }
        }
        
        return str;
    }
}