package domain;

import java.util.Random;

public class CoinGenerator implements Generator {
    private static final Random random = new Random();

    @Override
    public int randomCount(int division) {
        return random.nextInt(division + 1);
    }
}
