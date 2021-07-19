import java.math.BigDecimal;

public class CurrencyPair {
    private static final String ERROR_ILLEGAL_SPREAD = "Spread musi być większy bądź równy 0";
    private static final String ERROR_ILLEGAL_FACTOR = "Przelicznik musi być większy od 0";
    private static final String ERROR_ILLEGAL_AMOUNT = "Kwota musi być większa od 0";
    private BigDecimal amount;
    private BigDecimal spread;
    private BigDecimal conversionFactor;
    private String error = "";

    public CurrencyPair(double spread, double conversionFactor) {
        // spread i conversion factor muszą być wartościami dodatnimi
            // modyfikuje pole error gdy tak nie jest
            if (conversionFactor < 0) {
                // throw new
                error = ERROR_ILLEGAL_FACTOR;
            }
            if (spread < 0) {
                error = ERROR_ILLEGAL_SPREAD;
            }
            this.spread = BigDecimal.valueOf(spread);
            this.conversionFactor = BigDecimal.valueOf(conversionFactor);
        }


        public double sell(double inputAmount){
            // zwraca kwote w 2 walucie odpowiadajacej kwocie waluty 1
            if (inputAmount < 0) {
                error = ERROR_ILLEGAL_AMOUNT;
                return -1;
            }
            BigDecimal amount = BigDecimal.valueOf(inputAmount);
            BigDecimal sellValue = amount.multiply(conversionFactor).subtract(spread.multiply(amount));
            return sellValue.doubleValue();
        }

        // getError
        public String error () {
            return error;
        }

        public boolean isError () {
            return !error.isEmpty();
        }
}