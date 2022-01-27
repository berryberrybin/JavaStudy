package ex0127;

class Puppy3 {
    // 전역변수 2가지 생성 (String 타입, int 타입)
    String str;
    int i;

    //인수가 없는 생성자 작성 (String 타입 전역변수에 "메리" 할당)
    Puppy3() {
        this.str = "메리";
        System.out.println("public Puppy3()호출되었습니다.");
        System.out.println("전역변수 str = " + this.str + "i =" + i);
    }


    // String타입 인수 1개 받는 생성자 작성 (String타입 전역변수에 "인수"를 할당)
    Puppy3(String str) {
        this.str = str; // 매개변수와 전역변수 변수명이 동일하므로 this. 필수임
        System.out.println("public Puppy3(String str)호출되었습니다.");
        System.out.println("전역변수 str = " + this.str + "i =" + i);
    }


	// String타입의 인수 2개를 받는 생성자 작성
	// 인수 2개를 하나의 String으로 만들어 String타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
    Puppy3(String s1, String s2) {
        this(s1 + s2);   // 다른 생성자 호출시 구현부 첫번째줄에서만 가능!!
                            // String s = s1+s2; 사용하여 this(s); 사용불가
                           // Puppy3(s1+s2); 문법은 없음
        System.out.println("public Puppy3(String s1, String s2)호출되었습니다.");
    }


	// boolean타입의 인수 1개 받는 생성자작성
	// 인수를 "쫑"과 붙여 하나의 String으로 만들어 String 타입의 인수 1개를 받는 생성자에게 인수로 주며 호출
    Puppy3(boolean b) {
        this(b + "쫑");
        System.out.println("public Puppy3(boolean b)호출되었습니다.");
    }


	// char 타입의 인수 1개를 받는 생성자작성
	// 인수가 없는 생성자를 호출하고, 인수로 받은 data를 int타입 전역변수에 할당
    Puppy3(char ch) {
        this();
        this.i = ch;
        System.out.println("public Puppy3()호출되었습니다.");
        System.out.println("전역변수 i =" + i);
    }


	// 메소드 printMemberVariable (리턴 없음, 전역변수 출력)
    public void printMemberVariable() {
        System.out.println("-------printMemberVariable()----------");
        System.out.print("전역변수 Str : " + this.str+"\t");
        System.out.print("전역변수 int : " + this.i + "\n");
    }
}

class ConstructorOverloadingExam {
    public static void main(String[] args) {
        //Puppy3 클래스의 각 생성자를 한번씩 이용해 객체 5개 생성
        Puppy3 p1 = new Puppy3();
        // p1 객체 생성시 실제 메모리 공간안에는 1~5까지 모든 생성자 만들어지며, 인수없는 생성자가 호출될 뿐임.
        Puppy3 p2 = new Puppy3("JAVA");
        // p2 객체 생성시 실제 메모리 공간안에는 1~5까지 모든 생성자 만들어지며, String 인수로 받는 생성자가 호출될 뿐임.
        Puppy3 p3 = new Puppy3("abc", "가나다");
        // p3 객체 생성시 실제 메모리 공간안에는 1~5까지 모든 생성자 만들어짐, String타입의 인수 2개를 받는 생성자 호출됨
        // this(s1+s2)일때 p2의 Str이 변경되는 것이 아님 (p2객체와 무관)
        // p3 객체 공간내 1~5 중 String 인수로 받는 생성자가 호출되며, p3의 str이 변경됨
        Puppy3 p4 = new Puppy3(true);
        Puppy3 p5 = new Puppy3('A');

        p1.printMemberVariable();
        p2.printMemberVariable();
        p3.printMemberVariable();
        p4.printMemberVariable();
        p5.printMemberVariable();
        //각 객체의 printMemberVariable메소드를 한번씩 호출
    }
}