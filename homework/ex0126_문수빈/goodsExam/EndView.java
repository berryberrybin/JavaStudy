package goodsExam;

/**
 * 요청된 결과를 화면 출력 담당하는 클래스
 */
public class EndView {
    /**
     * 성공여부 메시지를 출력하는 메소드
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    /**
     * 전체 검색의 결과를 출력하는 메소드
     */
    public static void printSelectAll(Goods[] goodsArr) {
        System.out.println("-------상품 LIST ( " + GoodsService.count + " )개 ----------");
        for (int i = 0; i < GoodsService.count; i++) {
            System.out.print(goodsArr[i].getCode() + " ");
            System.out.print(goodsArr[i].getName() + ", ");
            System.out.print(goodsArr[i].getPrice() + "원, ");
            System.out.print(goodsArr[i].getExplain() + "\n");
        }
        System.out.println();
        // 결과 출력

    }

    /**
     * 상품코드에 해당하는 정보 출력하는 메소드
     */
    public static void printSelectByCode(Goods goods) {
        System.out.println("--------" + goods.getCode() + " 에 해당하는 정보-----");
        System.out.println("상품이름 : " + goods.getName());
        System.out.println("상품가격: " + goods.getPrice());
        System.out.println("상품설명: " + goods.getExplain());
        //정보 출력
    }
}
