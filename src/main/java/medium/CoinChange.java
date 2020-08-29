package medium;

public class CoinChange {

    public static void main(String[] args) {

    }

    public int coinChange(int[] coins, int amount) {

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
