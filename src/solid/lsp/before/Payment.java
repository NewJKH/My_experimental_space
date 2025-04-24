package solid.lsp.before;

import domain.PaymentException;

public interface Payment {
    void pay(int amount) throws PaymentException;
}
