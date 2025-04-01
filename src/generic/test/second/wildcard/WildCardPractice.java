package generic.test.second.wildcard;

import generic.single.Box;

import java.util.List;

public class WildCardPractice {
    /**
     * @param list test
     *             어떤 타입의 리스트라도 요소를 출력할 수 있다.
     *             무제한 와일드카드 - 주로 사용하는 건 읽기 전용이다.
     */
    public void print(List<?> list){
        for ( Object obj : list) System.out.println(obj);
    }

    /**
     * @param list test
     *             Number 와 그 하위 타입들만 허용한다.
     *             즉 Number 안에는 Integer, Double, Float 등등이 포함된다.
     *             상한제한 와일드카드 - 주로 사용하는 건 읽기 전용이다.
     * @return sum
     */
    public double sumNumbers(List<? extends Number> list){
        double sum = 0;
        for ( Number n : list ){
            sum+=n.doubleValue();
        }
        return sum;
    }

    /**
      * @param list test
     *             Integer 과 그 상위 타입만 허용한다.
     *             즉, 받는걸 List<Number> 로 param 을 받는다면 처리 된다.
     *             하한제한 와일드카드 - 주로 사용하는 건 쓰기 전용이다.
     */
    public void addValue(List<? super Integer> list, Object obj){

    }

    public Class<? extends Number> getValue(){
        return Integer.class;
    }

    public void cast(List<Box<?>> boxs) {
        for (Box<?> box : boxs) {
            Object value = box.getValue();
            if (value instanceof String) {
                System.out.println("String value: " + value);
            } else if (value instanceof Integer) {
                System.out.println("Integer value: " + value);
            } else if (value instanceof Double) {
                System.out.println("Double value: " + value);
            } else {
                System.out.println("Unknown type: " + value);
            }
        }
    }

}
