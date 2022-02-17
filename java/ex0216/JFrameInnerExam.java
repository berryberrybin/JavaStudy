package ex0216;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class JFrameInnerExam extends JFrame implements ActionListener {

    JButton btn1 = new JButton("클릭1");
    JButton btn2 = new JButton("클릭2");
    JTextField text = new JTextField(10);


    public JFrameInnerExam() {
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
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        this.addMouseMotionListener(new MouseExam());
        this.addMouseMotionListener(new MouseExam02());

    }

    public static void main(String[] args) {
        new JFrameInnerExam();

    }

    int count;

    @Override
    public void actionPerformed(ActionEvent e) {
        //이벤트를 발생시키는 주체 얻기
        Object obj = e.getSource();
        if (obj == btn1) {
            System.out.println(e.getActionCommand() + "버튼이 눌러짐");
            //버튼이 눌러진 횟수를 text 박스에 보이도록
            text.setText(count++ + "번");
        } else if (obj == btn2) {
            System.out.println(e.getActionCommand() + "버튼이 눌러져 종로함");
            System.exit(0);
        }
    }

    class MouseExam extends MouseMotionAdapter {
        @Override
        public void mouseDragged(MouseEvent e) {
            //마우스 좌표를 구해서 text 박스에 올린다.
            int x = e.getX();
            int y = e.getY();
            text.setText("x = " + x + ", y =" + y);
        }
    }

    class MouseExam02 extends MouseAdapter {
        @Override
        public void mouseClicked(MouseEvent e) {
            int x = e.getX();
            int y = e.getY();
            //Outer클래스쪽의 객체를 접근하는 방법 : Outer클래스의 이름.this
            JFrameInnerExam.this.setTitle("x = " + x + ", y= " + y);
            //Jframe의 글씨 변경
            btn1.setText("x = " + x + ", y= " + y);
        }
    }
} //JFrameExam End