package ex0127;


//ConstructorExam.java
class Puppy{
    //String,int  타입 전역 변수 선언(member 변수선언)
    String name;
    int age;

	// 메소드 printPuppyName작성(인수없음, 리턴안함)
    public void printPuppyName(){
        System.out.println("public void printPuppyName() 호출");
        // 전역변수 출력
        System.out.println("this.name : " + this.name);
        System.out.println("this.age : "+ this.age);
    }

	// 인수가 없는 생성자 작성
    public Puppy(){ // 리턴타입 없음, 클래스 이름과 반드시 동일해야 함
        System.out.println("생성자 public Puppy() 호출"); // printPuppyName메소드 호출
        this.printPuppyName();
        this.name = "메리"; //  전역변수 String에"메리" 할당
        this.age = 5; //  전역변수 int에 5 할당

    }

}
class ConstructorExam{
    //메인메소드에서
    public static void main(String [] agrs){
        //Puppy객체 생성
        Puppy p = new Puppy();
               // 1) 전역필드 초기화 : String name에는 null을 int age에는 0으로 초기화
               // 2) 생성자를 호출함 : 생성자 구현부 실행 & 명시적 초기화(입력값으로 초기화)

        System.out.println("-------------------");
        p.printPuppyName();   //Puppy객체의 printPuppyName메소드 호출
    }
}

