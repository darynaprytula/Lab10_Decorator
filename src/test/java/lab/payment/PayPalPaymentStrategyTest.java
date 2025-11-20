package lab.payment;

import lab.store.payment.PayPalPaymentStrategy;
import lab.store.payment.Payment;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

class PayPalPaymentStrategyTest {

    @Test
    void throwExceptionWhenPriceIsZero() {
        Payment payment = new PayPalPaymentStrategy();

        assertThrows(UnsupportedOperationException.class, () -> {
            payment.pay(0);
        }, "price is 0");
    }

    @Test
    void throwExceptionWhenPriceIsNegative() {
        Payment payment = new PayPalPaymentStrategy();

        assertThrows(UnsupportedOperationException.class, () -> {
            payment.pay(-50);
        }, "price is negative");
    }

    @Test
    void shouldPrintSuccessMessageWhenPriceIsPositive() {
        Payment payment = new PayPalPaymentStrategy();

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));

        payment.pay(250.0);

        String output = outputStream.toString()
                                    .trim();
        assertTrue(output.contains("successfull payment with paypal! sum 250.0"));

        System.setOut(System.out);
    }
}
