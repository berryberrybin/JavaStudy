package ex0217;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class MemoPractice {

    public MemoPractice() {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
             BufferedWriter bw = new BufferedWriter(new FileWriter("java/ex0217/memoTestFile.txt"))) {
            while (true) {
                System.out.print("입력 > ");
                String data = br.readLine();
                if (data.equals("exit")) {
                    break;
                }
                System.out.println("data : " + data);
                bw.write(data);
                bw.newLine();
                bw.flush();
            }
            System.out.println("프로그램 종료...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new MemoPractice();
    }
}
