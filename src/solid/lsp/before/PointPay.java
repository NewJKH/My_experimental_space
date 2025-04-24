package solid.lsp.before;

public class PointPay implements Payment{
    private int point = 5000;
    @Override
    public void pay(int amount) {
        if (amount > point) {
            throw new UnsupportedOperationException("포인트가 부족합니다!");
        }
        point -= amount;
        System.out.println("포인트로 " + amount + "원 결제했습니다.");
    }
}
