import java.math.BigDecimal;

public class ExchangeApp {
    public static void main(String[] args) {

        CurrencyPair plnEur = new CurrencyPair(0.1,0.27);
        double kwota = plnEur.sell(100);
        System.out.println(kwota);
    }
}
