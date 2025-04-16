package optional.test2;

import optional.test2.api.controller.MarketController;

public class Market {
    /*
    주문 상황을 가정하고 제작

    1. 생성자로 Product 랑 User 을 임시로 제작
    2. 가상의 User 주문을 추가하고 Cart 에 Product 의 ID 를 추가함. x ea
    3. 이제 가상으로 추가한 주문내역을 확인하고 주문 시작
    4. 카트가 각각의 Product 의 price에 접근하여 각각의 가격을 계산
    5. 계산이 완료되면 유저의 money 에서 차감
    6. 주문이 끝나면 리뷰를 남길 수 있게 됨.
    7. 리뷰는 별점 + 내용이다.
    8. 리뷰를 가져와본다.

    또 하나의 추가사항
    1. 장바구니에 물건을 추가 했지만, 상품이 오래되어 상품이 삭제된 경우를 대비하여 Optional 을 사용할 것.
    2. 리뷰 또한 구매 후 리뷰를 안달수 있으므로 Optional을 사용할 수 있다.
     */
    public void start(){
        new MarketController().buyProduct(100,1,3);
    }
}
