package ex0217;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class AutoCloseBufferReaderWriterExam {
    public AutoCloseBufferReaderWriterExam() {
        //문자단위로 파일 읽기 - Buffer 이용
        //문자단위로 파일 쓰기 - Buffer 이용

        //자동 리소스 닫기 (교재 p.438)
        try (BufferedReader br = new BufferedReader(new FileReader("java/ex0216/IOStreamExam/testFile.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("java/ex0217/newTestFile.txt"))) {

            // 한줄씩 읽기
            String str = null;
            while ((str = br.readLine()) != null) {
                System.out.println(str);
            }

            ///////////////////////////////////////////
            // 쓰기 = 저장
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
        }
// 자동 리소스 닫기로 인해 finally가 필요 없음
//      finally {
//            try {
//                if (br != null) br.close();
//                if (bw != null) bw.close();
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
    }

    public static void main(String[] args) {
        new AutoCloseBufferReaderWriterExam();
    }
}
