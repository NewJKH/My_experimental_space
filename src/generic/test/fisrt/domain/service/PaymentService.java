package generic.test.fisrt.domain.service;

import generic.test.fisrt.domain.base.Payment;
import generic.test.fisrt.domain.base.PaymentProcessor;

public class PaymentService<T extends Payment> {
    private final T payment;
    private final PaymentProcessor<T> processor;

    public PaymentService(T payment, PaymentProcessor<T> processor) {
        this.payment = payment;
        this.processor = processor;
    }

    public void process() {
        processor.processPayment(payment);
        processor.pay();
        info();
    }
    public void info(){
        System.out.println(" 어마운트 : "+payment.getAmount());
        System.out.println(" 커렌시 : "+payment.getCurrency());
        System.out.println(" 디테일 : "+payment.getPaymentDetails());
    }
}

