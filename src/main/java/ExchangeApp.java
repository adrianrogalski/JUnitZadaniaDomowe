import java.math.BigDecimal;

public class ExchangeApp {
    public static void main(String[] args) {
        CurrencyPair plnEur = new CurrencyPair(6,0.25);
        double kwota = plnEur.buy(101);
        plnEur.sell(100);
        System.out.println(kwota);
    }
}
