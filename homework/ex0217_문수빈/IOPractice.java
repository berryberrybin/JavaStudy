package ex0217_문수빈;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.Scanner;

public class IOPractice {
    private Scanner sc = new Scanner(System.in);
    private static final String DIRECTORY = "homework/ex0217_문수빈/";

    public void inputAndSave() {
        String[] info = inputInfo();
        saveInfo(info);
    }

    public void findAndPrint() {
        String name = inputName();
        printInfo(name);
    }

    private String[] inputInfo() {
        String[] info = new String[3];
        System.out.print("이름 : ");
        info[0] = sc.nextLine();
        System.out.print("몸무게 : ");
        info[1] = sc.nextLine();
        System.out.print("비번 : ");
        info[2] = sc.nextLine();
        return info;
    }

    private void saveInfo(String[] info) {
        String fileName = DIRECTORY + info[0] + ".txt";
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileName))) {
            bw.write(info[1]);
            bw.write(":");
            bw.write(info[2]);
            bw.flush();
            System.out.println(fileName + "에 저장했습니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String inputName() {
        System.out.print("찾을 이름을 입력하세요 > ");
        String name = sc.nextLine();
        return name;
    }

    private void printInfo(String name) {
        String fileName = DIRECTORY + name + ".txt";
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String[] info = br.readLine().split(":");
            System.out.print(name + "님의 몸무게는 " + info[0] + "이고, 비번은 " + info[1] + "입니다.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        IOPractice iop = new IOPractice();
        iop.inputAndSave();
        iop.findAndPrint();
    }

}
