package solid.lsp;

import solid.lsp.before.PaymentService;
import solid.lsp.before.PointPay;

public class LSP {
    public static void main(String[] args) {
        PaymentService service = new PaymentService();
        service.processPayment(new PointPay(),10000);
    }
}
