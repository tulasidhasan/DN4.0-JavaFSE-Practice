// File: AdapterPatternTest.java
public class AdapterPatternTest {
    public static void main(String[] args) {
        PaymentProcessor razorpayProcessor = new RazorpayAdapter();
        razorpayProcessor.processPayment(2500.00);

        PaymentProcessor paypalProcessor = new PayPalAdapter();
        paypalProcessor.processPayment(50.00);
    }
}
