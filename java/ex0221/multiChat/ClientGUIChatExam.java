package ex0221.multiChat;

import javax.swing.*;
import java.awt.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientGUIChatExam extends JFrame {

    JTextArea textArea = new JTextArea();
    JScrollPane jsp = new JScrollPane(textArea); // 스크롤 동작
    JTextField textField = new JTextField();

    Socket sk;
    PrintWriter pw;
    BufferedReader br;

    public ClientGUIChatExam() {
        super("채팅창");


        //옵션 설정
        textArea.setFocusable(false);// textArea에는 커서 놓기가 안됨
        textArea.setBackground(Color.pink); //배경화면 핑크
        textArea.requestFocus();//아래쪽 하단에만 커서가 항상 놓이도록 설정


        // Layout 설정
        Container con = getContentPane();
        con.add(jsp, BorderLayout.CENTER);
        con.add(textField, BorderLayout.SOUTH);

        //창크기
        setSize(400, 300);
        //창위치
        setLocationRelativeTo(null); // 정가운데 놓기
        //창보이기
        setVisible(true);

        //x를 클릭하면 완전히 창 닫기
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //서버에 접속하는 메소드 호출
        this.connection();

        // 받는 스레드 (서버가 보내오는 데이터를 읽어서 JTextArea 창에 추가해야 함)

        Thread th = new Thread(() -> {
            try {
                String data = null;
                while ((data = br.readLine()) != null) {
                    // textArea.setText(data); - setText()는 덮어쓰기기능
                    textArea.append(data + "\n"); // - append()는 추가기능

                    //스크롤이 입력한 글자만큼 내려오기
                    textArea.setCaretPosition(textArea.getText().length());

                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        th.setDaemon(true); // 데몬스레드 생성 - 메인 스레드가 종료되면 현재스레드도 함께 종료됨
        th.start();


        //JTextField에서 값을 입력하고, enter하면 이벤트 처리
        /*
         사용자 ActionEvent가 일어날때 ("안녕"Enter하면) Server에 메시지를 보냄
         1) 이벤트 발생시키는 주체는 JTextFile
         2) 이벤트종류는 ActionEvent
         3) ActionAdapter는 없으므로 ActionListener 사용하여 원하는 기능을 만든다
         4) 이벤트 등록
        */
        textField.addActionListener((e) -> {
            //text값 읽기
            String message = textField.getText();
            //Server에 전송
            pw.println(message);
            //전송된 text값은 textFiel화면에 보이지 않도록 초기화
            textField.setText("");
        });


    }

    /**
     * 서버에 접속하는 메소드
     */
    public void connection() {
        try {
            sk = new Socket("127.0.0.1", 8888);
            pw = new PrintWriter(sk.getOutputStream(), true);
            br = new BufferedReader(new InputStreamReader(sk.getInputStream()));

            // 대화명 입력받음
            String name = JOptionPane.showInputDialog(this, "대화명을 입력해주세요");
            //대화명을 보내야  ServerGUIChatExxam의 name = br.readLine(); 다음으로 넘어감
            pw.println(name); // name을 보내면 br.readLine()에서 다음 메시지를 기다리고 있음
            //대화창 상단 title변경
            super.setTitle("[ " + name + "] 님의 대화창");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new ClientGUIChatExam();
    }
}
