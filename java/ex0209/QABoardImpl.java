package ex0209;

public class QABoardImpl implements BoardInterface {
    @Override
    public boolean insert(Board board) {
        System.out.println("QABoardImpl의 insert call");
        return false;
    }

    @Override
    public boolean update(Board booard) {
        System.out.println("QABoardImpl의 update call");
        return false;
    }

    @Override
    public Board selectByNo(int no) {
        System.out.println("QABoardImpl의 selectByNo call");
        return null;
    }
}
