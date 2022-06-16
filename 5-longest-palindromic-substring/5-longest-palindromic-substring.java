class Solution {
    public String longestPalindrome(String s) {
        boolean dp[][] = new boolean [s.length()][s.length()];
        String str = "";
        for(int i = 0; i < s.length(); i++){
            for(int k = 0, j = i; j < s.length(); j++, k++){
                if(i == 0){
                    dp[k][j] = true;
                }else if(i == 1){
                    if(s.charAt(k) == s.charAt(j)){
                        dp[k][j] = true;
                    }else{
                        dp[k][j] = false;
                    }
                }else{
                    if(s.charAt(k) == s.charAt(j) && dp[k + 1][j - 1] == true){
                        dp[k][j] = true;
                    }
                }
                if(dp[k][j] == true){
                    str = s.substring(k, j + 1);
                }
            }
        }
        return str;
    }
}