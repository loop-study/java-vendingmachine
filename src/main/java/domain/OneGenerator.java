package domain;

public class OneGenerator implements Generator {
    @Override
    public int randomCount(int division) {
        return 1;
    }
}
