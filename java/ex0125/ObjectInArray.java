package ex0125.Array;

class ObjectOne{
    public int a;
}

public class ObjectInArray {
    public static void main(String[] args) {
        ObjectOne [] objectArray = new ObjectOne[5]; //ObjectOne 타입을 5개 까지 저장하는 배열선언

        //주소값 출력
        for(int i=0;i<objectArray.length;i++){
            System.out.print("생성전 objectArray["+i +"] : "+objectArray[i]+"\t");

            objectArray[i] = new ObjectOne();
            System.out.print("-> 생성후 objectArray["+i +"] : "+objectArray[i]+"\n");
        }

        System.out.println("===============================");
        // ObjectOne객체의 a를 출력
        for(int i=0;i<objectArray.length;i++){
            System.out.print("변경전 objectArray["+i +"] : "+ objectArray[i].a+"\t");
            objectArray[i].a = i+10;
            System.out.print("-> 변경후objectArray["+i +"] : "+ objectArray[i].a+"\n");
        }
    }
}
