public class Solution {
	/*
	Say you have an array for which the ith element is the price of a given stock on day i.
	 */
	
	/*
	complete at one transaction
	 */
    public int maxProfit(int[] prices) {
    	if(prices.length <= 1) return 0;
        int min = prices[0];
        int max = 0;
        for(int i=1; i<prices.length; i++) {
        	max = Math.max(max, prices[i]-min);
        	min = Math.min(min, prices[i]);
        }
        return max;
    }

    /*
    complete as many as transactions
     */
    public int maxProfitII(int[] prices) {
        if(prices.length <= 1) return 0;
        int profit = 0;
        for(int i=1; i<prices.length; i++) {
        	if(prices[i] > prices[i-1])
        		profit += prices[i] - prices[i-1];
        }
        return profit;
    }

    /*
    complete at most two transactions
    lp[i] count the max profit on the left of i
    rp[i] count the max profit on the right of i
    if left and right transaction both contains the item i,
    it means we can buy at one time transaction to get the most profit 
     */
    public int maxProfitIII(int[] prices) {
        int len = prices.length;
        if(len <= 1) return 0;
        int[] lp = new int[len];
        lp[0] = 0;
        int[] rp = new int[len];
        rp[len-1] = 0;
        int lmin = prices[0];
        for(int i=1; i<len; i++) {
        	lp[i] = Math.max(lp[i-1], prices[i]-lmin);
        	lmin = Math.min(lmin, prices[i]);
        }
        int rmax = prices[len-1];
        for(int i=len-2; i>=0; i--) {
        	rp[i] = Math.max(rp[i+1], rmax - prices[i]);
        	rmax = Math.max(rmax, prices[i]);
        }
        int profit = 0;
        for(int i=0; i<len; i++) {
        	profit = Math.max(profit, lp[i]+rp[i]);
        }
        return profit;
    }
}