package ex0218Networkd;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExam {
    public ServerExam() {
        try (ServerSocket server = new ServerSocket(8000)) {
            while (true) {
                System.out.println("클라이언트 접속을 대기중입니다.");
                Socket sk = server.accept();
                System.out.println(sk.getInetAddress() + "님 접속하였습니다.");

                InputStream is = sk.getInputStream(); // 접속한 클라이언트가 보내온 데이터를 읽기
                BufferedReader br = new BufferedReader(new InputStreamReader(is));
                String message = br.readLine();
                System.out.println("[클라이언트가 보낸 내용] = " + message);

                // 접속한 클라이언트에게 데이터 전송
                // OutputStream os = sk.getOutputStream();
                // printWriter() -> BufferedWriter, OutputStream 대신 사용
                PrintWriter pw = new PrintWriter(sk.getOutputStream(), true);
                pw.println("안녕하세요");

                sk.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerExam();
    }
}
