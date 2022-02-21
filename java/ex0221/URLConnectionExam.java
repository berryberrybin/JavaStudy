package ex0221;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;

public class URLConnectionExam {

    public URLConnectionExam() {
        try {
            URL url = new URL("https://www.daum.net");
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
            BufferedWriter bw = new BufferedWriter(new FileWriter("java/ex0221/daum.txt"));

            String data = null;
            while ((data = br.readLine()) != null) {
                System.out.println(data);
                bw.write(data);
                bw.newLine();
                bw.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new URLConnectionExam();
    }
}
