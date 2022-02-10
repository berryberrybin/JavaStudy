package ex0210;

public class Shop {
    public void checkAge(int age) throws UNDERAGEException {
        if (age < 18) {
            throw new UNDERAGEException("애들은 가라");
        } else {
            System.out.println("입장하신 걸 환영합니다.");
        }
    }


    public static void main(String[] args) throws UNDERAGEException {
        Shop shop = new Shop();
        int ExceptionNumber = 0;
        for (int i = 0; i < 10; i++) {
            int randomAge = (int) (Math.random() * 55 + 1);
            System.out.print(randomAge + "살 : ");
            try {
                shop.checkAge(randomAge);
            } catch (UNDERAGEException e) {
                ExceptionNumber++;
            }
        }
        System.out.println("[ 예외 개수 ] " + ExceptionNumber + " 개");
    }
}

class UNDERAGEException extends Exception {
    public UNDERAGEException(String message) {
        System.out.println(message);
    }
}