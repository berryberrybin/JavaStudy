package ex0210.shop;

import java.util.Random;

public class ShoppingMallMainApp {
    public static void main(String[] args) {
        System.out.println("----shop open---");
        ShoppingMall mall = new ShoppingMall();

        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int age = random.nextInt(55) + 1;
            System.out.print("- age = " + age + "살 : ");
            try {
                mall.enter(age);
            } catch (AgeCheckException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println("----shop end---");
        System.out.println("입장불가 : " + AgeCheckException.count + " 명");
    }
}
