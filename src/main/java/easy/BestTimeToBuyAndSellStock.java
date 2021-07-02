package easy;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
public class BestTimeToBuyAndSellStock {

    public static void main(String[] args) {

    }

    /*
    What we are actually doing is this: for every element, we are calculating the difference between that element and the minimum
    of all the values before that element and we are updating the maximum profit if
    the difference thus found is greater than the current maximum profit.
     */
    public static int maxProfit_v2(int[] prices) {

        int minPriceOfStock = prices[0];
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPriceOfStock) {
                minPriceOfStock = prices[i];
            } else if (prices[i] - minPriceOfStock > maxProfit) {
                maxProfit = prices[i] - minPriceOfStock;
            }
        }
        return maxProfit;

    }

    public static int maxProfit(int[] prices) {

        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;

    }

}
