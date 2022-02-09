package ex0209;

public interface BoardInterface {
    //등록하기
    boolean insert(Board board);

    //수정하기
    boolean update(Board booard);

    //글번호로 검색하기
    Board selectByNo(int no);

    default int delete(int no) {
        System.out.println("공통의 삭제 기능입니다.");
        return 1;
    }

    static Board[] selectAll() {
        System.out.println("공통의 전체 검색 기능입니다~ ");
        return null;
    }
}
