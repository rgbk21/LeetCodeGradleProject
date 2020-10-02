package medium;

// TODO:
// Coin change problem. Need I say more?

public class CoinChange {

    public static void main(String[] args) {
        CoinChange c = new CoinChange();
        c.coinChange(new int[] {2}, 3);
    }

    //New method
    // coins: [1,3,5]
    // coinCount: [0, 1, 2, 1, 2, 1, 2, 7, 8, 9, 10]
    public int coinChange(int[] coins, int amount){

        int[] coinCount = new int[amount + 1];

        for (int i = 1; i < coinCount.length; i++) {
            coinCount[i] = amount + 1;
        }

        for (int i = 0; i < coins.length; i++) {
            if (coins[i] < amount) {
                coinCount[coins[i]] = 1;
            }
        }

        for (int i = 0; i < coinCount.length; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    coinCount[i] = Math.min(coinCount[i], coinCount[i-coins[j]] + 1);
                }
            }
        }

        return coinCount[amount] > amount ? -1 : coinCount[amount];



    }




    // Old method that did not work

    public int coinChange_old(int[] coins, int amount) {

        int[] reqrdNumOfCoins = new int[amount + 1];

        for (int i = 0; i < coins.length; i++){
            if (coins[i] < amount) {
                reqrdNumOfCoins[coins[i]] = 1;
            }
        }

        for (int i = 1 ; i <= reqrdNumOfCoins.length; i++) {

            reqrdNumOfCoins[i] = minNumofCoinsRequiredToFormAmount(i, coins, reqrdNumOfCoins);

        }

        return reqrdNumOfCoins[amount];

    }

    private int minNumofCoinsRequiredToFormAmount(int amount, int[] coins, int[] reqrdNumOfCoins){

        int[] coinsReqrd = new int[coins.length];

        for (int i = 0; i < coins.length; i++) {
            if (amount - coins[i] >= 0) {
                coinsReqrd[coins[i]] = reqrdNumOfCoins[amount - coins[i]];
            }
        }

        int minCoinsReqrd = Integer.MAX_VALUE;

        for (int i = 0; i < coinsReqrd.length; i++){
            if (coinsReqrd[i] != 0 && coinsReqrd[i] < minCoinsReqrd) {
                minCoinsReqrd = coinsReqrd[i];
            }
        }

        return minCoinsReqrd;

    }

}
