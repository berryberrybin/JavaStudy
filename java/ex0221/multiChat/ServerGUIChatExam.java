package ex0221.multiChat;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerGUIChatExam {
    ServerSocket server;
    Socket sk;
    String userIP;
    List<ClientSocketThread> list = new ArrayList<>();

    public ServerGUIChatExam() {
        try {
            server = new ServerSocket(8888);
            while (true) {
                System.out.println("CLIENT 접속 대기중 ...");
                sk = server.accept();
                userIP = sk.getInetAddress().toString();
                System.out.println(userIP + "님 접속되셨습니다.");

                // 접속된 클라이언트가 보내오는 데이터를 읽어서 모든 Client에게 데이터를 전송할 스레드 필요
                ClientSocketThread th = new ClientSocketThread();
                th.start();
                list.add(th);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }//생성자 끝

    /**
     * list에 있는 모든 접속자에게 상대측에서 보낸 메시지를 전송한다.
     */

    public void sendMessage(String message) {
        for (ClientSocketThread th : list) {
            th.pw.println(message);
        }
    }

    //접속된 클라이언트가 보내오는 데이터를 읽어서 모든 클라이언트에게 데이터를 전송할 스레드 필요
    class ClientSocketThread extends Thread {
        BufferedReader br; // 클라이언트의 전송된 데이터 읽기
        PrintWriter pw; // 클라이언트에게 데이터 전송하기
        String name; // 대화명

        @Override
        public void run() {
            System.out.println("Run");
            try {
                br = new BufferedReader(new InputStreamReader(sk.getInputStream()));
                pw = new PrintWriter(sk.getOutputStream(), true);

                // 대화명 읽기 ex) ~님이 입장하셨습니다. - 1번만 호출
                name = br.readLine();

                //접속된 모든 유저에게 알리는(전송하는) 메소드 호출
                sendMessage("[ " + name + " ] 님 입장하셨습니다.");

                String inputData = null;
                while ((inputData = br.readLine()) != null) {
                    sendMessage("[ " + name + " ] : " + inputData);
                }

            } catch (Exception e) {
                // 접속된 유저의 Socket에서 예외가 발생시 catch로 들어옴 ex) 유저가 채팅창 닫기 눌렀을때
                // 현재 스레드( = 닫기누른 유저의 스레드)를 list에서 제거해야 함
                list.remove(this);
                // 남은 유저에게 알림
                sendMessage("[ " + name + " ] 님 퇴장하셨습니다.");
                e.printStackTrace();
                //서버창에 출력
                System.out.println("[ " + name + " ] 종료");
            }
        }
    }

    public static void main(String[] args) {
        new ServerGUIChatExam();
    }
}
