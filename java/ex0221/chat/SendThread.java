package ex0221.chat;

import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * 키보드 입력을 받아서 입력값을 상대측에게 전송
 */
public class SendThread extends Thread {
    Socket sk;
    String name;

    // ServerChatExam의 Socket이 필요함 -> 소켓을 파라미터로 받는 생성자를 통해 전달받을 수 있음
    public SendThread(Socket sk, String name) {
        super(name);
        this.sk = sk;
        this.name = name;
    }

    @Override
    public void run() {
        Scanner sc = new Scanner(System.in); // 키보드 입력 받음

        // 입력값을 상대측에 전송한다.
        try (PrintWriter pw = new PrintWriter(sk.getOutputStream(), true)) {
            while (true) {
                String data = sc.nextLine(); // 키보드 입력 읽기
                if (data.equals("exit")) {
                    pw.println(data);
                    break;
                } else {
                    pw.println(name + "이 보낸 내용 : " + data); // print()는 autoFlush가 되지 않음. println()사용
                }
            }
            System.out.println(name + "이 보내는 스레드가 종료합니다");
        } catch (Exception e) {
            System.out.println(name + "의 SendThread 예외가 발생했습니다.");
            //e.printStackTrace();
        }
    }
}
