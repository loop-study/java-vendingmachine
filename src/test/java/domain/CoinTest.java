package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

@DisplayName("동전")
public class CoinTest {

    @Test
    @DisplayName("500원 생성")
    void create500Coin() {
        //given
        int inputPrice = 500;

        //when
        Coin coin = new Coin(inputPrice);

        //then
        assertThat(coin.getPrice()).isEqualTo(inputPrice);
    }

    @Test
    @DisplayName("100원 생성")
    void create100Coin() {
        //given
        int inputPrice = 100;

        //when
        Coin coin = new Coin(inputPrice);

        //then
        assertThat(coin.getPrice()).isEqualTo(inputPrice);
    }

    @Test
    @DisplayName("50원 생성")
    void create50Coin() {
        //given
        int inputPrice = 50;

        //when
        Coin coin = new Coin(inputPrice);

        //then
        assertThat(coin.getPrice()).isEqualTo(inputPrice);
    }

    @Test
    @DisplayName("10원 생성")
    void create10Coin() {
        //given
        int inputPrice = 10;

        //when
        Coin coin = new Coin(inputPrice);

        //then
        assertThat(coin.getPrice()).isEqualTo(inputPrice);
    }
}

class Coin {
    final int price;
    int count;

    Coin(int price) {
        this.price = price;
    }

    public int getPrice() {
        return this.price;
    }
}