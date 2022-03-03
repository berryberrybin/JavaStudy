package boardExam;

import java.sql.SQLException;
import java.util.List;

public interface BoardService {

    //모든 레코드 검색
    List<BoardDTO> boardSelectAll() throws SQLException;

    //제목에 특정문자열 포함한 레코드 검색
    List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException;

    //글번호에 해당하는 레코드 검색
    BoardDTO boardSelectByNo(int boardNo) throws SQLException;

    //게시물 등록 (등록하기 전에 글번호 중복체크 - boardSelectByNo(int boardNo))
    public void boardInsert(BoardDTO boardDto) throws SQLException;

    //게시물 수정
    public void boardUpdate(BoardDTO boardDto) throws SQLException;

    //게시물 삭제
    public void boardDelete(int boardNo) throws SQLException;

    //댓글 등록
    void replyInsert(ReplyDTO replyDTO) throws SQLException;

    BoardDTO replySelectByParentNo(int boardNo) throws SQLException;

}
