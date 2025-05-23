package generic.test.first.domain.credit;

import generic.test.first.domain.base.Payment;

public record CreditCard(String card, String end) implements Payment {
    @Override
    public int getAmount() {
        return 150;
    }

    @Override
    public int getCurrency() {
        return 350;
    }

    @Override
    public String getPaymentDetails() {
        return "크레딧 카드 디테일";
    }
}

