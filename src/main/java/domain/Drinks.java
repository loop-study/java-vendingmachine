package domain;

import java.util.*;
import java.util.stream.Collectors;

public class Drinks {
    private static final String ERROR_TEXT = "입력된 문자가 없습니다.";

    private final List<Drink> drinks;

    public Drinks(String text) {
        validationEmpty(text);
        this.drinks = createDrinks(text);
    }

    public Drinks(List<Drink> drinks) {
        this.drinks = drinks;
    }

    public Integer minPrice() {
        return drinks.stream()
                .mapToInt(drink -> drink.price())
                .min()
                .getAsInt();
    }

    public Drink findDrink(String name) {
        return drinks.stream()
                .filter(drink -> drink.isEqualName(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public List<Drink> drinks() {
        return Collections.unmodifiableList(drinks);
    }

    public Integer drinkSale(String drinkName, Integer amount) {
        Drink selectDrink = findDrink(drinkName);

        if (!selectDrink.isSoldOut()) {
            return amount;
        }

        if (!selectDrink.isSale(amount)) {
            return amount;
        }

        drinks.set(drinks.indexOf(selectDrink), selectDrink.sale());
        return amount - selectDrink.price();
    }

    private void validationEmpty(String text) {
        if (Objects.isNull(text) || text.isEmpty()) {
            throw new IllegalArgumentException(ERROR_TEXT);
        }
    }

    private List<Drink> createDrinks(String text) {
        String[] textArray = text.split(";");
        return Arrays.stream(textArray)
                .map(tokens -> textToDrink(tokens))
                .collect(Collectors.toList());
    }

    private Drink textToDrink(String text) {
        String[] tokens = text.replace("[", "")
                .replace("]", "")
                .split(",");

        validationTokenSize(tokens);

        return new Drink(
                tokens[0],
                stringToInt(tokens[1]),
                stringToInt(tokens[2])
        );
    }

    private void validationTokenSize(String[] token) {
        if (token.length != 3) {
            throw new IllegalArgumentException();
        }
    }

    private Integer stringToInt(String text) {
        return Integer.parseInt(text);
    }

    public boolean isAllSoldOut() {
        return drinks.stream()
                .noneMatch(Drink::isSoldOut);
    }
}
