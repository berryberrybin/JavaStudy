package jdbcGoodsOrderExam.model.dao;

import jdbcGoodsOrderExam.model.dto.Goods;

import java.sql.SQLException;
import java.util.List;


public interface GoodsDAO {
    /**
     * 전체 상품
     */
    List<Goods> goodsSelect() throws SQLException;

    /**
     * goodsId에 해당하는 정보 검색
     */
    Goods goodsSelectBygoodsId(String goodsId) throws SQLException;
}
