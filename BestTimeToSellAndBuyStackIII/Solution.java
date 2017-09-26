package BestTimeToSellAndBuyStackIII;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices.length<1)
            return 0;
        return helper(prices);
        
    }
    private int helper(int[] prices){
        int n = prices.length;
        int[] profit = new int[n];
        int min = prices[0];
        for(int i=1; i<n; i++){
            if(prices[i]<min){
                min = prices[i];
                profit[i] = profit[i-1];
            }else{
                profit[i] = Math.max(prices[i] - min, profit[i-1]);
            }
        }
        int[] profitP = new int[n];
        int max = prices[n-1];
        for(int i=n-2; i>=0; i--){
            if(max<prices[i]){
                //profitP[i] = 0;
                //profitP[i+1] = profitP[i+1]+prices[i]-max;
                max = prices[i];
                profitP[i] = profitP[i+1];
            }else{
                profitP[i] = Math.max(max-prices[i], profitP[i+1]);
            }
        }
        int maxProfit = 0;
        for(int i=0; i<n-1; i++){
            int temp = profit[i]+profitP[i+1];
            maxProfit = Math.max(maxProfit, temp);
        }
        maxProfit = Math.max(maxProfit, profit[n-1]);
        return maxProfit;
    }
    public static void main(String[] args){
    	Solution sol = new Solution();
    	int[] prices = {3,2,6,5,0,3};
    	System.out.println(sol.maxProfit(prices));
    }
}