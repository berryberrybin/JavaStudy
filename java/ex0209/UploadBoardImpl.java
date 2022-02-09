package ex0209;

public class UploadBoardImpl implements BoardInterface {

    @Override
    public boolean insert(Board board) {
        System.out.println("UploadBoardImpl의 insert call");
        return false;
    }

    @Override
    public boolean update(Board booard) {
        System.out.println("UploadBoardImpl의 update call");
        return false;
    }

    @Override
    public Board selectByNo(int no) {
        System.out.println("UploadBoardImpl의 selectByNo call");
        return null;
    }
}
