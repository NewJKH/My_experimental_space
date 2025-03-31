package generic.test.fisrt.factory;

import generic.test.fisrt.domain.base.Payment;
import generic.test.fisrt.domain.base.PaymentProcessor;
import generic.test.fisrt.domain.credit.CreditCardProcessor;
import generic.test.fisrt.domain.paypal.PaypalProcessor;

import java.util.HashMap;
import java.util.Map;

public class PaymentProcessorFactory {
    private final Map<Class<? extends Payment>, PaymentProcessor<?>> registry = new HashMap<>();

    public PaymentProcessorFactory() {
        registerProcessor(new CreditCardProcessor());
        registerProcessor(new PaypalProcessor());
    }

    public <T extends Payment> void registerProcessor(PaymentProcessor<T> processor) {
        registry.put(processor.getPaymentType(), processor);
    }

    @SuppressWarnings("unchecked")
    public <T extends Payment> PaymentProcessor<T> getProcessor(Class<T> paymentClass) {
        return (PaymentProcessor<T>) registry.get(paymentClass);
    }
}
