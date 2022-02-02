package ex0128.MVC;


//사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스
public class EndView {

    /**
     * 전달된 배열을 출력 (전체검색 결과)
     *
     * @param elecArr
     */
    public static void printAll(Electronics[] elecArr) {
        System.out.println();
        System.out.println("<   제품   List   >");
        for (int i = 0; i < ElectronicsService.count; i++) {
            System.out.print("제품번호: " + elecArr[i].getModelNo() + " | ");
            System.out.print("이름: " + elecArr[i].getModelName() + " | ");
            System.out.print("가격: " + elecArr[i].getModelPrice() + " | ");
            System.out.print("설명: " + elecArr[i].getModelDetail() + "\n");
        }
    }

    /**
     * 모델번호에 해당하는 전자제품 출력하기
     *
     * @param electronics
     */
    public static void printSearchByModelNo(Electronics electronics) {
        if (electronics == null) {
            System.out.println(" >> 해당 상품을 찾을 수가 없습니다. ");
        } else {
            System.out.println();
            System.out.println("<   제품번호 " + electronics.getModelNo() + " 해당 정보   >");
            System.out.print("이름: " + electronics.getModelName() + " | ");
            System.out.print("가격: " + electronics.getModelPrice() + " | ");
            System.out.print("설명: " + electronics.getModelDetail() + "\n");
        }
    }

    /**
     * 성공여부에 관련된 메시지 출력
     *
     * @param message
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }

    public static void printBestElectronics(int[] rankArr, Electronics[] elecArr) {
        System.out.println("총 조회수: " + Electronics.getTotalViewCount());
        System.out.println("------- 조회순 제품 List ----------");
        for (int rank = 0; rank < rankArr.length; rank++) {
            for (int i = 0; i < rankArr.length; i++) {
                if (rankArr[i] == rank) {
                    System.out.print("조회수> " + elecArr[i].getViewCount() + " | ");
                    System.out.print("제품번호: " + elecArr[i].getModelNo() + " | ");
                    System.out.print("이름: " + elecArr[i].getModelName() + " | ");
                    System.out.print("가격: " + elecArr[i].getModelPrice() + " | ");
                    System.out.print("설명: " + elecArr[i].getModelDetail() + "\n");
                }
            }
        }
        System.out.println();
    }
}
