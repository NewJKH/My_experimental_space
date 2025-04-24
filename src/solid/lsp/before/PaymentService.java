package solid.lsp.before;

public class PaymentService {
    public void processPayment(Payment payment, int amount) {
        payment.pay(amount);
    }
}
