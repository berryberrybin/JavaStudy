package ex0208_문수빈.VehicleExample;

public class DriverExample {
    public static void main(String[] args) {
        Driver driver = new Driver();
        Bus bus = new Bus();
        Taxi taxi = new Taxi();

        driver.drive(bus); // 자동타입변환 : Vehicle vehicle = bus;
        driver.drive(taxi); // 자도타입변환 : Vehicle vehicle = taxi;
    }
}
