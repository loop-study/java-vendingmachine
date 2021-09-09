package view;

import java.util.Objects;
import java.util.Scanner;

public class InputView {
    private static final Integer MIN_BALANCE = 100;
    private static final Integer BALANCE_UNIT = 10;
    private static final Integer MIN_AMOUNT = 100;
    private static final Integer AMOUNT_UNIT = 10;

    private static final String INPUT_BALANCE_MESSAGE = "자판기가 보유하고 있는 금액을 입력해주세요.";
    private static final String INPUT_DRINK_MESSAGE = "상품명과 수량, 금액을 입력해주세요.";
    private static final String INPUT_AMOUNT_MESSAGE = "투입 금액을 입력해주세요.";
    private static final String INPUT_DRINK_NAME_MESSAGE = "구매할 상품명을 입력해주세요.";

    private static final String ERROR_AMOUNT_UNIT = "투입 금액은 10원 단위로 입력해주세요.";
    private static final String ERROR_MIN_AMOUNT = "투입 금액은 100원 이상입니다.";
    private static final String ERROR_BALANCE_UNIT = "자판기 잔액은 10원 단위로 입력해주세요.";
    private static final String ERROR_MIN_BALANCE = "자판기 잔액은 100원 이상입니다.";
    private static final String ERROR_INPUT_DRINK_NULL = "빈 값은 허용하지 않습니다.";

    private final Scanner scanner;

    public InputView() {
        this.scanner = new Scanner(System.in);
    }

    public Integer inputVendingMachineBalance() {
        System.out.println(INPUT_BALANCE_MESSAGE);
        Integer result = scanner.nextInt();
        scanner.nextLine();
        validationBalance(result);
        return result;
    }

    public String inputDrinkText() {
        System.out.println();
        System.out.println(INPUT_DRINK_MESSAGE);
        String result = scanner.nextLine();
        validationStringText(result);
        return result;
    }

    public Integer inputAmount() {
        System.out.println();
        System.out.println(INPUT_AMOUNT_MESSAGE);
        Integer result = scanner.nextInt();
        scanner.nextLine();
        validationAmount(result);
        return result;
    }

    public String inputDrinkName() {
        System.out.println(INPUT_DRINK_NAME_MESSAGE);
        String result = scanner.nextLine();
        validationStringText(result);
        return result;
    }

    private void validationAmount(Integer result) {
        if (result % AMOUNT_UNIT >= 1) {
            throw new IllegalArgumentException(ERROR_AMOUNT_UNIT);
        }

        if (result < MIN_AMOUNT) {
            throw new IllegalArgumentException(ERROR_MIN_AMOUNT);
        }
    }

    private void validationStringText(String result) {
        if (Objects.isNull(result) || result.isEmpty()) {
            throw new IllegalArgumentException(ERROR_INPUT_DRINK_NULL);
        }
    }

    private void validationBalance(Integer result) {
        if (result % BALANCE_UNIT >= 1) {
            throw new IllegalArgumentException(ERROR_BALANCE_UNIT);
        }

        if (result < MIN_BALANCE) {
            throw new IllegalArgumentException(ERROR_MIN_BALANCE);
        }
    }
}
