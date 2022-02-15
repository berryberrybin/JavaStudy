package ex0215gui.eventExam;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

public class MouseExam extends MouseMotionAdapter {
    JTextField text;

    public MouseExam(JTextField text) {
        this.text = text;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        //마우스 좌표를 구해서 text 박스에 올린다.
        int x = e.getX();
        int y = e.getY();
        // System.out.println("x = " + x + "y =" + y);
        text.setText("x = " + x + ", y =" + y);
    }
}
