package ex0209;

public interface BoardInterface {
    //등록하기
    boolean insert(Board board);

    //수정하기
    boolean update(Board booard);

    //글번호로 검색하기
    Board selectByNo(int no);
}
