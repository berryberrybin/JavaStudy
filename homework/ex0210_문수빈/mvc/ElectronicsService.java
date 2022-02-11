package ex0210.mvc;

/**
 * 전자제품에 관련된 기능을 담당할 클래스
 */

class ElectronicsService {
    String[][] data = new String[][]{
            {"100", "선풍기", "35000", "삼성 선풍기"},
            {"200", "전자렌지", "55000", "잘 데워져요.."},
            {"300", "에어컨", "5500000", "무풍 에어컨 너무 시원해"},
            {"400", "냉장고", "800000", "LG 냉장고"},
            {"500", "드라이기", "9000", "LG 드라이기"}
    }; // 최초의 초기치 데이터를 준비!! electronics에 저장

    private static ElectronicsService instance = new ElectronicsService(); // 16번째줄로감

    public static int count; // 배열방에 저장된 전자제품의 개수를 체크!!

    Electronics elecArr[]; // 공간생성

    /**
     * 외부에서 객체 생성안됨.
     */
    private ElectronicsService() {
        // 데이터 초기화(전자제품 초기치 데이터) 하자.
        elecArr = new Electronics[7];

        for (int i = 0; i < data.length; i++) {
            elecArr[i] = new Electronics(Integer.parseInt(data[i][0]), data[i][1], Integer.parseInt(data[i][2]), data[i][3]); // 데이터 초기화

            ElectronicsService.count++;
        }

    }

    /**
     * 현재 객체를 리턴해준다.
     *
     * @return
     */
    public static ElectronicsService getInstance() {

        return instance;
    }

    /**
     * 전자제품 등록
     * return : true이면 등록성공, false이면 등록실패
     *
     * @param electronics
     * @return
     */
    public void insert(Electronics electronics) {
        elecArr[ElectronicsService.count] = electronics;
        ElectronicsService.count++;
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
     * @param modelNo
     * @return
     */
    public Electronics searchByModelNo(int modelNo) throws SearchNotFoundException {
        for (int i = 0; i < ElectronicsService.count; i++) {
            if (elecArr[i].getModelNo() == modelNo) {
                return elecArr[i];
            }
        }
        throw new SearchNotFoundException();
    }


    /**
     * 모델번호에 해당하는 전자제품 수정하기
     * (설명만 수정한다)
     *
     * @param electronics
     * @return
     */
    public void update(Electronics electronics) throws SearchNotFoundException {
        //인수로 전달된 모델번호에 해당하는 전자제품이 있는지 검색한다.
        Electronics dbElectronics = this.searchByModelNo(electronics.getModelNo());
        dbElectronics.setModelDetail(electronics.getModelDetail());
    }


} // 클래스 끝