package ex0207;

class CarCenter {
    public void engineer(Car cd) {
        // Car cd를 파라미터로 받으면 장점
        // 다형성이 없었다면 오버로딩을 통해 파라미터를 다르게 하여 메소드를 여러개 생성해야하는 번거로움이 있음
        System.out.print(cd.carname + " 수리완료!\t");
        System.out.println("청구비용" + cd.cost + " 원");
    }
}

public class PolymorphismExam {
    public static void main(String[] args) {

        CarCenter cc = new CarCenter();
        EfSonata ef = new EfSonata();
        Carnival ca = new Carnival();
        Excel ex = new Excel();

        Car c = new Car();

        cc.engineer(c); // Car cd = c 가능 => c도 Car 타입으로 넣을 수 있음
        cc.engineer(ef); // Car cd = ef 가능 => ef도 Car를 상속받았으므로 가능
        cc.engineer(ca);
        cc.engineer(ex);


    }
}

