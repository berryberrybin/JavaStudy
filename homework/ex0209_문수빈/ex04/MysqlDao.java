package ex0209_문수빈.ex04;

public class MysqlDao implements DataAccessObject {
    @Override
    public void select() {
        System.out.println("MYSql DB에서 검색");
    }

    @Override
    public void insert() {
        System.out.println("MYSql DB에서 삽입");
    }

    @Override
    public void update() {
        System.out.println("MYSql DB에서 수정");
    }

    @Override
    public void delete() {
        System.out.println("MYSql DB에서 삭제");
    }

}
