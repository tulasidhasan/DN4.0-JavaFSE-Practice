public class FinancialForecast {
    /**
     * Recursively forecast future value after 'period+1' terms.
     *
     * @param initialAmount the starting principal
     * @param growthRates   array of growth rates (e.g., 0.05 for 5%)
     * @param period        zero-based index into growthRates:
     *                      period = 0 applies only growthRates[0], etc.
     * @return predicted value
     */
    public static double forecastFV(double initialAmount, double[] growthRates, int period) {
        // Base case: first period
        if (period == 0) {
            return initialAmount * (1 + growthRates[0]);
        }
        // Recursive case: compute previous and apply current rate
        double prevValue = forecastFV(initialAmount, growthRates, period - 1);
        return prevValue * (1 + growthRates[period]);
    }
}
