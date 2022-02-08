package ex0208;

public class StringExam {
    public static void main(String[] args) {
        int i = 10;
        int j = 10;
        String s1 = "java";
        String s2 = "java";

        String news3 = new String("java");
        String news4 = new String("java");


        if (i == j) { // i==j 같음
            System.out.println("i == j 같음");
        } else {
            System.out.println("다름");
        }

        if (s1 == s2) { // s1 == s2 같음
            System.out.println("s1 == s2 같음");
        } else {
            System.out.println("다름");
        }

        if (news3 == news4) { // news3 와 news 4는 다름
            System.out.println("news3 == news4 같음");
        } else {
            System.out.println("news3와 news4 다름");
        }

        if (s1 == news3) { // s1과 news3 다름
            System.out.println("s1 == news3 같음");
        } else {
            System.out.println("s1과 news3 다름");
        }

        if (s1.equals(s2)) { // s1.equlas(s2) 같음
            System.out.println("s1.equals(s2) 같음");
        } else {
            System.out.println("s1.equals(s2름 다름");
        }

        if (s1.equals(news3)) { // s1.equals(news3) 같음
            System.out.println("s1.equals(news3) 같음");
        } else {
            System.out.println("s1.equals(news3) 다름");
        }

        if (news3.equals(news4)) { // news3.equals(news4) 같음
            System.out.println("news3.equals(news4) 같음");
        } else {
            System.out.println("news3.equals(news4) 다름");
        }

    }
}
