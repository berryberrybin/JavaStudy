package jdbcGoodsOrderExam.model.dao;

import jdbcGoodsOrderExam.model.dto.Customer;

import java.sql.SQLException;


public interface CustomerDAO {
    /**
     * 로그인하기
     */
    Customer login(String userId, String userPwd) throws SQLException;
}
