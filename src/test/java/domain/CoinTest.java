package domain;

import org.assertj.core.api.Assertions;
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
        Coin coin = new Coin(500);

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