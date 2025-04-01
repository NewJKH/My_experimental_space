package generic.test.first.domain.credit;

import generic.test.first.domain.base.PaymentProcessor;

public class CreditCardProcessor
        implements PaymentProcessor<CreditCard> {

    @Override
    public void processPayment(CreditCard payment) {
        System.out.println(" 크레딧 카드 :" +payment.card());
        System.out.println(" 크레딧 만료일:" +payment.end());
    }

    @Override
    public Class<CreditCard> getPaymentType() {
        return CreditCard.class;
    }

    @Override
    public void pay() {
        System.out.println("크레딧 카드를 사용해서 결제");
    }
}
