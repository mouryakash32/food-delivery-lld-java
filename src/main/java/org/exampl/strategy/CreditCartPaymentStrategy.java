package org.exampl.strategy;

public class CreditCartPaymentStrategy implements PaymentStrategy {
    private String cardNumber;

    public CreditCartPaymentStrategy(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid Rs: "+ amount+ " using Credit Card (" + cardNumber+ ")");
    }
}
