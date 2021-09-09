package domain;

import java.util.*;

public class Coins {
    private final Map<Coin, Integer> coins = new HashMap<>();
    private final Generator generator;

    public Coins(Generator generator) {
        this(generator, 0);
    }

    public Coins(Generator generator, Integer balance) {
        this.generator = generator;
        Coin.of().forEach(coin -> coins.put(coin, 0));
        createCoins(balance);
    }

    public boolean isContainCoin(Coin coin) {
        return coins.containsKey(coin);
    }

    public void createCoins(int balance) {
        for (Coin coin : coins.keySet()) {
            balance -= this.createCoin(coin, balance);
        }

        if (balance > 0) {
            createCoins(balance);
        }
    }

    public int createCoin(Coin coin, int balance) {
        int division = balance / coin.price();
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

    public List<RefundCoin> balanceRefund(Integer amount) {
        List<RefundCoin> refundCoins = new ArrayList<>();
        List<Coin> coinList = Coin.of();
        Collections.sort(coinList, (a,b) -> b.price() - a.price());

        for (Coin coin : coinList) {
            amount = addRefundCoin(refundCoins, coin, amount);
        }

        return refundCoins;
    }

    private Integer addRefundCoin(List<RefundCoin> refundCoins, Coin coin, Integer amount) {
        if (isCoinWithBalance(coin, amount)) {
            RefundCoin refundCoin = createRefundCoin(coin, amount);
            amount -= refundCoin.totalPrice();
            refundCoins.add(refundCoin);
        }
        return amount;
    }

    private boolean isCoinWithBalance(Coin coin, Integer amount) {
        return coins.get(coin) > 0
                && amount / coin.price() > 1;
    }

    private RefundCoin createRefundCoin(Coin coin, Integer amount) {
        return new RefundCoin(
                coin.price(),
                Integer.min(coins.get(coin), (amount / coin.price()))
        );
    }
}




