package generic.test.fisrt.controller;

import generic.test.fisrt.domain.base.PaymentProcessor;
import generic.test.fisrt.domain.credit.CreditCard;
import generic.test.fisrt.domain.paypal.PayPal;
import generic.test.fisrt.domain.service.PaymentService;
import generic.test.fisrt.factory.PaymentProcessorFactory;

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
