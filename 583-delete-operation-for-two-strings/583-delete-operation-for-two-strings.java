class Solution {
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int dp[][] = new int[n + 1][m + 1];
        for(int i = 0; i < n + 1; i++){
            for(int j = 0; j < m + 1; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }else if(word1.charAt(i - 1) == word2.charAt(j - 1)){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int common = dp[n][m];
        System.out.print(common + " ");
        int ans = word1.length() - common + word2.length() - common;
        return ans;
    }
}


// public int minDistance(String word1, String word2) {
//         int arr[] = new int[26];
//         for(char ch : word1.toCharArray()){
//             arr[ch - 'a']--;
//         }
        
//         for(char ch : word2.toCharArray()){
//            if(arr[ch - 'a'] < 0){
//                arr[ch - 'a']++;
//            }else{
//                arr[ch - 'a']++;
//            }
//         }
//         int ans = 0;
//         for(int i = 0; i < arr.length; i++){
//             if(arr[i] > 0){
//                 ans += arr[i];
//             }else if(arr[i] < 0){
//                 ans -= arr[i]; 
//             }
//         }
        
//         return ans;
//     }