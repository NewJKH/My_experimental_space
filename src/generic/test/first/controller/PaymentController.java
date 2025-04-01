package generic.test.first.controller;

import generic.test.first.domain.base.PaymentProcessor;
import generic.test.first.domain.credit.CreditCard;
import generic.test.first.domain.paypal.PayPal;
import generic.test.first.domain.service.PaymentService;
import generic.test.first.factory.PaymentProcessorFactory;

public class PaymentController {
    public void pay(){
        PaymentProcessorFactory factory = new PaymentProcessorFactory();

        CreditCard card = new CreditCard("1234-5678", "12/25");
        PaymentProcessor<CreditCard> ccProcessor = factory.getProcessor(CreditCard.class);
        PaymentService<CreditCard> ccService = new PaymentService<>(card, ccProcessor);
        ccService.process();

        PayPal payPal = new PayPal("paypal@example.com", "secret123");
        PaymentProcessor<PayPal> ppProcessor = factory.getProcessor(PayPal.class);
        PaymentService<PayPal> ppService = new PaymentService<>(payPal, ppProcessor);
        ppService.process();

    }

}
