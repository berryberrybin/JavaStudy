package ex0128_문수빈;

public class ShopService {
    private static ShopService shopService = new ShopService();

    private ShopService() {
    }

    static ShopService getInstance() {
        return shopService;
    }
}
