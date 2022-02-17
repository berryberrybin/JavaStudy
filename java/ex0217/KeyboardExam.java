package ex0217;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class KeyboardExam {
    public KeyboardExam() throws Exception {
        /* 키보드 입력
        InputStream is = System.in;
        int i = is.read();
        System.out.println(i + " = " + (char) i);
        */

        /* byte 단위 -> 문자단위 읽기로 변환
        InputStreamReader isr = new InputStreamReader(System.in);
        int i = isr.read();
        System.out.println(i + " = " + (char) i);
        */

        // Buffered로 변환해서 한줄읽기 하자!
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String data = br.readLine();
        System.out.println("data = " + data);

    }

    public static void main(String[] args) {
        try {
            new KeyboardExam();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
