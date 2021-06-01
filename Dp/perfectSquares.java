// LEGENDER'S THEOREM
class Solution {
    public int numSquares(int n) {
        if(n == 0){
            return 0;
        }
        
        if((int)Math.sqrt(n) * (int)Math.sqrt(n) == n){
            return 1;
        }
        
        for(int i = 1; i <= Math.sqrt(n); i++){
            int x = n - i * i;
            if((int)Math.sqrt(x) * (int)Math.sqrt(x) == x){
                return 2;
            }
        }
        
        while(n % 4 == 0){
            n >>= 2;
        }
        if(n % 8 == 7){
            return 4;
        }
        
        return 3;
    }
}
// RECURSIVE: MEMOIZED
//         public int numSquares(int n) {
//         int memo[] = new int[n + 1];
//         return rec(n, memo);
//     }
    
//     public int rec(int n, int[] memo){
//         if(n < 0){
//             return Integer.MAX_VALUE;
//         }
//         if(n == 0){
//             return 0;
//         }
//         if(memo[n] > 0)return memo[n];
//         int min = n;
//         for(int i = 1; i * i <= n; i++){
//             min = Math.min(min, rec(n - (i * i), memo));
//         }
//         memo[n] = min + 1;
//         return min + 1;
//     }

// ITEREATIVE :
//         public int numSquares(int n) {
//         int dp[] = new int[n + 1];
//         dp[0] = 0;
//         dp[1] = 1;
        
//         for(int i = 2; i <= n; i++){
//             int min = Integer.MAX_VALUE;
//             for(int j = 1; j * j <= i; j++){
//                 int rem = i - j * j;
//                 if(min > dp[rem]){
//                     min = dp[rem];
//                 }
//             }
//             dp[i] = min + 1;
//         }
//         return dp[n];
//     }