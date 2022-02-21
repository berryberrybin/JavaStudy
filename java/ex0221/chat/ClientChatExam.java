package ex0221.chat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientChatExam {
    Socket sk;

    public ClientChatExam() {
        try {
            sk = new Socket("127.0.0.1", 8000);
            // 보내는 스레드
            new SendThread(sk, "Client").start();

            //받는 스레드
            // Thread th = new Thread();
            // th.start();
            new Thread(() -> {
                try (BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))) {
                    while (true) {
                        String input = br.readLine();
                        if (input.equals("exit")) {
                            break;
                        }
                        System.out.println(input);
                    }

                } catch (Exception e) {
                    System.out.println("ClientChatExam의 받는 스레드 catch블럭입니다.");
                    // e.printStackTrace();
                } finally {
                    System.out.println("Client 받는 스레드 finally 블럭입니다.");
                    System.exit(0);
                }
            }).start();

        } catch (Exception e) {
            System.out.println("Client 생성자 예외 발생했습니다.");
            //e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientChatExam();
    }
}
