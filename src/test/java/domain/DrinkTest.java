package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.Assertions.*;

public class DrinkTest {

    @Test
    @DisplayName("음료수 생성")
    void createDrink() {
        //given
        Drink drink = new Drink("사이다", 20, 2000);

        //then
        assertThat(drink).isNotNull();
    }

    @DisplayName("이름 예외 확인")
    @NullAndEmptySource
    @ParameterizedTest
    void negativeName(String name) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Drink(name, 20, 2000));
    }

    @Test
    @DisplayName("최소 개수 예외 확인")
    void negativeMinCount() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Drink("사이다", -1, 2000));
    }

    @Test
    @DisplayName("최소 가격 예외 확인")
    void nagetiveMinPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Drink("사이다", 20, -1));
    }

    @Test
    @DisplayName("가격 단위 예외 확인")
    void nagetiveUnitPrice() {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Drink("사이다", 20, 11));
    }

    @Test
    @DisplayName("음료수 판매중")
    void onSale() {
        Drink drink = new Drink("사이다", 20, 1000);

        assertThat(drink.isSale()).isTrue();
    }

    @Test
    @DisplayName("음료수 판매불가")
    void notSale() {
        Drink drink = new Drink("사이다", 0, 1000);

        assertThat(drink.isSale()).isFalse();
    }

    @Test
    @DisplayName("음료수 판매 확인")
    void drinkSale() {
        // given
        Drink beforeDrink = new Drink("사이다", 1, 1000);
        Drink checkDrink = new Drink("사이다", 0, 1000);

        // then
        Drink saleDrink = beforeDrink.sale();

        // when
        assertThat(saleDrink).isEqualTo(checkDrink);
    }
}