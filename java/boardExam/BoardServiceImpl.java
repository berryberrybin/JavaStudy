package boardExam;

import java.sql.SQLException;
import java.util.List;

public class BoardServiceImpl implements BoardService {
    BoardDAO boardDAO = new BoardDAOImpl();

    @Override
    public List<BoardDTO> boardSelectAll() throws SQLException {

        List<BoardDTO> boardDTOList = boardDAO.boardSelectAll();
        if (boardDTOList == null) {
            throw new SQLException("저장된 게시물이 없습니다.");
        }
        return boardDTOList;
    }

    @Override
    public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
        List<BoardDTO> boardDTOList = boardDAO.boardSelectBySubject(keyWord);
        if (boardDTOList == null) {
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
}
