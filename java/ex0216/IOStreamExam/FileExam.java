package ex0216.IOStreamExam;

import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class FileExam {
    public FileExam() throws IOException {
        String fileName = JOptionPane.showInputDialog("파일 이름은?"); // java/ex0216/IOStreamExam/testFile.txt
        File file = new File(fileName);
        if (file.exists()) {
            System.out.println(fileName + " 존재합니다.");

            if (file.isFile()) { //파일인 경우
                System.out.println("********** 파일 정보 ********");
                System.out.println("읽기기능 : " + file.canRead());
                System.out.println("쓰기기능 : " + file.canWrite());
                System.out.println("파일이름 : " + file.getName());
                System.out.println("절대경로 : " + file.getAbsolutePath());
                System.out.println("파일크기 : " + file.length());

            } else { // 폴더인 경우
                System.out.println("****** 폴더의 정보 *********");
                String[] fileNames = file.list();
                for (String name : fileNames) {
                    System.out.println(name);
                }
            }
        } else {
            System.out.println(fileName + "은 없으니 만들께요.");
            //파일 생성
            file.createNewFile();
            // 폴더 생성 (파일과 폴더 둘다 만들 수는 없음)
            // file.mkdir();
        }
    }

    public static void main(String[] args) {
        try {
            new FileExam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
