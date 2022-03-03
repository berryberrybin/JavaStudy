package boardExam;

import java.sql.SQLException;
import java.util.List;

public interface BoardDAO {

    //    레코드 전체검색
    List<BoardDTO> boardSelectAll() throws SQLException;

    //    제목에 특정 문자열에 포함된 레코드 검색
//    select * from board where subject like ?
    List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;

    //    글번호에 해당하는 레코드 검색
//    select * from baord where board_no = ?
    public BoardDTO boardSelectByNo(int boardNo) throws SQLException;

    //    게시물 등록하기
//    insert into board(board_no, subject, writer, content, board_date) values(board_seq.nextval, ? , ? , ? , sysdate)
    public int boardInsert(BoardDTO boardDTO) throws SQLException;

    //    글번호에 해당하는 게시물 내용 수정하기
//    update board set content = ? where board_no = ?
    public int boardUpdate(BoardDTO boardDto) throws SQLException;

    //    글번호에 해당하는 레코드 삭제
//    delete from board where board_no = ?
    public int boardDelete(int boardNo) throws SQLException;

    //댓글 등록하기
    int replyInsert(ReplyDTO replyDTO) throws SQLException;

    /*
    부모글에 해당하는 댓글정보 검색하기
	select * from board where board_no=?
    select * from reply where board_no=?
     조인경우 ; select * from board join reply using(board_no)  where board_no=?
     */

    //부모글에 해당하는 댓글 정보 검색하기
    //BoardDTO 타입으로 선언함
    BoardDTO replySelectByParentNo(int boardNo) throws SQLException;

}
