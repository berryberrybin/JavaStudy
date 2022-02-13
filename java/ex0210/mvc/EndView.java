package ex0210.mvc;

import java.util.List;

/**
 * 사용자 요청에 해당하는 결과를 모니터에 출력하는 클래스
 */

class EndView {

    public static void printAll(List<Electronics> elecList) {
        System.out.println("****** 전자제품 총 (" + elecList.size() + ")개 *****************");
        for (Electronics elec : elecList) {
            System.out.println(elec);
        }
        System.out.println();
    }

    // 모델번호에 해당하는 전제제품 출력하기
    public static void printSearchByModelNo(Electronics electronics) {
        System.out.println(electronics + "\n");
    }

    /**
     * 성공 여부에 관련된 메세지 출력
     *
     * @param message
     */
    public static void printMessage(String message) {
        System.out.println(message + "\n");
    }


}
