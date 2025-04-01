package generic.test.first.domain.paypal;

import generic.test.first.domain.base.Payment;

public record PayPal(String email, String password) implements Payment {
    @Override
    public int getAmount() {
        return 100;
    }

    @Override
    public int getCurrency() {
        return 300;
    }

    @Override
    public String getPaymentDetails() {
        return "페이팔 디테일";
    }
}