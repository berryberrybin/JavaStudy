package ex0216.IOStreamExam;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyExam {

    public FileCopyExam(String readFname, String writeFname) {
        //readFname에 있는 내용을 읽어서 writeFname에 장저장한다 (파일 복사)
        FileInputStream fis = null;
        FileOutputStream fos = null;
        try {
            fis = new FileInputStream(readFname);
            fos = new FileOutputStream(writeFname);
            // fos.write(fis.read()); 한개만 복사됨
            // 파일 전체 본사 하기 위해 while 돌아야함
            int i = 0;
            while ((i = fis.read()) != -1) {
                fos.write(i);
            }
            System.out.println("파일 복사 완료했습니다.");
            // 이방법은 파일이 커졌을때 느림 -> Buffer활용하면 좀 더 빠름

        } catch (Exception e) {

        } finally {
            // close()할때마다 try catch를 하는게 귀찮음
            // 새로운 문법이 생김
            try {
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (Exception e) {

            }
        }
    }

    public static void main(String[] args) {
        String readFname = JOptionPane.showInputDialog("일을 파일명?");
        String writeFname = JOptionPane.showInputDialog("저장할 파일명?");
//        new FileCopyExam(readFname, writeFname);

        long start = System.nanoTime();
        new FileCopyExam(readFname, writeFname);
        long end = System.nanoTime();
        System.out.println("총걸린시간 :" + (end - start));

    }
}
