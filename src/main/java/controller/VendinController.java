package controller;

import service.VendingService;
import view.InputView;
import view.ResultView;

public class VendinController {
    private final InputView inputView;
    private final ResultView resultView;

    public VendinController() {
        this.inputView = new InputView();
        this.resultView = new ResultView();
    }

    public void run() {
        Integer vendingMachineBalance = inputView.inputVendingMachineBalance();
        String drinkText = inputView.inputDrinkText();
        Integer inputAmount = inputView.inputAmount();

        VendingService service = new VendingService(vendingMachineBalance, drinkText);
        Integer minPrice = service.drinkMinPrice();

        while (inputAmount >= minPrice
            && !service.isAllSoldOut()) {
            resultView.printAmount(inputAmount);
            inputAmount = service.drinkSale(inputView.inputDrinkName(), inputAmount);
            System.out.println(inputAmount);
        }

        resultView.printReturnCoins(service.balanceRefund(inputAmount), inputAmount);
    }
}
