package ex0124.overloading;

//MethodOverloadingExam.java
class OverloadedMethod{
	private int i; // 전역변수

	public void  setOverload(int i){
		System.out.println("setOverload(int i)메소드 호출함");
		this.i = i; // 인수로 전달된 i의 값을 전역변수 i에 저장한다.
	}

	public int setOverload(){
		System.out.println("setOverload()메소드 호출함");
		return 10;
	}

	public String setOverload(String s){
		System.out.println("setOverload(String s)메소드 호출함");
		return s+ "복숭아";
	}

	private void setOverload(char c){
		System.out.println("setOverload(char c)메소드 호출함");
	}
	//setOverload를 Overloading하세요. 리턴도 하세요.

	//setOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.

	//setOverload를 또 또Overloading 하세요. 리턴 안해요

	public int getOverload(){
		System.out.println("getOverload()메소드 호출함");
		return i; // 전역변수 i의 값
	}

	public int getOverload(int i){
		System.out.println("getOverload(int i)메소드 호출함");
		return i*10;
	}

	protected boolean getOverload(int i, int j){
		System.out.println("getOverload(int i, int j)메소드 호출함");
		return true;
	}

	public void getOverload(short sh){
		System.out.println("getOverload(short sh)메소드 호출함");
	}
	//getOverload를 Overloading하세요. 리턴도 하세요.

	//getOverload를 또 Overloading 하세요. 또 다른 놈으로 리턴 하세요.

	//getOverload를 또 또Overloading 하세요. 리턴 안해요


}

class  MethodOverloadingExam{

	public static void main(String [] agr){
		OverloadedMethod om = new OverloadedMethod();
		int re = om.setOverload();
		System.out.println("결과 "+ re);
		om.setOverload("과일");
		om.setOverload('A'); // setOverload(int i)메소드 호출함, 현재 char을 인자로 받는 메소드가 private이므로

		om.getOverload(2);
		om.getOverload(100, 200);
		om.getOverload((short)5);
		//OverloadedMethod객체에서 호출가능한  메소드들을 한번씩 호출하세요.

	}


}

