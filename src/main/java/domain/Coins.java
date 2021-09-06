package domain;

import java.util.HashMap;
import java.util.Map;

public class Coins {
    private final Map<Coin, Integer> coins = new HashMap<>();

    public Coins() {
        Coin.of().forEach(coin -> coins.put(coin, 0));
    }

    public boolean isCoin(Coin coin) {
        return coins.containsKey(coin);
    }
}
