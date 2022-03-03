package jdbcGoodsOrderExam.controller;

import jdbcGoodsOrderExam.model.dto.Orders;
import jdbcGoodsOrderExam.model.service.OrderService;
import jdbcGoodsOrderExam.view.EndView;
import jdbcGoodsOrderExam.view.FailView;

import java.sql.SQLException;
import java.util.List;


public class OrderController {
    private static OrderService orderService = new OrderService();

    /**
     * 주문하기
     */
    public static void insertOrders(Orders order) {
        try {
            orderService.insertOrders(order);
        } catch (Exception e) {
            FailView.errorMessage(e.getMessage());

        }
    }

    /**
     * 주문내역보기
     */
    public static void selectOrdersByUserId(String userId) {
        try {
            List<Orders> orderList = orderService.selectOrdersByUserId(userId);
            EndView.printOrderByUserId(orderList);
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());

        }
    }
}




