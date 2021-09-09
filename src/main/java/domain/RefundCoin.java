package domain;

public class RefundCoin {
    private final Integer price;
    private final Integer count;

    public RefundCoin(Integer price, Integer count) {
        this.price = price;
        this.count = count;
    }

    public Integer price() {
        return price;
    }

    public Integer count() {
        return count;
    }

    public Integer totalPrice() {
        return price * count;
    }
}
