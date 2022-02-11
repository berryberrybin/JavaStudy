package ex0211;

import java.util.Calendar;
import java.util.GregorianCalendar;

class PrintfExam {
    public static void main(String[] args) {
        //%d 숫자1개 의미
        //%d%d 숫자 2개 의미
        System.out.println("1----------");
        System.out.printf("%d%d%n", 20, 30); // 2030
        System.out.printf("%d , %d%n", 20, 30); // 20 , 30 (공백도 추가 가능)
        System.out.println();

        // %,d (%와 d사이에 ,컴마가 들어가면 3자리마다 ,찍어줌)
        System.out.println("2------------");
        System.out.printf("가격 : %,d원%n", 25320000); // 가격 : 25,320,000원
        System.out.printf("%5.2f%n", 35.33333); // 35.33 (소수점 2째자리 까지 출력)
        System.out.println();

        System.out.println("3--------");
        System.out.printf("%d년  %d월 %d일%n", 2009, 5, 3);
        //2$ -> 3$ -> 1$ 순서로 출력
        System.out.printf("%2$d년 %3$d월 %1$d일%n", 1, 2005, 3); // 2$ 위치인 2005가 먼저 출력됨

        System.out.println("4----------");
        Calendar now = Calendar.getInstance();
        System.out.println("\nYear=>" + now.get(Calendar.YEAR));
        System.out.println("month=>" + (now.get(Calendar.MONTH) + 1)); // January가 0부터 시작함
        System.out.println("date=>" + now.get(Calendar.DATE) + "\n");


        System.out.println("5---------------");
        Calendar today = new GregorianCalendar(); // 현재 날짜와 시간이 설정
        System.out.println(today);
        System.out.printf("%tY년 %tm월 %td일 %tH시 : %tM분 : %tS초%n", today, today, today, today, today, today);
        System.out.printf("%1$tY년 %1$tm월 %1$td일 %1$tH시 : %1$tM분 : %1$tS초%n", today);
        System.out.println();

        System.out.println("6--------------------");
        // 10 10칸오른쪽 정렬  <->  -10 10칸 왼쪽정렬
        System.out.printf("%3d %10s %-8s %-5d%n", 1, "jang", "장희정", 20);
        System.out.printf("%3d %10s %-8s %-5d%n", 22, "hee", "정효욱", 03);
        System.out.printf("%3d %-10s %8s %-5d%n", 3, "rew97", "장정희", 20);
        System.out.printf("%3d %-10s %8s %-5d%n", 4, "jang", "장희정", 20);
    }
}
