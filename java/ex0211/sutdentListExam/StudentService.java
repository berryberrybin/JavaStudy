package ex0211.sutdentListExam;

import java.util.List;

//학생의 정보를 CRUD작업을 하는 서비스 영역
public interface StudentService {

    //등록하기
    boolean insert(Student student);

    //전체검색
    List<Student> selectAll();
    //ArrayList<Student> selectAll();


    //학번에 해당하는 정보 검색
    Student selectBySno(String sno);

    //학번에 해당하는 학생 삭제
    boolean delete(String sno);

    //학벙에 해당하는 학생의 정보 수정하기(나이, 주소만 변경 가능)
    boolean update(Student student);
}
