package ex0217.SaveExam;

import java.io.Serializable;

/**
 * 현재 객체를 파일에 저장하기 위해서 직렬화 필수
 * 직렬화 대상에서 제외하고 싶을때는 static, transient 사용
 */
public class Student implements Serializable {
    private String name;
    private int age;
    private String addr;

    public Student() {
    }

    public Student(String name, int age, String addr) {
        this.name = name;
        this.age = age;
        this.addr = addr;
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
        StringBuilder sb = new StringBuilder("Student - ");
        sb.append("name='").append(name);
        sb.append(", age=").append(age);
        sb.append(", addr='").append(addr);
        return sb.toString();
    }
}
