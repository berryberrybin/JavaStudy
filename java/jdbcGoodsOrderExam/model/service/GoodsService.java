package jdbcGoodsOrderExam.model.service;

import jdbcGoodsOrderExam.exception.NotFoundException;
import jdbcGoodsOrderExam.model.dao.GoodsDAO;
import jdbcGoodsOrderExam.model.dao.GoodsDAOImpl;
import jdbcGoodsOrderExam.model.dto.Goods;

import java.sql.SQLException;
import java.util.List;


public class GoodsService {
    GoodsDAO goodsDao = new GoodsDAOImpl();

    /**
     * 전체 상품조회
     */
    public List<Goods> goodsSelect() throws NotFoundException, SQLException {
        List<Goods> list = goodsDao.goodsSelect();
        if (list.size() == 0) throw new NotFoundException("현재 상품이 없습니다.");
        return list;
    }

    /**
     * 상품번호에 해당하는 상품검색
     */
    public Goods goodsSelectBygoodsId(String goodsId) throws SQLException {
        Goods goods = goodsDao.goodsSelectBygoodsId(goodsId);
        if (goods == null) throw new SQLException(goodsId + " 현재 상품이 없습니다.");
        return goods;
    }
}
