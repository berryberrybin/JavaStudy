package ex0217.SaveExam;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ObjectSaveExam {
    public ObjectSaveExam() {
        Student st1 = new Student("Kim", 20, "서울");
        Student st2 = new Student("Park", 25, "부산");


        //파일에 List저장 가능 - List 클래스에 이미 Serializable 구현해놓았기 때문에 직렬화 할 수 있음
        List<Student> studentList = new ArrayList<>();
        studentList.add(new Student("Moon", 23, "경기"));
        studentList.add(new Student("Kim", 30, "대전"));
        studentList.add(new Student("Na", 22, "서울"));

        // 직렬화
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("java/ex0217/SaveExam/studentSave.txt"))) {
            oos.writeObject(st1);
            oos.writeObject(st2);

            oos.writeObject(studentList);
            System.out.println("---객체 저장 완료---");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        new ObjectSaveExam();
    }
}
