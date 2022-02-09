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

    @Override
    public int delete(int no) {
        System.out.println(" FreeBoaordImpl의 delet입니다~ ");
        return 2;
    }


}
