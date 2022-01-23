package ex0121.method;

class MethodInvoke01 {
    public int method01(int i, int j) {
        int result = i * j;
        System.out.println("두 수의 곱: " + result);
        return result;
    }
}

//다음과 같이 메소드를 작성하세요.

	/*method 이름 : method01
	어디서나 누구나 접근가능
	정수 리턴
	인수로 정수2개 받음
	인수로 들어온 정수 2개를 곱해서 출력하고 리턴*/


class Methodinvoke02 {
    public static int method02(int i, int j) {
        int result = i + j;
        System.out.println("두수의 합: " + result);
        return result;
    }
}
//method 이름 : method02
//어디서나 누구나 접근가능,객체를 생성하지 않고도 접근가능
//정수 리턴
//인수로 정수2개 받음

//인수로 들어온 정수 2개를 더해서 출력하고 더한수 리턴

class MethodInvokeExam {
    public static void main(String[] args) {
        MethodInvoke01 mi = new MethodInvoke01();
        mi.method01(10, 20);
        //MethodInvoke01의 method01 호출

        Methodinvoke02.method02(30, 40);
        //MethodInvoke02의 method02 호출

    }

}
