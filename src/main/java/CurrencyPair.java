import java.math.BigDecimal;

public class CurrencyPair {
    private BigDecimal amount;
    private BigDecimal spread;
    private BigDecimal conversionFactor;

    public CurrencyPair(double spread, double conversionFactor) {
        // spread i conversion factor muszą być wartościami dodatnimi
        if (conversionFactor <= 0) {
            throw new IllegalArgumentException("Przelicznik musi być większy od zera!");
        }
        if (spread < 0) {
            throw new IllegalArgumentException("Spread musi być większy bądź równy zeru!");
        }
        this.spread = BigDecimal.valueOf(spread);
        this.conversionFactor = BigDecimal.valueOf(conversionFactor);
    }

    public double sell(double inputAmount) {
        // zwraca kwote w euro odpowiadajaca kwocie w zl na wejsciu
        if (inputAmount <= 0) {
            throw new IllegalArgumentException("Kwota musi być większa od 0!");
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
