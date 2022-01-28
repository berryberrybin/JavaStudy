package goodsExam;

public class StartView {
    public static void main(String[] args) {
        String[][] data = new String[][]{
                {"A01", "새우깡", "1500", "봉지과자"},
                {"A02", "콘칩", "2000", "봉지과자"},
                {"A03", "빼빼로", "1200", "박스과자"},
                {"B01", "콜라", "800", "탄산음료"},
                {"B02", "델몬트오렌지", "1000", "과일음료"},
        };
        System.out.println("상품관리 프로그램 시작합니다.\n");
        new MenuView().printMenu(data);
    }

}
