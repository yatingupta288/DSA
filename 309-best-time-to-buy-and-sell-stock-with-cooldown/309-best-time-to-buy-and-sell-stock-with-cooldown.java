class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int prevsell = 0;
        int prevbuy = 0;
        for(int i = 1; i < prices.length; i++){
            prevbuy = buy;
            buy = Math.max(prevbuy, prevsell - prices[i]);
            prevsell = sell;
            sell = Math.max(prevsell, prevbuy + prices[i]);
        }
        
        return sell;
    }
}