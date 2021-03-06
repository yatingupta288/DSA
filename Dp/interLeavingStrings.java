MEMOIZED
class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        HashMap<String, Boolean> map = new HashMap<>();
        return check(s1, s2, s3, map);
    }
    
    public boolean check(String s1, String s2, String s3, HashMap<String , Boolean> map){
        if(s1.length() + s2.length() != s3.length())return false;
        if(s1.isEmpty() && s2.isEmpty() && s3.isEmpty())return true;
        
        String key = s1 + "->" + s2 + "->" + s3;
        boolean first = false;
        boolean second = false;
        if(!map.containsKey(key)){
            if(!s1.isEmpty() && s1.charAt(0) == s3.charAt(0))first = check(s1.substring(1), s2, s3.substring(1), map);
            if(!s2.isEmpty() && s2.charAt(0) == s3.charAt(0))second = check(s1, s2.substring(1), s3.substring(1), map);
            map.put(key, first || second);
        }
        return map.get(key);
    }
}


//class Solution {
    
//     private boolean dfs(String s1, String s2, String s3, int i, int j, int k, boolean[][] visited){
//         if(i == s1.length() && j == s2.length()) return true;
//         if(i > s1.length() || j > s2.length()) return false;
//         if(visited[i][j]) return false;
//         visited[i][j] = true;
//         boolean a = false, b = false;
//         if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
//             a = dfs(s1, s2, s3, i+1, j, k+1, visited);
//         }
//         if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
//             b = dfs(s1, s2, s3, i, j+1, k+1, visited); 
//         }   
//         return a || b;
//     }
    
//     public boolean isInterleave(String s1, String s2, String s3) {
//         if(s3.length() < (s1.length() + s2.length()) || s3.length() > (s1.length() + s2.length())) return false;
//         boolean[][] visited = new boolean[s1.length()+1][s2.length()+1];
//         return dfs(s1, s2, s3, 0, 0, 0, visited);
//     }
// }

DP SOL.
// class Solution {
    
//         public boolean isInterleave(String s1, String s2, String s3) {
//         int m = s1.length(), n = s2.length();
//         if (m + n != s3.length()) return false;

//         // initializaion
//         boolean[][] dp = new boolean[m + 1][n + 1];
//         dp[0][0] = true;

//         // function
//         for (int i = 0; i <= m; i++) {
//             for (int j = 0; j <= n; j++) {
//                 if (i > 0 && s1.charAt(i - 1) == s3.charAt(i + j - 1)) {
//                     dp[i][j] |= dp[i - 1][j];
//                 }
//                 if (j > 0 && s2.charAt(j - 1) == s3.charAt(i + j - 1)) {
//                     dp[i][j] |= dp[i][j - 1];
//                 }
//             }
//         }

//         return dp[m][n];
//     }
// }