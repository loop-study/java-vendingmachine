package domain;

import java.util.HashMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins = new HashMap<>();
    private final Generator generator;

    public Coins(Generator generator) {
        this.generator = generator;
        Coin.of().forEach(coin -> coins.put(coin, 0));
    }

    public boolean isContainCoin(Coin coin) {
        return coins.containsKey(coin);
    }

    public void createCoins(int price) {
        for (Coin coin : coins.keySet()) {
            price -= this.createCoin(coin, price);
        }

        if (price > 0) {
            createCoins(price);
        }
    }

    public int createCoin(Coin coin, int price) {
        int division = price / coin.price();
        int minusPrice = 0;
        if (division >= 1) {
            int count = generator.randomCount(division);
            coins.put(coin, (count + coins.get(coin)));
            minusPrice =  count * coin.price();
        }

        return minusPrice;
    }

    public int coinCount(Coin coin) {
        return coins.get(coin);
    }
}




