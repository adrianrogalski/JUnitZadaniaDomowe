import java.math.BigDecimal;

public class CurrencyPair {
    private BigDecimal amount;
    private BigDecimal spread;
    private BigDecimal conversionFactor;

    public CurrencyPair(double spread, double conversionFactor) {
        // spread i conversion factor muszą być wartościami dodatnimi
        if (conversionFactor < 0) {
            System.exit(1);
        }
        if (spread < 0) {
            System.exit(1);
        }
        this.spread = BigDecimal.valueOf(spread);
        this.conversionFactor = BigDecimal.valueOf(conversionFactor);
    }

    public double sell(double inputAmount) {
        // zwraca kwote w euro odpowiadajaca kwocie w zl na wejsciu
        if (inputAmount < 0) {
            System.exit(2);
        }
        BigDecimal amount = BigDecimal.valueOf(inputAmount);
        BigDecimal sellValue = amount.multiply(conversionFactor).subtract(spread.multiply(amount));
        return sellValue.doubleValue();
    }

    @Override
    public String toString() {
        return "CurrencyPair{" +
                "amount=" + amount +
                ", spread(%)=" + spread +
                ", conversionFactor=" + conversionFactor +
                '}';
    }
}
