package ex0214.mapClass;

public class Student extends Person {
    private int kor;
    private int eng;
    private int math;
    private int sum;

    public Student(String id, String name, int kor, int eng, int math) {
        super(id, name);
        this.kor = kor;
        this.eng = eng;
        this.math = math;
    }

    public Student() {
    }

    public Student(String id, String name, int age, int kor, int eng, int math) {
        this(id, name, kor, eng, math);
        setAge(age);
    }


    public int getKor() {
        return kor;
    }

    public void setKor(int kor) {
        this.kor = kor;
    }

    public int getEng() {
        return eng;
    }

    public void setEng(int eng) {
        this.eng = eng;
    }

    public int getMath() {
        return math;
    }

    public void setMath(int math) {
        this.math = math;
    }

    public int getSum() {
        return kor + math + eng;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" ");
        sb.append("kor=").append(kor);
        sb.append(", eng=").append(eng);
        sb.append(", math=").append(math);
        sb.append(", sum=").append(getSum());
        return sb.toString();
    }
}
