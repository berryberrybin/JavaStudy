package ex0221.chat;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerChatExam {
    Socket sk;

    public ServerChatExam() {
        try (ServerSocket server = new ServerSocket(8000)) {
            System.out.println("클라이언트 접속을 기다립니다");
            sk = server.accept();
            System.out.println(sk.getInetAddress() + "님과 채팅 시작합니다.");

            //보내는 스레드 - 클래스 따로 생성하는 방법
            // 소켓을 따로 전달해줘야 함, outer로 만들면 ClientChatExam에 또 만들지 않고 재사용 가능
            new SendThread(sk, "SERVER").start();

            // 받는 스레드 - inner class를 활용하는 방법
            // 소켓을 따로 전달해줄 필요 없음, 타class에서 재사용 불가
            new ServerReceiveThread().start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ServerChatExam();
    }

    /**
     * 클라이언트로부터 전송된 데이터 읽어서 모니터에 출력하는 스레드
     */
    class ServerReceiveThread extends Thread {
        @Override
        public void run() {
            try (BufferedReader br = new BufferedReader(new InputStreamReader(sk.getInputStream()))) {
                while (true) {
                    String input = br.readLine();
                    if (input.equals("exit")) {
                        break;
                    }
                    System.out.println(input);
                }
                System.out.println("서버받는 스레드 종료합니다.");
            } catch (Exception e) {
                System.out.println("ServerReceiveThread catch 발생...");
                // e.printStackTrace();
            } finally {
                System.exit(0);// 프로그램 종료!!
            }
        }
    }
}
