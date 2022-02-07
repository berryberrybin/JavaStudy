package ex0207;

class Car {
    public String carname;
    public int cost;

    protected void printAttributes() {
        System.out.println("carname=" + carname + "\tcost=" + cost);
    }
}

/*
Car를 상속받는 EfSonata, Excel, Carnival 3개 클래스 작성
각 클래스에 인수를 받지않는 생성자 작성
각 클래스의 생성자의 구현부에서 carname과 cost에 적당한 값 할당
*/

class EfSonata extends Car {
    EfSonata() {
        carname = "mySonata"; // this. 사용 가능
        cost = 100; // this. super. 사용도 가능
    }
}

class Excel extends Car {
    Excel() {
        this.carname = "myExcel";
        this.cost = 200;

    }
}

class Carnival extends Car {
    Carnival() {
        carname = "myCarnival";
        super.cost = 300;
    }
}

public class InheritanceExam {
    public static void main(String[] args) {
        //Car, EfSonata, Excel, Canival 네개의 객체를 생성
        // 각 클래스에서 Car calss에있는 printAttributes()메소드를 호출할수있다.

        Car car = new Car();
        EfSonata efSonata = new EfSonata();
        Excel excel = new Excel();
        Carnival carnival = new Carnival();

        car.printAttributes();
        efSonata.printAttributes();
        excel.printAttributes();
        carnival.printAttributes();
    }
}



