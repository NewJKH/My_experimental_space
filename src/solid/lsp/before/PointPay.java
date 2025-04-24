package solid.lsp.before;

import domain.PaymentException;

public class PointPay implements Payment{
    private int point = 5000;
    @Override
    public void pay(int amount) throws PaymentException {
        if (amount > point) {
            throw new PaymentException("포인트가 부족합니다!");
        }
        point -= amount;
        System.out.println("포인트로 " + amount + "원 결제했습니다.");
    }
}
