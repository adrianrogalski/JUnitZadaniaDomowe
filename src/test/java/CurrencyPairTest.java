import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CurrencyPairTest {

    @Test
    void currencyPairConstructorShouldTakePositiveArg() {
        // given
        double spread = 0.04;
        double conversionFactor = 0.25;

        // when
        CurrencyPair currencyPair = new CurrencyPair(spread, conversionFactor);

        //then
        Assertions.assertFalse(currencyPair.isError());
        Assertions.assertSame("", currencyPair.error());
    }

    @Test
    void currencyPairConstructorShouldNotTakeAnyNegativeSpread() {
        // given
        double spread = -0.4;
        double conversionFactor = 0.24;
        CurrencyPair currencyPair = new CurrencyPair(spread, conversionFactor);
        // then
        Assertions.assertTrue(currencyPair.isError());
        Assertions.assertSame("Spread musi być większy bądź równy 0", currencyPair.error());
    }

    @Test
    void currencyPairConstructorShouldNotTakeAnyNegativeFactor() {
        // given
        double spread = 0.4;
        double conversionFactor = -0.24;
        CurrencyPair currencyPair = new CurrencyPair(spread, conversionFactor);
        // then
        Assertions.assertTrue(currencyPair.isError());
        Assertions.assertSame("Przelicznik musi być większy od 0", currencyPair.error());
    }

    @Test
    void sellMethodShouldTakePositiveArg() {
        // given
        double spread = 0.1;
        double conversionFactor = 0.27;
        double amount = 100;
        CurrencyPair currencyPair = new CurrencyPair(spread, conversionFactor);

        // when
        double withdrawn = currencyPair.sell(amount);

        // then
        Assertions.assertEquals(17.0, withdrawn);
    }

    @Test
    void sellMethodShouldNotTakeNegativePositiveArg() {
        // given
        double spread = 0.1;
        double conversionFactor = 0.27;
        double amount = -100;
        CurrencyPair currencyPair = new CurrencyPair(spread, conversionFactor);

        // when
        double withdrawn = currencyPair.sell(amount);

        // then
        Assertions.assertTrue(currencyPair.isError());
        Assertions.assertSame("Kwota musi być większa od 0", currencyPair.error());
    }
}
