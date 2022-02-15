package ex0215gui;

import javax.swing.*;
import java.awt.*;

public class JFramExam extends JFrame {

    JButton btn1 = new JButton("클릭1");
    JButton btn2 = new JButton("클릭2");
    JTextField text = new JTextField(10);

    public JFramExam() {
        super("JFrameExam 예제입니다.");

        Container con = super.getContentPane();

        con.setBackground(Color.pink); // 백그라운드 색상 변경
        

        //JFrame의 레이아웃을 변경해보자
        //super.setLayout(new FlowLayout(FlowLayout.RIGHT,0,50)); // 버튼을 왼쪽정렬, 간격은 50
        super.setLayout(new FlowLayout());


        //버튼 2개를 추가해보자
//        super.add(btn1,BorderLayout.NORTH);
//        super.add(btn2, BorderLayout.WEST);

        con.add(btn1);
        con.add(btn2);
        con.add(text);

        //창의 크기 설정
        super.setSize(500, 600);
        //JFrame 보여줘
        super.setVisible(true);

        //닫기버튼 눌렀을때 JFrame 종료하기
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public static void main(String[] args) {
        new JFramExam();

    }
}
