package solid.lsp.before;

import domain.PaymentException;

public class PaymentService {
    public void processPayment(Payment payment, int amount) {
        try {
            payment.pay(amount);
        } catch (PaymentException e) {
            System.out.println("결제 실패: " + e.getMessage());
        }
    }
}
