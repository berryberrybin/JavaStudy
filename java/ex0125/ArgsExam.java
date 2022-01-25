package ex0125.Array;

public class ArgsExam {
    public static void main(String[] args) {
        System.out.println("args =" + args);
        System.out.println("args.length ="+args.length);
        int sum = 0;
        for(int i=0;i<args.length;i++){
            sum = sum + Integer.parseInt(args[i]);
            System.out.println(sum);
        }
    }
}
/*
 실행할때 사용자가 전달해야 하는 값이 있다면 실행할때 값을 전달할 수 있다.
 => 실행할때
 java 파일이름 값1, 값2, 값3
 ex) java ArgsExam 강아지, 30, ABC
*/
