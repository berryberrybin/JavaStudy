package ex0218Networkd;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws Exception {
        File dir = new File("C:/Temp/Dir");
        if (dir.exists() == false) {
            dir.mkdirs();
        } // 새로운 디렉토리 생성

        File file1 = new File("C:/Temp/file.txt")
        if (file1.exists() == false) {
            file1.createNewFile();
        } // 새로운 파일 생성

        File temp = new File("C:/Temp");
        File[] contents = temp.listFiles(); // 디렉토리에 포함된 파일 및 서브데릭토리 목록 전부를 String배열로 리턴
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd. a. HH:mm"); // ex) 2022-02-19 오전 09:30
        for (File file : contents) {
            System.out.print(sdf.format(new Date(file.lastModified()))); // lastModifed() - 마지막 수정날자 및 시간 리턴
            if (file.isDirectory()) { // 디렉토리인지 여부
                System.out.print("<DIR> : " + file.getName());
            } else {
                System.out.print(file.length() + file.getName()); // 디렉토리가 아니면 파일크기 와 파일이름 리턴
            }
            System.out.println();
        }
    }
}
