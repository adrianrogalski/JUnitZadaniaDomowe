import java.math.BigDecimal;

public class CurrencyPair {
    private BigDecimal amount;
    private BigDecimal spread;
    private BigDecimal conversionFactor;

    public CurrencyPair(double spread, double conversionFactor) {
        // spread jest wartoscia procentowa
        // conversion factor jest liczba
        this.spread = BigDecimal.valueOf(spread);
        this.conversionFactor = BigDecimal.valueOf(conversionFactor);
    }

    public double sell(double inputAmount) {
        BigDecimal amount = BigDecimal.valueOf(inputAmount);
        BigDecimal sellValue = amount.multiply(conversionFactor).subtract(spread.divide(BigDecimal.valueOf(100)).multiply(amount));
        return sellValue.doubleValue();
    }

    public double buy(double inputAmount) {
        BigDecimal amount = BigDecimal.valueOf(inputAmount);
        BigDecimal purchaseValue = amount.divide(conversionFactor).add(spread.divide(BigDecimal.valueOf(100)).multiply(amount));
        return purchaseValue.doubleValue();
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
