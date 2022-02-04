package ex0203;

import java.awt.*;

public class BeepThread extends Thread {
    @Override
    public void run() {
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        for (int i = 0; i < 10; i++) {
            toolkit.beep();
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
