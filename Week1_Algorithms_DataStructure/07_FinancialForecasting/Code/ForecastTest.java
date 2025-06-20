public class ForecastTest {
    public static void main(String[] args) {
        double initial = 1000.0;
        // Example growth rates: 5%, 4%, 6% for three periods
        double[] rates = {0.05, 0.04, 0.06};

        System.out.println("🔮 Financial Forecast:");

        // Forecast after each period
        for (int i = 0; i < rates.length; i++) {
            double fv = FinancialForecast.forecastFV(initial, rates, i);
            System.out.printf("After period %d: ₹%.2f%n", i + 1, fv);
        }
    }
}
