package ex0211.sutdentListExam;

public class Student {
    private String sno;
    private String name;
    private int age;
    private String addr;


    public Student() {

    }


    public Student(String sno, int age, String addr) {
        this.sno = sno;
        this.age = age;
        this.addr = addr;
    }

    public Student(String sno, String name, int age, String addr) {
        this(sno, age, addr);
        this.name = name;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Student{");
        sb.append("sno='").append(sno).append('\'');
        sb.append(", name='").append(name).append('\'');
        sb.append(", age=").append(age);
        sb.append(", addr='").append(addr).append('\'');
        sb.append('}');
        return sb.toString();
    }
}

