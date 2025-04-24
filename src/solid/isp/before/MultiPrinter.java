package solid.isp.before;

import solid.isp.after.Faxable;
import solid.isp.after.Printable;
import solid.isp.after.Scannable;

public class MultiPrinter implements Printable, Scannable , Faxable {
    @Override
    public void print() {
        System.out.println(" 복합 프린터기 출력 ");
    }

    @Override
    public void scan() {
        System.out.println(" 복합 프린터기 스캔 ");
    }

    @Override
    public void fax() {
        System.out.println(" 복합 프린터기 팩스 ");
    }
}
