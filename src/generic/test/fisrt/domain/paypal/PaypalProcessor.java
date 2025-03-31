package generic.test.fisrt.domain.paypal;

import generic.test.fisrt.domain.base.PaymentMethod;
import generic.test.fisrt.domain.base.PaymentProcessor;

public class PaypalProcessor
        implements PaymentProcessor<PayPal>,PaymentMethod {
    @Override
    public void processPayment(PayPal payment) {
        System.out.println(" 페이팔 이메일 : "+payment.email());
        System.out.println(" 페이팔 비번 : "+payment.password());
    }

    @Override
    public Class<PayPal> getPaymentType() {
        return PayPal.class;
    }

    @Override
    public void pay() {
        System.out.println(" 페이팔로 결제 한다.");

    }
}
