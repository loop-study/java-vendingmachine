package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class DrinksTest {

    @Test
    @DisplayName("입력된 문자로 음료수 생성")
    void createDrink() {
        //given
        String text = "[사이다,20,2000]";
        Drink sodaPop = new Drink("사이다", 20, 2000);

        //when
        List<Drink> drinks = new Drinks(text).drinks();

        //then
        assertThat(drinks.contains(sodaPop)).isTrue();
    }

    @Test
    @DisplayName("입력된 문자로 음료수 여러개 생성")
    void createDrinks() {
        //given
        String text = "[사이다,20,2000];[콜라,10,1000];[환타,30,3000]";

        //when
        List<Drink> drinks = new Drinks(text).drinks();

        //then
        assertThat(drinks.size()).isEqualTo(3);
    }

    @DisplayName("잘못된 문자 예외 확인")
    @NullAndEmptySource
    @ParameterizedTest
    void negativeText(String text) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new Drinks(text));
    }

    @DisplayName("음료수 찾기")
    @ValueSource(strings = {"사이다", "콜라", "환타"})
    @ParameterizedTest
    void findDrink(String name) {
        // given
        String text = "[사이다,20,2000];[콜라,10,1000];[환타,30,3000]";
        Drinks drinks = new Drinks(text);

        // when
        Drink drink = drinks.findDrink(name);

        // then
        assertThat(drink.isEqualName(name)).isTrue();
    }

    @DisplayName("모든 음료 판매 여부 확인")
    @Test
    void allSoldOut() {
        // given
        String text = "[사이다,0,2000];[콜라,0,1000];[환타,0,3000]";
        Drinks drinks = new Drinks(text);

        // the
        assertThat(drinks.isAllSoldOut()).isTrue();
    }


}



