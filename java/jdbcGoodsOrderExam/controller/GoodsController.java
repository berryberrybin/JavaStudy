package jdbcGoodsOrderExam.controller;

import jdbcGoodsOrderExam.model.dto.Goods;
import jdbcGoodsOrderExam.model.service.GoodsService;
import jdbcGoodsOrderExam.view.EndView;
import jdbcGoodsOrderExam.view.FailView;

import java.util.List;


public class GoodsController {
    static GoodsService goodsService = new GoodsService();

    /**
     * 전체 상품 조회
     */
    public static void goodsSelect() {
        try {
            List<Goods> list = goodsService.goodsSelect();
            EndView.printGoodsList(list);
        } catch (Exception e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    /**
     *
     * */
}
