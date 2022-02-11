package ex0211.sutdentListExam;

import java.util.ArrayList;
import java.util.List;

public class StudentServiceIml implements StudentService {
    private List<Student> list = new ArrayList<Student>();

    // 5명의 학생의 데이터를 세팅하기 위한 생성자
    public StudentServiceIml() {
        list.add(new Student("A01", "kim", 20, "서울"));
        list.add(new Student("A02", "park", 23, "부산"));
        list.add(new Student("A03", "Lee", 25, "대구"));
        list.add(new Student("A04", "Kim", 28, "제주도"));
        list.add(new Student("A05", "Moon", 21, "대전"));
    }

    @Override
    public boolean insert(Student student) {
        if (this.selectBySno(student.getSno()) != null) {
            return false;
        }
        return list.add(student);
    }

    @Override
    public List<Student> selectAll() {
        return list;
    }

    @Override
    public Student selectBySno(String sno) {
        for (Student student : list) {
            if (student.getSno().equals(sno)) {
                return student;
            }
        }
        return null;
    }

    @Override
    public boolean delete(String sno) {
        return list.remove(selectBySno(sno));
    }

    @Override
    public boolean update(Student student) {
        Student st = selectBySno(student.getSno());
        if (st != null) {
            st.setAge(student.getAge());
            st.setAddr(student.getAddr());
            return true;
        }
        return false;
    }
}
