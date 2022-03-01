package boardExam;

import java.sql.SQLException;

public class BoardController {
    private static BoardService boardService = new BoardServiceImpl();

    public static void boardSelectByAll() {

        try {
            SuccessView.selectPrint(boardService.boardSelectAll());
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void boardSelectBySubject(String keyWord) {
        try {
            SuccessView.selectPrint(boardService.boardSelectBySubject(keyWord));
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }

    }

    public static void boardSelectByNo(int boardNo) {
        try {
            SuccessView.selectByNoPrint(boardService.boardSelectByNo(boardNo));
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void boardInsert(BoardDTO boardDTO) {
        try {
            boardService.boardInsert(boardDTO);
            SuccessView.messagePrint("등록이 완료되었습니다.");
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void boardUpdate(BoardDTO boardDTO) {
        try {
            boardService.boardUpdate(boardDTO);
            SuccessView.messagePrint("수정이 완료되었습니다.");
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void boardDelete(int boardNo) {
        try {
            boardService.boardDelete(boardNo);
            SuccessView.messagePrint(boardNo + " 번의 글이 삭제되었습니다.");
        } catch (SQLException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
}
