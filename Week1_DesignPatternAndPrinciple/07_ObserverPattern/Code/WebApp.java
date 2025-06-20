// File: WebApp.java
public class WebApp implements Observer {
    private String appName;

    public WebApp(String appName) {
        this.appName = appName;
    }

    @Override
    public void update(String stockName, double price) {
        System.out.println(appName + " Web App - " + stockName + " stock updated: ₹" + price);
    }
}