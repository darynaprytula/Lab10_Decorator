package lab.payment;

import lab.store.payment.CreditCardPaymentStrategy;
import lab.store.payment.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class CreditCardPaymentStrategyTest {

    @Test
    void throwExceptionWhenPriceIsZero() {
        Payment payment = new CreditCardPaymentStrategy();

        assertThrows(UnsupportedOperationException.class, () -> {
            payment.pay(0);
        }, "price is 0");
    }

    @Test
    void throwExceptionWhenPriceIsNegative() {
        Payment payment = new CreditCardPaymentStrategy();

        assertThrows(UnsupportedOperationException.class, () -> {
            payment.pay(-50);
        }, "price is negative");
    }

    @Test
    void shouldPrintSuccessMessageWhenPriceIsPositive() {
        Payment payment = new CreditCardPaymentStrategy();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        payment.pay(250.0);

        String output = outputStream.toString()
                                    .trim();
        assertTrue(output.contains("successfull payment by credit card! sum 250.0"));

        System.setOut(System.out);
    }
}
