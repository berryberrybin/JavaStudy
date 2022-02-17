package ex0217.SaveExam;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.List;

public class ObjectLoadExam {
    public ObjectLoadExam() {
        //ObjectInputStream 을 통해- 역직렬화 (파일에 저장된 객체를 가져옴)
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("java/ex0217/SaveExam/studentSave.txt"))) {
            Student st1 = (Student) ois.readObject();
            Student st2 = (Student) ois.readObject();
            List<Student> list = (List<Student>) ois.readObject();

            System.out.println("st1 : " + st1);
            System.out.println("st2 : " + st2);
            System.out.println("list : " + list);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ObjectLoadExam();
    }
}
