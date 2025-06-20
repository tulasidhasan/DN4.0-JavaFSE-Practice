// File: ObserverPatternTest.java
public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket market = new StockMarket();

        Observer mobileApp = new MobileApp("MoneyTrack");
        Observer webApp = new WebApp("InvestNow");

        market.registerObserver(mobileApp);
        market.registerObserver(webApp);

        market.setStockData("TCS", 3545.50);
        market.setStockData("Infosys", 1420.75);
    }
}
