package jdbcGoodsOrderExam.controller;


import jdbcGoodsOrderExam.model.dto.Customer;
import jdbcGoodsOrderExam.model.service.CustomerService;
import jdbcGoodsOrderExam.view.FailView;
import jdbcGoodsOrderExam.view.MenuView;

public class CustomerController {
    static CustomerService customerService = new CustomerService();

    /**
     * 로그인
     */
    public static void login(String userId, String userPwd) {
        try {
            Customer customer = customerService.login(userId, userPwd);
            MenuView.printUserMenu(userId);
            //MenuView.menu();
        } catch (Exception e) {
            //e.printStackTrace();
            FailView.errorMessage(e.getMessage());

        }
    }
}
