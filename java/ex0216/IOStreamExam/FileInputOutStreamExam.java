package ex0216.IOStreamExam;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutStreamExam {
    public FileInputOutStreamExam() {
        FileInputStream fis = null;
        FileOutputStream fos = null;

        try {
            fis = new FileInputStream("java/ex0216/IOStreamExam/testFile.txt");
            // 읽기

//            int i = fis.read(); //1byte 읽기
//            System.out.println(i);

//            int i = 0;
//            while ((i = fis.read()) != -1) {
//                System.out.println(i + "=" + (char) i);
//            }

            System.out.println("-----------------------");
            int byteSize = fis.available();
            System.out.println("byteSize : " + byteSize);
            byte[] b = new byte[byteSize];
            fis.read(b);

            //byte배열을 문자열로 변경!! (한글 출력 가능)
            String data = new String(b);
            System.out.println(data);

            ////////////////////////////////
            //저장기능
            // fos = new FileOutputStream("java/ex0216/IOStreamExam/write.txt"); // 덮어쓰기
            fos = new FileOutputStream("java/ex0216/IOStreamExam/write.txt", true); // 이어쓰기
            fos.write(65); //'A'
            fos.write(32); // 공백
            fos.write(66); //'B'
            fos.write(10);//줄바꿈
            fos.write(67);//'C'

            // 문자열을 -> byte배열로 변환
            String message = "안녕하세요";
            byte[] re = message.getBytes();
            fos.write(re);
            System.out.println("저장완료!!");

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (fis != null)
                    fis.close();
                if (fos != null) fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        new FileInputOutStreamExam();
    }
}