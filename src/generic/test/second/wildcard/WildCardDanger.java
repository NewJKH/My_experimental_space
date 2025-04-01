package generic.test.second.wildcard;

public class WildCardDanger {
/*
 *  이렇게 할 경우 오류가 발생한다.
 *  이유는 Object 가 모든 값에 대해서 상위 계층에 있지만
 *  제네릭은 타입이 "정확히" 일치해야한다는 점이다.
 *
 *
 */
//    public WildCardDanger() {
//        List<Integer> intList = new ArrayList<>(Arrays.asList(1,2,3));
//        List<String> strList = new ArrayList<>(Arrays.asList("4","5","6"));
//
//        printList(intList);
//        printList(strList);
//    }
//
//    public void printList(List<Object> list){
//        System.out.println(list);
//    }





}
