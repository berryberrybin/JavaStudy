package boardExam;

import java.sql.SQLException;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    private BoardDAO boardDAO = new BoardDAOImpl();

    @Override
    public List<BoardDTO> boardSelectAll() throws SQLException {

        List<BoardDTO> boardDTOList = boardDAO.boardSelectAll();
        if (boardDTOList.size() == 0 || boardDTOList.isEmpty()) {
            throw new SQLException("저장된 게시물이 없습니다.");
        }
        return boardDTOList;
    }

    @Override
    public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
        List<BoardDTO> boardDTOList = boardDAO.boardSelectBySubject(keyWord);
        if (boardDTOList.isEmpty()) {
            throw new SQLException(keyWord + " 를 포함한 제목의 게시물은 없습니다.");
        }
        return boardDTOList;
    }

    @Override
    public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
        BoardDTO boardDTO = boardDAO.boardSelectByNo(boardNo);
        if (boardDTO == null) {
            throw new SQLException(boardNo + " 번호의 게시물은 없습니다.");
        }
        return boardDTO;
    }

    @Override
    public void boardInsert(BoardDTO boardDTO) throws SQLException {
        int result = boardDAO.boardInsert(boardDTO);
        if (result != 1) {
            throw new SQLException(boardDTO.toString() + "등록 실패하였습니다.");
        }
    }

    @Override
    public void boardUpdate(BoardDTO boardDTO) throws SQLException {
        int result = boardDAO.boardUpdate(boardDTO);
        if (result != 1) {
            throw new SQLException("수정에 실패하였습니다.");
        }
    }

    @Override
    public void boardDelete(int boardNo) throws SQLException {
        int result = boardDAO.boardDelete(boardNo);
        if (result != 1) {
            throw new SQLException("삭제 실패하였습니다.");
        }
    }

    @Override
    public void replyInsert(ReplyDTO replyDTO) throws SQLException {
        int result = boardDAO.replyInsert(replyDTO);
        if (result == 0) {
            throw new SQLException("댓글 등록에 실패하였습니다");
        }
    }

    @Override
    public BoardDTO replySelectByParentNo(int boardNo) throws SQLException {
        BoardDTO boardDTO = boardDAO.replySelectByParentNo(boardNo);

        if (boardDTO == null) {
            throw new SQLException(boardNo + "에 해당하는 부모글 정보가 없습니다.");
        }

        if (boardDTO.getRepliesList().size() == 0) {
            throw new SQLException(boardNo + "에 해당하는 댓글정보가 없습니다.");
        }

        return boardDTO;

    }
}
