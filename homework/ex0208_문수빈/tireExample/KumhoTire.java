package ex0208_문수빈.tireExample;

public class KumhoTire extends Tire {
    public KumhoTire(String location, int maxRotation) {
        super(location, maxRotation);
    }

    @Override
    public boolean roll() {
        ++accumulateRotation;
        if (accumulateRotation < maxRotation) {
            System.out.println(location + "kumhoTire 수명 : " + (maxRotation - accumulateRotation) + "회");
            return true;
        } else {
            System.out.println("**" + location + "kumhoTire 펑크 **");
            return false;
        }
    }

}
