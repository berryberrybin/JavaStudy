package ex0216.IOStreamExam;

import javax.swing.*;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopyBufferedExam {

    public FileCopyBufferedExam(String readFname, String writeFname) {
        //readFname에 있는 내용을 읽어서 writeFname에 장저장한다 (파일 복사)
        FileInputStream fis = null;
        FileOutputStream fos = null;

        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;

        try {
            fis = new FileInputStream(readFname);
            fos = new FileOutputStream(writeFname);
            // fos.write(fis.read()); 한개만 복사됨
            // 파일 전체 본사 하기 위해 while 돌아야함

            bis = new BufferedInputStream(fis);
            bos = new BufferedOutputStream(fos);

            int i = 0;
            while ((i = bis.read()) != -1) {
                bos.write(i);
            }
            System.out.println("파일 복사 완료했습니다.");
            // 이방법은 파일이 커졌을때 느림 -> Buffer활용하면 좀 더 빠름

        } catch (Exception e) {

        } finally {
            // close()할때마다 try catch를 하는게 귀찮음
            // 새로운 문법이 생김
            try {
                if (bis != null) bis.close();
                if (bos != null) bos.close();
                // bis = new BufferedInputStream(new FileInputStream(readFname));
                // 이라고 하면 bis와 bos 1번만 닫아도 됨
                if (fis != null) fis.close();
                if (fos != null) fos.close();
            } catch (Exception e) {

            }
        }
    }


    public static void main(String[] args) {
        String readFname = JOptionPane.showInputDialog("읽을 파일명?");
        String writeFname = JOptionPane.showInputDialog("저장할 파일명?");
//        new FileCopyBufferedExam(readFname, writeFname);
        long start = System.nanoTime();
        new FileCopyBufferedExam(readFname, writeFname);
        long end = System.nanoTime();
        System.out.println("총걸린시간 :" + (end - start));

    }
}
