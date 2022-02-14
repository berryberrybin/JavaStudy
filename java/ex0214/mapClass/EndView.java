package ex0214.mapClass;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class EndView {
    /**
     * 전체검색 출력
     */

    public static void printAll(Map<String, Person> map) {
        Set<Map.Entry<String, Person>> entrySet = map.entrySet();
        Iterator<Map.Entry<String, Person>> entryIterator = entrySet.iterator();
        System.out.println("--------- 정보 ( " + map.size() + " )명---------");
        for (Map.Entry<String, Person> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }

    /**
     * key==id에 해당하는 정보 출력
     */
    public static void printSearch(Person person) {
        if (person instanceof Student) {
            Student student = (Student) person;
            System.out.println("이름 : " + student.getName() + " 총점 : " + student.getSum());
        } else {
            System.out.println("이름 : " + person.getName());
        }
    }

    /**
     * 성공 또는 실패에 관련된 메시지 출력
     */
    public static void printMessage(String message) {
        System.out.println(message);
    }
}
