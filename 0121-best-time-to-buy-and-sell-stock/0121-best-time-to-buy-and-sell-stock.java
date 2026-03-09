class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int maxPrice = 0;
        for(int i = 0;i < prices.length;i++){
            if(prices[i] < min){
                min = prices[i];
            }
            maxPrice = Math.max(maxPrice, prices[i] - min);
        }
        return maxPrice;
    }
}