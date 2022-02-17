package ex0216;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameAnonymousExam extends JFrame {

    JButton btn1 = new JButton("클릭1");
    JButton btn2 = new JButton("클릭2");
    JTextField text = new JTextField(10);


    public JFrameAnonymousExam() {
        super("JFrameInnerExam 예제입니다.");

        Container con = super.getContentPane();

        con.setBackground(Color.pink); // 백그라운드 색상 변경
        btn1.setBackground(Color.CYAN);
        // 맥은 2가지 추가해야지 버튼 색상이 변경됨
        btn1.setOpaque(true);
        btn1.setBorderPainted(false);
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

        //정가운데 창 놓기
        super.setLocationRelativeTo(null);

        //JFrame 보여줘
        super.setVisible(true);

        //닫기버튼 눌렀을때 JFrame 종료하기
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //이벤트 등록
        //이벤트 주체 .addXxxListener(이벤트 처리해놓은 객체)
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(++count + "번");
            }
        });
        btn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println(e.getActionCommand() + "클릭되어 종료합니다.");
                System.exit(0);
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                text.setText("X=" + x + ", y=" + y);
            }
        });
        this.addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();
                setTitle("X=" + x + ", Y=" + y);
            }
        });

    }

    int count = 0;

    public static void main(String[] args) {
        new JFrameInnerExam();

    }
} //JFrameExam End
