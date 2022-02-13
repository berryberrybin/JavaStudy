package ex0210.mvc;


import java.util.List;

/**
 * View와 Model 사이에서 중간 역할
 * : 사용자의 요청을 받아서 그에 해당하는 서비스를 호출하고
 * 호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
 */

class ElectronicsController {
    private ElectronicsService service = ElectronicsService.getInstance(); // null

    /**
     * 전체검색
     */
    public void selectAll() {
        List<Electronics> elecArr = service.selectAll();

        EndView.printAll(elecArr);
    }


    /**
     * 전자제품 등록
     */


    public void insert(Electronics electronics) {
        // 등록전에 중복여부를 체크하고 중복이 아니면 등록한다.

        try {
            Electronics savedElec = service.searchByModelNo(electronics.getModelNo());
            EndView.printMessage(electronics.getModelNo() + "중복이므로 등록할 수 없습니다.");
        } catch (SearchNotFoundException e) {
            try {
                service.insert(electronics);
                EndView.printMessage("등록되었습니다");
            } catch (ElectronicsArrayBoundsException ex) {
                EndView.printMessage(ex.getMessage());
            }
        }


    }

    /**
     * 모델번호에 해당하는 전자제품 검색
     *
     * @param modelNo
     */
    public void searchByModelNo(int modelNo) {
        try {
            Electronics electronics = service.searchByModelNo(modelNo);
            EndView.printSearchByModelNo(electronics);
        } catch (SearchNotFoundException e) {
            EndView.printMessage(e.getMessage());
        }
    }

    /**
     * 모델번호에 해당하는 전자제품 수정하기
     *
     * @param electronics
     */
    public void update(Electronics electronics) {
        try {
            service.update(electronics);
            EndView.printMessage(electronics.getModelNo() + "에 해당하는 상품 정보가 수정되었습니다.");
        } catch (SearchNotFoundException e) {
            EndView.printMessage(e.getMessage());
        }
    }


}
