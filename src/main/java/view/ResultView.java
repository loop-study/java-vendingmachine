package view;

import domain.RefundCoin;

import java.util.List;


public class ResultView {
    private static final String PRINT_AMOUNT = "남은 금액 : %d원\r\n";
    private static final String PRINT_REFUND_COIN = "%d원 - %d개\r\n";

    public void printAmount(Integer amount) {
        System.out.println();
        System.out.printf(PRINT_AMOUNT, amount);
    }

    public void printReturnCoins(List<RefundCoin> coins, Integer amount) {
        printAmount(calculaterBalance(coins, amount));
        coins.forEach(refundCoin -> printReturnCoin(refundCoin));
    }

    private void printReturnCoin(RefundCoin refundCoin) {
        System.out.printf(PRINT_REFUND_COIN, refundCoin.price(), refundCoin.count());
    }

    private Integer calculaterBalance(List<RefundCoin> coins, Integer amount) {
        Integer totalRefundPrice = coins.stream()
                .mapToInt(refundCoin -> refundCoin.totalPrice())
                .sum();
        return amount - totalRefundPrice;
    }

}
