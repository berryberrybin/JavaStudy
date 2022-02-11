package ex0211.sutdentListExam;

import java.util.List;

public class StudentMainApp {
    public static void main(String[] args) {
        StudentService service = new StudentServiceIml();
        System.out.println("1.전체검색");
        List<Student> list = service.selectAll();
        printList(list);
        service.selectAll();

        System.out.println("2.등록하기(중복불가)");
        boolean result = service.insert(new Student("A06", "Na", 27, "서울"));
        System.out.println("result : " + result);
        printList(list);

        System.out.println("2.등록하기(중복인 경우)");
        result = service.insert(new Student("A03", "Na", 27, "서울"));
        System.out.println("result : " + result);
        printList(list);


        System.out.println("3.학번에 해당하는 정보 검색(존재하는 경우)");
        Student st = service.selectBySno("A04");
        System.out.println("st= " + st);

        System.out.println("3.학번에 해당하는 정보 검색(없는 경우)");
        st = service.selectBySno("A09");
        System.out.println("st= " + st);

        System.out.println("--------------수정하기--------------");
        System.out.println("4.학번에 해당하는 정보 수정");
        result = service.update(new Student("A03", 55, "전주"));
        System.out.println("result = " + result);


        System.out.println("4.학번에 해당하는 정보 수정(수정 안하는 경우)");
        result = service.update(new Student("A10", 100, "미국"));
        System.out.println("result = " + result);

        list = service.selectAll();
        printList(list);


        System.out.println("5.학번에 해당하는 정보 삭제");
        result = service.delete("A04");
        System.out.println("result=" + result);

        System.out.println("5.학번에 해당하는 정보 삭제(삭제불가)");
        result = service.delete("A100");
        System.out.println("result=" + result);

        list = service.selectAll();
        printList(list);


    }

    //List 출력하기
    public static void printList(List<Student> list) {
        System.out.println("-----총 " + list.size() + "명--------");
        for (Student st : list) {
            System.out.println(st);
        }
        System.out.println();
    }
}
