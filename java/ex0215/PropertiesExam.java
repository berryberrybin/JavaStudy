package ex0215;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class PropertiesExam {
    Properties pro = new Properties();

    public PropertiesExam() {
        pro.setProperty("id", "A01");
        pro.setProperty("Age", "20");
        pro.setProperty("addr", "서울");

        for (String key : pro.stringPropertyNames()) {
            String value = pro.getProperty(key);
            System.out.println(key + " = " + value);
        }
    }

    /**
     * 외부의 ~.properties 파일을 읽어서 key와 value로 분리하는 방법
     * 1) IO를 이용한 방법
     * 2) ResourcesBundle 객체를 이용하는 방법
     */

    // 1)IO를 이용한 방법
    public void test01() {
        try {
            pro.clear(); // 기존 데이터 비우기
            //경로는 project 기준으로 하위 작성
            pro.load(new FileInputStream("java/ex0215/propertiesPractice.properties"));

            for (String key : pro.stringPropertyNames()) {
                String value = pro.getProperty(key);
                System.out.println(key + " = " + value);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //ResourceBundle 객체를 이용하는 방법
    // ResourceBundle은 ~.properties 파일을 로딩하는 전용 클래스
    // 경로 설정할때 class 폴더가 기준이며 확장자는 생략한다
    public void test02() {
        ResourceBundle rb = ResourceBundle.getBundle("ex0215/propertiesPractice");

        for (String key : rb.keySet()) {
            System.out.println(key + " : " + rb.getString(key));
        }

    }

    public static void main(String[] args) {
        PropertiesExam pe = new PropertiesExam();

        System.out.println("--------- 1) IO를 이용한 방법 -----------");
        pe.test01();

        System.out.println("--------- 2) ResourceBundle를 이용한 방법 -----------");
        pe.test02();
    }
}
