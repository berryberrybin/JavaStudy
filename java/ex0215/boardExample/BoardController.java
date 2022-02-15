package ex0215.boardExample;

import ex0215.boardExample.boardService.BoardService;
import ex0215.boardExample.boardService.BoardServiceImpl;
import ex0215.boardExample.dto.Board;
import ex0215.boardExample.exception.DuplicateException;
import ex0215.boardExample.exception.InexistentException;

import java.util.Map;

public class BoardController {

    private static BoardService boardService = BoardServiceImpl.getInstance();

    public static void getAllBoard() {
        try {
            Map<String, Map<String, Board>> allBoardList = boardService.getBoardList();
            SuccessView.printBoard(allBoardList);
        } catch (InexistentException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void getBoardByKind(String kind) {
        try {
            Map<String, Board> boardMap = boardService.getBoardByKind(kind);
            SuccessView.printBoardByKind(kind, boardMap);
        } catch (InexistentException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void getBoardByNo(String kind, int no) {
        try {
            Board board = boardService.getBoardByNo(kind, no);
            SuccessView.printBoardByNo(board);
        } catch (InexistentException e) {
            FailView.errorMessage(e.getMessage());
        }

    }

    public static void insertBoard(String kind, Board board) {
        try {
            boardService.insertBoard(kind, board);
            SuccessView.printMessage("등록이 완료되었습니다.");
        } catch (DuplicateException e) {
            FailView.errorMessage(e.getMessage());
        } catch (InexistentException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void deleteBoard(String kind, int no) {
        try {
            boardService.deleteBoard(kind, no);
            SuccessView.printMessage(kind + " 게시판의 " + no + " 번호 게시물이 삭제되었습니다.");
        } catch (InexistentException e) {
            FailView.errorMessage(e.getMessage());
        }
    }

    public static void updateBoard(Board board, String kind) {
        try {
            boardService.updateBoard(board, kind);
            SuccessView.printMessage("수정이 완료되었습니다.");
        } catch (InexistentException e) {
            FailView.errorMessage(e.getMessage());
        }
    }
}
