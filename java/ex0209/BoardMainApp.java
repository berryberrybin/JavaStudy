package ex0209;

public class BoardMainApp {
    BoardInterface bif;

    public static void main(String[] args) {
        new BoardMainApp();
    }

    public BoardMainApp() {
        bif = new FreeBoardImpl();
        test(bif);
        bif = new QABoardImpl();
        test(bif);
        bif = new UploadBoardImpl();
        test(bif);
    }

    public void test(BoardInterface boardInterface) {
        boardInterface.insert(new Board(10, "kim", "제목설정", "내용설정"));

        boardInterface.update(new Board(10, "Park", "제목변경", "내용수정"));

        boardInterface.selectByNo(5);

        boardInterface.delete(10);
        BoardInterface.selectAll(); // static 메소드 호출(구현객체가 필요 없다)
        System.out.println("-----------End------------");
    }
}
