package ex0215gui.eventExam;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class MouseExam02 extends MouseAdapter {
    JFramEventExam jfe;

    public MouseExam02(JFramEventExam jfe) {
        this.jfe = jfe;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        //System.out.println("x = "+x+"y="+y);
        //Jframe의 title을 좌표로 변경하고
        jfe.setTitle("x = " + x + ", y= " + y);
        //Jframe의 글씨 변경
        jfe.btn1.setText("x = " + x + ", y= " + y);
    }
}
