class Solution {
    private Integer[][] dp;
    public int change(int amount, int[] coins) {
        if (amount == 0)
            return 1;
        if (coins.length == 0)
            return 0;
        dp = new Integer[coins.length][amount + 1];
        return changeFrom(amount, coins, 0);
    }
    
    private int changeFrom(int amount, int[] coins, int currentIndex) {
        if (amount == 0)
          return 1;

        if (amount < 0 || currentIndex == coins.length)
          return 0;

        if (dp[currentIndex][amount] != null)
            return dp[currentIndex][amount];
        
        // Recursive call after selecting the coin at the currentIndex
        int sum1 = changeFrom(amount - coins[currentIndex], coins, currentIndex);

        // Recursive call after excluding the coin at the currentIndex
        int sum2 = changeFrom(amount, coins, currentIndex + 1);

        dp[currentIndex][amount] = sum1 + sum2;
        return dp[currentIndex][amount];
    }
}