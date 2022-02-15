package ex0214.mapClass;

import java.util.Map;

public class EndView {
    /**
     * 전체검색 출력
     */

    public static void printAll(Map<String, Person> map) {
        System.out.println("--------- 정보 ( " + map.size() + " )명---------");
        for (String key : map.keySet()) {
            Person p = map.get(key); // person 또는 student
            System.out.println(p);
        }

//        Set<Map.Entry<String, Person>> entrySet = map.entrySet();
//        Iterator<Map.Entry<String, Person>> entryIterator = entrySet.iterator();
//        System.out.println("--------- 정보 ( " + map.size() + " )명---------");
//        for (Map.Entry<String, Person> entry : map.entrySet()) {
//            System.out.println(entry);
//        }
    }

    /**
     * key==id에 해당하는 정보 출력
     */
    public static void printSearch(Person person) {
        System.out.println("이름 : " + person.getName());
        if (person instanceof Student) {
            Student student = (Student) person;
            System.out.println(" | 총점 : " + student.getSum());
        }
    }

    /**
     * 성공 또는 실패에 관련된 메시지 출력
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
