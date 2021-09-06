package domain;

import java.util.*;
import java.util.stream.IntStream;

public class Coin {
    private static final int[] COIN_PRICES = {500, 100, 50, 10};
    private static Map<Integer, Coin> coinCache = new HashMap<>();

    static {
        IntStream.range(0, COIN_PRICES.length)
                .forEach(i -> coinCache.put(COIN_PRICES[i], new Coin(COIN_PRICES[i])));
    }

    private final int price;

    private Coin(int price) {
        this.price = price;
    }

    public int price() {
        return this.price;
    }

    public static Coin of(int price) {
        return coinCache.get(price);
    }

    public static List<Coin> of() {
        return new ArrayList<>(coinCache.values());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coin coin = (Coin) o;
        return price == coin.price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price);
    }
}
