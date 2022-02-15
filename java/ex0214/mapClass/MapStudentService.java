package ex0214.mapClass;

import java.util.HashMap;
import java.util.Map;

public class MapStudentService {

    private Map<String, Person> map = new HashMap<>();

    /**
     * 생성자를 이용해서 map에 초기치 데이터 저장
     */

    public MapStudentService() {
        //map.put(null, new Student(null, null, 0,0,0,0));
        //map.put(null, new Person(null, null, 0));
        map.put("A01", this.create("A01", "kimPerson", 35));
        map.put("A02", this.create("A02", "moonPerson", 40));

        map.put("S01", this.create("S01", "parkStudent", 17, 80, 90, 60));
        map.put("S02", this.create("S02", "jangStudent", 18, 85, 50, 75));
        map.put("S03", this.create("S03", "kimStudent", 17, 35, 65, 45));

    }

    /**
     * Student 또는 Person을 생성해서 리턴해주는 메소드
     */
    public Person create(String id, String name, int age, int... params) {
//  public Person create(String id, String name, int age, int kor, int eng, int math) {
        // Student일때는 int kor, eng, math를 받아야 하지만 Person은 필요없음
        // int ... params (0개 이상 int값 의미)

        if (params.length == 0) {
            return new Person(id, name, age);
        } else if (params.length == 3) {
            return new Student(id, name, age, params[0], params[1], params[2]);
        } else {
            throw new RuntimeException("전달된 인수가 잘못되어 생성할 수 없음");
        }
    }

    /**
     * 전체검색
     */
    public Map<String, Person> selectAll() {
        if (map.isEmpty() || map.size() == 0) {
            throw new RuntimeException("저장된 정보가 없습니다.");
        }
        return map;
    }

    /**
     * key 에 해당하는 정보 검색하기
     * key해당하는 정보를 출력할때
     * -  Person인경우는 이름만 출력 Student인경우는 이름과 총점 출력  -> EndView에서
     * - 없는경우는 "id는 없습니다." 예외발생
     */
    public Person searchByKey(String key) { //key는 id
        Person person = map.get(key);
        if (person == null)
            throw new RuntimeException(key + "에 해당하는 정보는 없습니다.");
        return person;
//        if (!map.containsKey(key)) {
//            throw new RuntimeException("id는 없습니다.");
//        }
//        return map.get(key);
    }

    /**
     * 등록하기
     * key(id로 관리)와 Person의 정보를 받아 등록하는 메소드
     * 등록이 실패하면(id중복체크!!) 예외발생시킨다.("등록되지 않았습니다.")
     */
    public void insert(Person person) { // student or person이 상황에 따라 들어 올 수 있다.
        if (map.containsKey(person.getId())) {
            throw new RuntimeException(person.getId() + "중복된 아이디이므로 등록되지 않았습니다.");
        } else {
            map.put(person.getId(), person);
        }
    }

    /**
     * 삭제하기: id에 해당하는 value가 삭제되지 않으면 예외발생
     * (삭제되지 않았습니다.)
     */
    public void delete(String key) {
        Person person = map.remove(key);
        if (person == null) {
            throw new RuntimeException(key + " 에 해당하는 정보를 삭제할 수 없습니다.");
        }
//        if (!map.containsKey(key)) {
//            throw new RuntimeException("삭제되지 않았습니다.");
//        } else {
//            map.remove(key);
//        }
    }

    /**
     * 수정하기정
     * Person인경우 이름만 수정
     * Student인경우  이름, 국어 ,영어,수학수정(총점 변경)
     * 수정이 안된다면 예외발생
     */
    public void update(Person person) {
        Person searchPerson = map.get(person.getId());
        if (searchPerson == null) {
            throw new RuntimeException(person.getId() + "는 잘못되어 수정할 수 없습니다.");
        }
//        if (!map.containsKey(person.getId())) {
//            throw new RuntimeException("수정이 안됨");
//        }

        if (person instanceof Student) {
            if (searchPerson instanceof Student) {
                Student searchStudent = (Student) person;
                Student elementStudent = (Student) map.get(person.getId());
                elementStudent.setName(searchStudent.getName());
                elementStudent.setKor(searchStudent.getKor());
                elementStudent.setEng(searchStudent.getEng());
                elementStudent.setMath(searchStudent.getMath());

            } else {
                throw new RuntimeException("타입 오류로 수정에 실패했습니다.");
            }
        } else {
            searchPerson.setName(person.getName());
        }
    }
}
