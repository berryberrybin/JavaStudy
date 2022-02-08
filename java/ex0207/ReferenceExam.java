package ex0207;

class ObjectExam {
    public ObjectExam() {
    }

    public ObjectExam(String str) {
    }

    //System.out.println(oe1);할때 주소값이 아닌 "오버라이딩함!!" 이라는 글자가 나오도록 함
    /*
    @Override
    public String toString() {
        return "주소 값이 아닌 값으로 출력되도록 오버라이딩함!!";
    }
     */


    // System.out.println(oe1);// null 출력
    // System.out.println(oe2);// 안녕 출력
    // 되도록 코드 변경
    /*
    String str;
        public ObjectExam(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return str;
    }
    */

    // System.out.println(oe1);// null | 주소값 함께 출력
    // System.out.println(oe2);// 안녕 | 주소값 함께 출력
    // 되도록 코드 변경
    /*
    String str;

    public ObjectExam(String str) {
        this.str = str;
    }

    @Override
    public String toString() {
        return this.str + " | " + super.toString();
        // 여기서 super.생략하면 자기자신 호출해서 무한루프 발생
    }
*/

}

class ReferenceExam {
    public static void main(String[] args) {
        char c = 'a';
        String s01 = "장희정";
        String s02 = "Java";

        String s03 = new String("월요일");

        // s01~s03에는 주소값이 들어있음

        ObjectExam oe1 = new ObjectExam();
        ObjectExam oe2 = new ObjectExam("안녕");

        System.out.println(c);// a
        System.out.println(s01);// 장희정
        System.out.println(s02);// Java
        System.out.println(s03);// 월요일 (주소값을 출력 안함)
        // system.out.println(Object obj) 메소드는 인수로 전달된 obj.toString()을 호출함
        // => Object에 정의되어 있는 toString()메소드는 return getclass().getName()+'@'+Integer.toHexString(hashCode())
        //    즉, class이름@hashcode 형태로 문자열로 만들어서 리턴해준다.

        // s01~03 안에는 객체 주소값이 들어있지만 toString에 의해서 주소값이 아닌 값이 출력됨
        // why?  String 클래스 에서 toString()메소드가 오버라이딩 되어있기 때문
        //        => return  string itself
        //        주소값이 아닌 실제 저장된 값이 리턴되도록 되어있음

        System.out.println(oe1);// 주소값 출력됨
        System.out.println(oe2);// 주소값 출력됨
    }
}