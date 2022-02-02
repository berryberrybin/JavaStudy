package ex0128.MVC;

/*
Controller
View 와 Model 사이에서 중간 역할
    : 사용자의 요청을 받아 그에 해당하는 서비스를 호출하고,
      호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
    : return 타입이 void
 */
public class ElectronicsController {

    private ElectronicsService service = ElectronicsService.getInstance();
    // -service 0..1 의미 (private 형태, 변수명 service, ElectronicsService를 멤버 필드로 갖고 있음

    // ElectronicsController()
    /* public 형태 constructor(생성자)가 클래스다이어그램에 적혀있지만
       1개이므로 자동생성하도록 직접 생성하지 않아도 됨)
     */

    /**
     * 전자제품 등록
     */
    public void insert(Electronics electronics) {
        if (service.searchByModelNo(electronics.getModelNo()) == null) { // 같은 제품코드 있는지 확인
            if (service.insert(electronics)) {
                EndView.printMessage(" >> 제품이 등록되었습니다.");
            } else {
                EndView.printMessage(" >> 배열 크기에 벗어나 제품등록에 실패하였습니다. ");
            }
        } else {
            EndView.printMessage(" >> 중복된 제품코드로 등록에 실패하였습니다. ");
        }
    }

    /**
     * 전체검색
     */
    public void selectAll() {
        EndView.printAll(service.selectAll());
    }

    /**
     * 모델번호에 해당하는 전자제품 검색
     */
    public void searchByModelNo(int modelNo) {
        EndView.printSearchByModelNo(service.searchByModelNo(modelNo));
    }

    /**
     * 모델번호에 해당하는 전자제품 수정하기
     */
    public void update(Electronics electronics) {
        if (service.update(electronics)) {
            EndView.printMessage(" >> 제품설명이 수정되었습니다.");
        } else {
            EndView.printMessage(" >> 제품설명 수정을 실패하였습니다. ");
        }
    }

    public void bestElectronics() {
        EndView.printBestElectronics(service.getRankArrayOrderByViewCount(), service.elecArr);
    }

    /**
     * 사용자가 요청하는 기준으로 전자제품 정렬하기
     *
     * @param menu
     */
    public void sortElectronics(int menu) {
        if (menu == 1) {
            service.sortByModelNo();
            System.out.println(" >> 모델번호순으로 정렬되었습니다.");
        } else if (menu == 2) {
            service.sortByModelName();
            System.out.println(" >> 모델이름순으로 정렬되었습니다.");
        } else if (menu == 3) {
            service.sortByModelPrice();
            System.out.println(" >> 가격순으로 정렬되었습니다.");
        } else {
            EndView.printMessage(" >> 정렬메뉴를 잘못 선택하였습니다. ");
        }
        EndView.printAll(service.elecArr);
    }
}