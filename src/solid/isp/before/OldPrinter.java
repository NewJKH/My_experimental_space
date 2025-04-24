package solid.isp.before;

import solid.isp.after.Printable;

public class OldPrinter implements Printable {
    @Override
    public void print() {
        System.out.println(" 오래된 프린터기 출력 ");
    }
}
