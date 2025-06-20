// File: StrategyPatternTest.java
public class StrategyPatternTest {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        // Using Credit Card
        context.setPaymentStrategy(new CreditCardPayment("1234-5678-9876-5432"));
        context.payAmount(2500.00);

        // Using PayPal
        context.setPaymentStrategy(new PayPalPayment("user@example.com"));
        context.payAmount(1500.00);
    }
}
