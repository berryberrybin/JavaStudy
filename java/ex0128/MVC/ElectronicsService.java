package ex0128.MVC;

public class ElectronicsService {
    public static int count; // 배열방에 저장된 전자제품의 개수를 체크

    private String[][] data = new String[][]{ // 최초의 초기 데이터 준비
            {"300", "선풍기", "10", "삼성 선풍기"},
            {"400", "전자렌지", "55", "잘 데워져요.."},
            {"200", "에어컨", "5500", "무풍 에어컨 너무 시원해"},
            {"500", "냉장고", "800", "LG 냉장고"},
            {"100", "드라이기", "9", "LG 드라이기"}
    };
    private static ElectronicsService instance = new ElectronicsService(); // 다이어그램에서  "- instance" 자기자신을 가리키고 있음

    Electronics elecArr[]; // ~elecArr 0..* 의미 (~제한자 없음, 변수명 elecArr, 배열형태

    //외부에서 객체 생성안됨 - 배열 elecArr 에 String타입이 아닌 객체형태로 저장
    private ElectronicsService() {
        elecArr = new Electronics[10];
        for (int i = 0; i < data.length; i++) {
            insert(new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]), data[i][3]));
            //생성자 Electronics(int,String,int,String) 호출됨
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
        if (ElectronicsService.count == elecArr.length) { // 배열 크기가 꽉 찼을때
            return false;
        }
        elecArr[ElectronicsService.count++] = electronics; // electronics를 배열에 넣은 후, count++ 증가
        return true;
    }

    /**
     * 등록된 전체 전자제품 검색
     *
     * @return
     */
    public Electronics[] selectAll() {
        return elecArr;
    }

    /**
     * 모델번호에 해당하는 전자제품 검색
     *
     * @return
     */

    public Electronics searchByModelNo(int modelNo) {
        for (int i = 0; i < ElectronicsService.count; i++) {
            if (elecArr[i].getModelNo() == modelNo) {
                elecArr[i].addViewCount();
                return elecArr[i];
            }
        }
        return null;
    }


    /**
     * 모델번호에 해당하는 전자제품 설명만 수정하기
     *
     * @param electronics
     * @return
     */
    public boolean update(Electronics electronics) {
        Electronics foundElectronics = searchByModelNo(electronics.getModelNo());
        if (foundElectronics == null) { // 제품코드가 없는지 확인
            return false;
        }

        foundElectronics.setModelDetail(electronics.getModelDetail());
        return true;
    }

    /**
     * 전자제품 정렬 - 모델번호순
     */
    public void sortByModelNo() {
        int n = ElectronicsService.count;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elecArr[j].getModelNo() > elecArr[j + 1].getModelNo()) {
                    Electronics temp = elecArr[j];
                    elecArr[j] = elecArr[j + 1];
                    elecArr[j + 1] = temp;

                }
            }
        }
    }

    /**
     * 전자제품 정렬 - 모델이름순
     */

    public void sortByModelName() {
        int n = ElectronicsService.count;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elecArr[j].getModelName().compareTo(elecArr[j + 1].getModelName()) > 0) {
                    Electronics temp = elecArr[j];
                    elecArr[j] = elecArr[j + 1];
                    elecArr[j + 1] = temp;

                }
            }
        }
    }

    /**
     * 전자제품 정렬 - 모델가격순
     */
    public void sortByModelPrice() {
        int n = ElectronicsService.count;
        for (int i = n - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (elecArr[j].getModelPrice() > elecArr[j + 1].getModelPrice()) {
                    Electronics temp = elecArr[j];
                    elecArr[j] = elecArr[j + 1];
                    elecArr[j + 1] = temp;

                }
            }
        }
    }

    /**
     * 전자제품 랭킹 - 조회순
     */
    public int[] getRankArrayOrderByViewCount() {
        int[] rankArray = new int[count];
        for (int i = 0; i < count; i++) {
            int rankCount = 0;
            for (int j = 0; j < count; j++) {
                if (elecArr[i].getViewCount() < elecArr[j].getViewCount()) {
                    rankCount++;
                }
            }
            rankArray[i] = rankCount;
        }
        return rankArray;
    }
}

