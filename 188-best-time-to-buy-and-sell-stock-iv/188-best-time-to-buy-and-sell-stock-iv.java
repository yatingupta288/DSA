class Solution {
    public int maxProfit(int k, int[] prices) {
        if(k > prices.length/2){
            return quicksolve(prices);
        }
        int buy[][] = new int[prices.length][k + 1];
        int sell[][] = new int[prices.length][k + 1];
        buy[0][0] = -prices[0]; 
        for(int i = 1; i < prices.length; i++){
            buy[i][0] = Math.max(buy[i - 1][0], -prices[i]);
        }
        for(int j = 1; j <= k; j++){
            buy[0][j] = -prices[0];
        }
        for(int i = 1; i < prices.length; i++){
            for(int j = 1; j <= k; j++){
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Math.max(buy[prices.length - 1][k] , sell[prices.length - 1][k]);
    }
    
    public int quicksolve(int[]  prices){
        int profit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] < prices[i]){
                profit += prices[i] - prices[i - 1];
            }
        }
        
        return profit;
    }
}