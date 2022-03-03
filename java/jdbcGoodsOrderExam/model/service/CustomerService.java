package jdbcGoodsOrderExam.model.service;

import jdbcGoodsOrderExam.exception.NotFoundException;
import jdbcGoodsOrderExam.model.dao.CustomerDAO;
import jdbcGoodsOrderExam.model.dao.CustomerDAOImpl;
import jdbcGoodsOrderExam.model.dto.Customer;
import jdbcGoodsOrderExam.session.Session;
import jdbcGoodsOrderExam.session.SessionSet;

import java.sql.SQLException;

public class CustomerService {
    CustomerDAO customerDao = new CustomerDAOImpl();


    /**
     * 로그인
     */
    public Customer login(String userId, String userPwd) throws NotFoundException, SQLException {
        Customer customer = customerDao.login(userId, userPwd);
        if (customer == null) {
            throw new NotFoundException("정보를 다시 확안해주세요.");
        }

        //로그인 된 정보 저장하기
        Session session = new Session(userId);


        SessionSet sessionSet = SessionSet.getInstance();
        sessionSet.add(session);

        return customer;
    }
}
