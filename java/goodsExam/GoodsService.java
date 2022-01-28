package goodsExam;

/**
 * 상품에 대한  CRUD 작업 : BusinessLogic(B/L)
 * 전체검색, 등록, 수정, 삭제
 */

class GoodsService {
    private Goods[] goodsArr = new Goods[10];
    static int count; // 배열에 Goods가 저장된 개수를 체크

    // 생성자
    public GoodsService(String[][] data) {
        for (int i = 0; i < data.length; i++) {
            goodsArr[i] = this.create(data[i]);
            GoodsService.count++;
        }
    }

    private Goods create(String[] row) {
        Goods goods = new Goods(row[0], row[1], Integer.parseInt(row[2]), row[3]);
        return goods;
    }

    /**
     * 등록하기
     * - 등록 전에 상품코드가 중복인지를 체크해서 중복이 아닐때 등록한다.
     * - return : int형 (0: 상품코드중복, 1: 등록성공, -1: 배열 길이 벗어나서 등록안됨)
     */

    public int insert(Goods goods) {
        if (goodsArr.length == GoodsService.count) {
            return -1;
        }
        //중복 체크 : 인수로 전달된 상품코드가 이미 저장된 Goods 배열안에 존재하는지 체크
        if (this.selectByCode(goods.getCode()) != null) {
            return 0;
        }
        //중복아니면 등록
        goodsArr[GoodsService.count] = goods;
        GoodsService.count++;
        return 1;
    }

    /**
     * 전체 검색
     * - return : Goods타입의 배열(배열 이름 하나에 여러개의 상품을 담아서 리턴)
     */
    public Goods[] selectAll() {
        return goodsArr;
    }

    /**
     * 상품코드에 해당하는 상품 검색
     * - return : 만약 인수로 전달된 code에 해당하는 정보가 있으면 Goods를 리턴하고
     * 없으면 null 리턴
     */
    public Goods selectByCode(String code) {
        for (int i = 0; i < GoodsService.count; i++) {
            Goods goods = goodsArr[i];
            // 대소문자 상관없이 체크
            String upperCode = goods.getCode().toUpperCase();
            code = code.toUpperCase();
            if (upperCode.equals(code)) {
                return goods;
            }
            /*if(goodsArr[i].getCode().equals(code)){
                return goods;
            }
             */
        }
        return null;
    }

    public Goods selectByName(String name) {
        for (int i = 0; i < GoodsService.count; i++) {
            Goods goods = goodsArr[i];
            if (goodsArr[i].getName().equals(name)) {
                return goods;

            }
        }
        return null;
    }

    /**
     * 상품코드에 해당하는 상품가격, 설명 수정하기
     */
    public boolean update(Goods goods) {
        if (goods == null) {
            return false;
        }
        Goods findGoods = selectByCode(goods.getCode());
        if (findGoods == null) {
            return false;
        }
        findGoods.setPrice(goods.getPrice());
        findGoods.setExplain(goods.getExplain());
        return true;
    }

    public int[] getPriceRank() {
        int[] rankArray = new int[count];
        for (int i = 0; i < count; i++) {
            int rankCount = 0;
            for (int j = 0; j < count; j++) {
                if (goodsArr[i].getPrice() < goodsArr[j].getPrice()) {
                    rankCount++;
                }
            }
            rankArray[i] = rankCount;
        }
        return rankArray;
    }
}
