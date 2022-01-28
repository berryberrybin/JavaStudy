package ex0128.MVC;

public class ElectronicsService {
    public static int count; // 배열방에 저장된 전자제품의 개수를 체크
    private String[][] date; // 최초의 초기 데이터 준비

    private ElectronicsService instance; // 다이어그램에서  "- instance" 자기자신을 가리키고 있음

    Electronics elecArr[]; // ~elecArr 0..* 의미 (~제한자 없음, 변수명 elecArr, 배열형태

    //외부에서 객체 생성안됨
    private ElectronicsService(){

    }

    // 현재 객체를 리턴해줌 (싱글톤 생성 의도)
    public static ElectronicsService getInstance(){
        return null;
    }


    /**
     * 전자제품 등록
     * @return : true 이면 등록성공, false이면 등록 실패
     */
    public boolean insert(Electronics electronics){
        return false;
    }

    /**
     * 등록된 전체 전자제품 검색
     * @return
     */
    public Electronics[] selectAll(){
        return null;
    }

    /**
     * 모델번호에 해당하는 전자제품 검색
     * @return
     */

    public Electronics searchByModelNo(int modelNo){
        return null;
    }


    /**
     * 모델번호에 해당하는 전자제품 설명만 수정하기
     * @param electronics
     * @return
     */
    public boolean update(Electronics electronics){
        return false;
    }
}
