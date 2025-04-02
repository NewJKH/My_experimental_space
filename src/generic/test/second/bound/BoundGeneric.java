package generic.test.second.bound;

import generic.test.first.domain.base.Payment;
import generic.test.first.domain.base.PaymentMethod;

public class BoundGeneric <T extends Payment & Comparable<T> & PaymentMethod>{
    private T t;

    public BoundGeneric(T t) {
        this.t = t;
    }
    public void print(){
        t.getAmount(); // 이건 Payment
        t.pay(); // 이건 PaymentMethod
        t.compareTo(t); // 이건 Comparable
       
    }
}
