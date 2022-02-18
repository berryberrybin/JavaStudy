package ex0217;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.*;

public class MenuExam extends JFrame {
    JMenuBar menuBar = new JMenuBar();
    JMenu file = new JMenu("파일(F)");
    JMenu edit = new JMenu("편집");
    JMenu help = new JMenu("Help");
    JMenu align = new JMenu("정렬");
    JMenuItem nFile = new JMenuItem("새파일");
    JMenuItem open = new JMenuItem("열기");
    JMenuItem save = new JMenuItem("저장");
    JMenuItem exit = new JMenuItem("종료");


    JCheckBoxMenuItem name = new JCheckBoxMenuItem("이름");
    JCheckBoxMenuItem date = new JCheckBoxMenuItem("날짜");

    JMenuItem info = new JMenuItem("정보");

    JTextArea text = new JTextArea();
    JScrollPane jsp = new JScrollPane(text, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);

    JDialog dialog = new JDialog(this, "help");
    JLabel dName = new JLabel("kang seok min");
    JButton enter = new JButton("확 인");


    BufferedInputStream bi = null;

    public MenuExam() {
        super("제목없음");
        Container con = getContentPane();

        //메뉴 단축키
        file.setMnemonic('F'); //Alt + F

        //메뉴아이템에 단축키
        nFile.setAccelerator(KeyStroke.getKeyStroke('N', InputEvent.CTRL_DOWN_MASK));
        save.setAccelerator(KeyStroke.getKeyStroke('S', InputEvent.CTRL_MASK));
        open.setAccelerator(KeyStroke.getKeyStroke('O', InputEvent.CTRL_MASK));
        exit.setAccelerator(KeyStroke.getKeyStroke('E', InputEvent.CTRL_MASK ^ InputEvent.ALT_MASK));

        menuBar.add(file);
        menuBar.add(edit);
        menuBar.add(help);

        file.add(nFile);
        file.add(save);
        file.add(open);
        file.addSeparator();
        file.add(exit);

        edit.add(align);
        align.add(name);
        align.add(date);

        help.add(info);

        setJMenuBar(menuBar);
        con.add(jsp);

        Toolkit toolkit = getToolkit();
        Dimension dim = toolkit.getScreenSize();
        int screenWidth = dim.width;
        int screenHeight = dim.height;

        dName.setHorizontalAlignment(JLabel.CENTER);
        dialog.add(dName, "Center");
        dialog.add(enter, "South");
        dialog.setBounds(((screenWidth - 200) / 2), ((screenHeight - 200) / 2), 200, 200);

        setBounds(((screenWidth - 500) / 2), ((screenHeight - 500) / 2), 500, 500);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        nFile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                text.setText(""); // text.append("");//끝에 추가!!!!
                MenuExam.this.setTitle("제목없음");
            }
        });


        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        info.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.setVisible(true);

            }
        });
        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dialog.dispose();//다이얼로그창만 닫기
            }
        });

        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                FileDialog fileSave = new FileDialog(MenuExam.this, "Save", FileDialog.SAVE);
                // FileDaialog - 저장(SAVE), 열기(LOAD)
                fileSave.setVisible(true);

                String dir = fileSave.getDirectory();
                String fileName = fileSave.getFile();
                String data = text.getText();
                //방법 1
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(dir + "/" + fileName))) {
                    // 교재 486 ~487
                    // data = data.replace("\n",System.getProperty("line.separator")); 시스템에 따라 줄바꿈이 달라지는 상황 방지
                    bw.write(data); // text.getText(); textArea영역에 있는 모든 문자열을 하나의 String으로 가져온다.
                    bw.flush();
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
                // 방법 2
                try (BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dir + "/" + fileName))) {
                    bos.write(text.getText().getBytes()); //String 데이터를 byte타입 배열로 바꿔서 저장.
                    MenuExam.this.setTitle(fileName);
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        });
        // FileDialog는 awt에서 제공, FileChooser는 swing에서 제공
        open.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFileChooser fileOpen = new JFileChooser();
                int mode = fileOpen.showOpenDialog(MenuExam.this);
                //fileOpen 모드 2가지 : showOpenDialog showSaveDialog
                System.out.println("mode : " + mode);

                // 방법 1
                File file = fileOpen.getSelectedFile();
                try (BufferedInputStream bis = new BufferedInputStream(new FileInputStream(file))) {
                    byte[] b = new byte[bis.available()]; // byte배열 b에 파일을 읽어드림
                    bis.read(b);
                    String data = new String(b);
                    text.setText(data);
                    setTitle(file.getName());
                } catch (Exception exception) {
                    exception.printStackTrace();
                }

                // 방법 2
                if (mode == JFileChooser.APPROVE_OPTION) {
                    //열기한 파일을 읽어서 textArea에 넣는다.
                    try (BufferedReader br = new BufferedReader(new FileReader(fileOpen.getSelectedFile()))) {
                        String s;
                        while ((s = br.readLine()) != null) {
                            text.append(s + "\n"); // 마지막에 무조건 \n이 들어감
                            //text.setText(s);
                        }
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                }
            }
        });

    }

    public static void main(String[] args) {
        new MenuExam();
    }

}










