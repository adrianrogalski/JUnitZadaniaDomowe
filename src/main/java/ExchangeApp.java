import java.math.BigDecimal;

public class ExchangeApp {
    public static void main(String[] args) {
        CurrencyPair plnEur = new CurrencyPair(0.006,-0.25);
        double kwota = plnEur.sell(100);
        System.out.println(kwota);
    }
}
