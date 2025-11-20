package lab.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lab.store.payment.CreditCardPaymentStrategy;
import lab.store.payment.PayPalPaymentStrategy;
import lab.store.payment.Payment;

@RestController
@RequestMapping("/payment")
public class PaymentController {

    private final Payment paypal = new PayPalPaymentStrategy();
    private final Payment creditCard = new CreditCardPaymentStrategy();

    @PostMapping("/paypal-payment")
    public String payWithPayPal(@RequestParam double price) {
        try {
            paypal.pay(price);
            return "successfull payment with paypal! sum " + price;
        } catch (UnsupportedOperationException e) {
            return "error: " + e.getMessage();
        }
    }

    @PostMapping("/creditcard-payment")
    public String payWithCreditCard(@RequestParam double price) {
        try {
            creditCard.pay(price);
            return "successfull payment by credit card! sum " + price;
        } catch (UnsupportedOperationException e) {
            return "error: " + e.getMessage();
        }
    }
}
