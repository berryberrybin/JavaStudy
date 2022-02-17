package ex0217;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BufferReaderWriterExam {
    public BufferReaderWriterExam() {
        //문자단위로 파일 읽기 - Buffer 이용
        BufferedReader br = null;
        //문자단위로 파일 쓰기 - Buffer 이용
        BufferedWriter bw = null;

        try {
            br = new BufferedReader(new FileReader("java/ex0216/IOStreamExam/testFile.txt"));

            /* 한글자씩 읽기
            int i = 0;
            while ((i = br.read()) != -1) {
                System.out.println(i + " = " + (char) i); // byte기준이였으면 한글깨졌지만, 문자기준이기때문에 한글이 제대로 출력됨
            }
            */

            // 한줄씩 읽기
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            ///////////////////////////////////////////
            // 쓰기 = 저장
            bw = new BufferedWriter(new FileWriter("java/ex0217/newTestFile.txt"));
            bw.write("새로운 파일");
            bw.write(13); // 줄바꿈 방법 (1)
            bw.write(10);
            bw.write("I am happy");
            bw.newLine();// 줄바꿈 방법 (2)
            bw.write("테스트 하는 중\n"); // 줄바꿈 방법 (3)
            bw.write("test 완료");

            bw.flush();//버퍼에 있는 데이터를 비운다 (저장한다)

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (br != null) br.close();
                if (bw != null) bw.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new BufferReaderWriterExam();
    }
}
