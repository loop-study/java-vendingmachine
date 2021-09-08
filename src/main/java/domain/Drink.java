package domain;

import java.util.Objects;

public class Drink {
    private static final Integer MIN_COUNT = 0;
    private static final Integer MIN_PRICE = 0;
    private static final Integer PRICE_UNIT = 10;

    private static final String ERROR_MIN_COUNT = "음료수는 0개 이상 넣어주세요.";
    private static final String ERROR_EMPTY_OR_NULL_NAME = "이름을 입력해주세요.";
    private static final String ERROR_MIN_PRICE = "가격은 0원 이상 지정해주세요.";
    private static final String ERROR_UNIT_OF_PRICE = "가격은 10원 단위로 지정해주세요.";

    private final String name;
    private final Integer count;
    private final Integer price;

//    public Drink(String text) {
//        validationEmpty(text);
//        String[] token = textProcessing(text);
//        validationSize(token);
//
//        this("11", 11, 22);
//    }

    public Drink(String name, Integer count, Integer price) {
        validationName(name);
        validationCount(count);
        validationPrice(price);

        this.name = name;
        this.count = count;
        this.price = price;
    }

    public boolean isSale() {
        return (this.count > MIN_COUNT);
    }

    public Drink sale() {
        return new Drink(this.name, (this.count - 1), this.price);
    }

    private void validationName(String name) {
        if (Objects.isNull(name) || name.isEmpty()) {
            throw new IllegalArgumentException(ERROR_EMPTY_OR_NULL_NAME);
        }
    }

    private void validationCount(Integer count) {
        if (count < MIN_COUNT) {
            throw new IllegalArgumentException(ERROR_MIN_COUNT);
        }
    }

    private void validationPrice(Integer price) {
        if (price < MIN_PRICE) {
            throw new IllegalArgumentException(ERROR_MIN_PRICE);
        }

        if ((price % PRICE_UNIT) > 0) {
            throw new IllegalArgumentException(ERROR_UNIT_OF_PRICE);
        }
    }

    private void validationEmpty(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            throw new IllegalArgumentException();
        }
    }

    private String[] textProcessing(String text) {
        return text.replace("[", "")
                .replace("]", "")
                .split(",");
    }

    private void validationSize(String[] token) {
        if (token.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    private Integer stringToInt(String text) {
        return Integer.parseInt(text);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Drink drink = (Drink) o;
        return Objects.equals(name, drink.name) && Objects.equals(count, drink.count) && Objects.equals(price, drink.price);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, count, price);
    }
}
