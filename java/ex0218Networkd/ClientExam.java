package ex0218Networkd;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientExam {
    public ClientExam() {
        try (Socket sk = new Socket("127.0.0.1", 8000)) { //127.0.0.1 =localhost 뜻함 (자기자신 IP)
            // 서버에게 데이터 전송하기 위한 준비
            PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
            pw.println("서버에 접속하고 싶습니다."); // ClientExam의 br.readLin()으로 감

            // 서버가 보내오는 데이터를 읽기
            BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
            String message = br.readLine();
            System.out.println(" [ 서버가 보내온 내용 ] : " + message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientExam();
    }
}
