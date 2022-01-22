class Solution {
    public boolean winnerSquareGame(int n) {
        if(Math.ceil((double)Math.sqrt(n)) == Math.floor((double)Math.sqrt(n))){
            return true;
        }
        Boolean[] dp = new Boolean[n + 1]; 
        return helper(n, dp);
    }
    
    public boolean helper(int remain, Boolean[] dp){
        if(remain == 0)return false;
        if(remain == 1)return true;
        if(dp[remain] != null)return dp[remain];
        
        boolean winner = false;
        for(int i = 1; i <= (int)Math.sqrt(remain); i++){
            if(!helper(remain - i*i, dp)){
                winner = true;
                break;
            }
        }
        
        return dp[remain] = winner;
    }
}

// This can be solved using greedy approach:
// pseudo code ->
//     1. check if the number is perfecct square or not.
//         eg-> 4(alice wins).
//         if the number is pefect sqare then alice wins 
//         eg-> 10(alice-> 4 bob -> 4 alice-> 1 bob -> 1) bob wins.
//             but,
//             if alice would ave choosen 1 
//                 1a bob could turn 9 then bob still win so in every case bob is wining.
//         if not then check which sqaure number should alice choose in order to get her turn at last
//     2. if not then check if it is dividible by two
//     3. 