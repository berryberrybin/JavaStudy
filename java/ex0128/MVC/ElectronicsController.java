package ex0128.MVC;

/*
Controller
View 와 Model 사이에서 중간 역할
    : 사용자의 요청을 받아 그에 해당하는 서비스를 호출하고,
      호출한 결과를 받아서 결과값에 따라 결과 뷰를 호출해준다.
    : return 타입이 void
 */
public class ElectronicsController {

    private ElectronicsService service ;
    // -service 0..1 의미 (private 형태, 변수명 service, ElectronicsService를 멤버 필드로 갖고 있음

    // ElectronicsController()
    /* public 형태 constructor(생성자)가 클래스다이어그램에 적혀있지만
       1개이므로 자동생성하도록 직접 생성하지 않아도 됨)
     */

    /**
     * 전자제품 등록
     */
    public void insert(Electronics electronics){

    }

    /**
     * 전체검색
     */
    public void selectAll(){

    }


    /**
     * 모델번호에 해당하는 전자제품 검색
     */
    public void searchByModelNo(int modelNo){

    }


    /**
     * 모델번호에 해당하는 전자제품 수정하기
     */
    public void update(Electronics electronics){

    }

}