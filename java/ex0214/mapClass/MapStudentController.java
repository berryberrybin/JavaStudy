package ex0214.mapClass;

import java.util.Map;

public class MapStudentController {

    private static MapStudentService service = new MapStudentService();

    /**
     * 전체검색
     */
    public static void selectAll() {
        try {
            //서비스를 호출하고, 그 결과를 받아서 결과 뷰로 이동
            Map<String, Person> map = service.selectAll();
            EndView.printAll(map);
        } catch (RuntimeException e) {
            EndView.printMessage(e.getMessage());
        }
    }


    /**
     * Key(id)에 해당하는 정보 검색하기
     */

    public static void searchById(String id) {
        try {
            Person person = service.searchByKey(id);
            EndView.printSearch(person);
        } catch (RuntimeException e) {
            EndView.printMessage(e.getMessage());
        }
    }

    /**
     * 등록하기
     */
    public static void insert(Person person) {
        try {
            service.insert(person);
        } catch (RuntimeException e) {
            EndView.printMessage(e.getMessage());
        }
    }

    /**
     * 삭제하기
     */
    public static void delete(String id) {
        try {
            service.delete(id);
        } catch (RuntimeException e) {
            EndView.printMessage(e.getMessage());
        }
    }

    /**
     * 수정하기
     */
    public static void update(Person person) {
        try {
            service.update(person);
        } catch (RuntimeException e) {
            EndView.printMessage(e.getMessage());
        }
    }

}
