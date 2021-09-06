package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CoinsTest {

    private Coins coins;

    @BeforeEach
    void setUp() {
        coins = new Coins();
    }

    @ParameterizedTest
    @ValueSource(ints = {500, 100, 50, 10})
    @DisplayName("금액별 동전 확인")
    void checkCoins(int price) {
        //given
        Coin coin = Coin.of(price);

        //then
        assertThat(coins.isCoin(coin)).isTrue();
    }
}