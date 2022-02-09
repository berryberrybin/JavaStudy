package ex0209;

public class FreeBoardImpl implements BoardInterface {
    @Override
    public boolean insert(Board board) {
        System.out.println("FreeBoarImpl의 insert call");
        return false;
    }

    @Override
    public boolean update(Board booard) {
        System.out.println("FreeBoarImpl의 update call");

        return false;
    }

    @Override
    public Board selectByNo(int no) {
        System.out.println("FreeBoarImpl의 selectByNo call");
        return null;
    }
}
