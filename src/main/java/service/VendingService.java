package service;

import domain.*;

import java.util.List;

public class VendingService {
    private final Coins coins;
    private final Drinks drinks;

    public VendingService(Integer balance, String drinkText) {
        this(new Coins(new CoinGenerator(), balance), new Drinks(drinkText));
    }

    public VendingService(Coins coins, Drinks drinks) {
        this.coins = coins;
        this.drinks = drinks;
    }

    public Integer drinkMinPrice() {
        return drinks.minPrice();
    }

    public Integer drinkSale(String drinkName, Integer amount) {
        return drinks.drinkSale(drinkName, amount);
    }

    public Coins coins() {
        return this.coins;
    }

    public List<RefundCoin> balanceRefund(Integer balacne) {
        return coins.balanceRefund(balacne);
    }

    public boolean isAllSoldOut() {
        return drinks.isAllSoldOut();
    }
}
