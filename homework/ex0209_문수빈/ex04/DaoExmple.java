package ex0209_문수빈.ex04;

public class DaoExmple {
    public static void dbWork(DataAccessObject dao) {
        dao.select();
        dao.insert();
        dao.update();
        dao.delete();
    }

    public static void main(String[] args) {
        dbWork(new OracleDao());
        dbWork(new MysqlDao());
    }
}
