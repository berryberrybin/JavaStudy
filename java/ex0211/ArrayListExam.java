package ex0211;

import java.util.ArrayList;

import static java.lang.System.out;

class Test {
    int a = 5;

    public void aa() {
    }

}

class ArrayListExam extends ArrayList<Object> {

    //전역 Variable
    //Object 타입1개, int 타입 1개;

    Object obj;
    int i;


    // 기본 생성자는 초기 용량이 10개로 설정되어 있음
    //Constractor
    public ArrayListExam() {
        super(5);
        //초기 용량 5개로 변경하여 생성 원함
    }

    //method
    //method이름			리턴타입		인수

    /*addInt				없음			정수(int)1개
    하는일 : 인수로 받은 정수를 객체로 만들어 list에 추가.*/
    public void addInt(int i) {
        //Integer it = new Integer(i);
        //super.add(it);
        super.add(i); // int형 i(숫자)를 객체로 변환해서 저장한다(오토박싱때문에 가능)
    }


    /*addFloat				없음			실수(float)1개
        하는일 : 인수로 받은 실수를 객체로 만들어 list에 추가.*/
    public void addFloat(float f) {
        this.add(new Float(f));
    }


    /*addString			없음			String 문자열1개
        하는일 : 인수로 받은 String 을 list에 추가.*/
    public void addString(String s) {
        add(s);
        Test t = new Test();
        add(t);
    }


    /*printList		없음			없음
        정수형 전역변수에 현재 list에 들어있는 객체의 개수 입력한 후 전역변수 출력.
        List에 저장된 각 객체를 맴버변수에 저장한후 출력*/
    public void printList() {
        this.i = super.size();
        out.println("list에 들어있는 객체의 총개수는 " + i);
        for (int index = 0; index < this.i; index++) {
            this.obj = super.get(index);
            out.println(this.obj);
        }
        out.println("-------개선된 for문---------");
        for (Object obj : this) { // super는 독립적으로 사용 불가, this 사용해야함
            out.println(obj);
        }
    }


    public static void main(String args[]) {
        ArrayListExam list = new ArrayListExam();
        String s = new String("newString이다");
        list.addInt(5);
        list.addFloat(5.5F);
        list.addString(s);
        list.printList();
    }
}

/*실행결과

list에 들어있는 객체의 총 개수는=3
5
5.5
newString

Normal Termination
출력 완료 (0초 경과).
*/