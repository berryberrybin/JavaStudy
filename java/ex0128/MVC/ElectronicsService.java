package ex0128.MVC;

public class ElectronicsService {
    public static int count; // 배열방에 저장된 전자제품의 개수를 체크

    private String[][] data = new String[][]{ // 최초의 초기 데이터 준비
            {"100", "선풍기", "35000", "삼성 선풍기"},
            {"200", "전자렌지", "55000", "잘 데워져요.."},
            {"300", "에어컨", "5500000", "무풍 에어컨 너무 시원해"},
            {"400", "냉장고", "800000", "LG 냉장고"},
            {"500", "드라이기", "9000", "LG 드라이기"}
    };
    private static ElectronicsService instance = new ElectronicsService(); // 다이어그램에서  "- instance" 자기자신을 가리키고 있음

    Electronics elecArr[]; // ~elecArr 0..* 의미 (~제한자 없음, 변수명 elecArr, 배열형태

    //외부에서 객체 생성안됨 - 배열 elecArr 에 String타입이 아닌 객체형태로 저장
    private ElectronicsService() {
        elecArr = new Electronics[10];

        for (int i = 0; i < data.length; i++) {
            elecArr[i] = new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]), data[i][3]);
            //생성자 Electronics(int,String,int,String) 호출됨
            ElectronicsService.count++;
        }
        System.out.println("--------- 초기 data 배열에 저장 되었는지 확인 체크 -------------");
        for(int i=0;i<ElectronicsService.count;i++){
            System.out.println(elecArr[i] +"|"+ elecArr[i].getModelNo()+"|"+elecArr[i].getModelName());
        }
    }

    // 현재 객체를 리턴해줌 (싱글톤 생성 의도)
    public static ElectronicsService getInstance() {
        return instance;
    }


    /**
     * 전자제품 등록
     *
     * @return : true 이면 등록성공, false이면 등록 실패
     */
    public boolean insert(Electronics electronics) {
        return false;
    }

    /**
     * 등록된 전체 전자제품 검색
     *
     * @return
     */
    public Electronics[] selectAll() {
        return null;
    }

    /**
     * 모델번호에 해당하는 전자제품 검색
     *
     * @return
     */

    public Electronics searchByModelNo(int modelNo) {
        return null;
    }


    /**
     * 모델번호에 해당하는 전자제품 설명만 수정하기
     *
     * @param electronics
     * @return
     */
    public boolean update(Electronics electronics) {
        return false;
    }
}
