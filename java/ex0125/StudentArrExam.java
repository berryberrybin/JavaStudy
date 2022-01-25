package ex0125;

public class StudentArrExam {
    public static void main(String[] args) {
        Student[] stArr = new Student[3];
        for (int i = 0; i < stArr.length; i++) {
            stArr[i] = new Student(); // 학생 한명 한명이 만들어짐
        }
        // private 붙이기전 학생 정보 변경
        /*
        stArr[2].name="라이언";
        stArr[2].age=5;
        stArr[2].address="서울시";
        */

        stArr[1].setName("어피치");
        stArr[1].setAge(20);
        stArr[1].setAddress("용인시");

        stArr[2].setName("라이언");
        stArr[2].setAge(5);
        stArr[2].setAddress("서울시");


        for (int i = 0; i < stArr.length; i++) {
            System.out.print(stArr[i].getName() + " | ");
            System.out.print(stArr[i].getAge() + " | ");
            System.out.print(stArr[i].getAddress() + "\n");
        }


    }
}

class Student {
    private String name; // null
    private int age; // 0
    private String address; // null

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        if (age > 18) {
            this.age = age;
        } else {
            System.out.println("나이의 값이 유효하지 않습니다.");
        }
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }
}