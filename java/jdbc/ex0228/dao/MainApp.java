package jdbc.ex0228.dao;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("-- 1. 사원이름 검색 -- ");
        EmpDAO dao = new EmpDAO();
        // dao.selectNames();

        System.out.println("--2. 사원등록 검색  --");
        //dao.insert(new Emp(8999, "jung", "teacher", 800));
        dao.preparedInsert(new Emp(8700, "ABBB", "doctor", 100));
    }
}
