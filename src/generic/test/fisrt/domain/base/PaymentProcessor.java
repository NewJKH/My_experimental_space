package generic.test.fisrt.domain.base;

public interface PaymentProcessor<T> extends PaymentMethod {
    void processPayment(T payment);
    Class<T> getPaymentType();
}
