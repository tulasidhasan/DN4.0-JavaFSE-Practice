// File: DecoratorPatternTest.java
public class DecoratorPatternTest {
    public static void main(String[] args) {
        // Base notifier (only email)
        Notifier emailNotifier = new EmailNotifier();
        
        // Add SMS notification
        Notifier smsEmailNotifier = new SMSNotifierDecorator(emailNotifier);
        
        // Add Slack on top of SMS + Email
        Notifier fullNotifier = new SlackNotifierDecorator(smsEmailNotifier);

        // Send notification
        fullNotifier.send("Your order has been shipped!");
    }
}
