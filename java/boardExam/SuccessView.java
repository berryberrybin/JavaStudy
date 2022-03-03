package boardExam;

import java.util.List;

public class SuccessView {
    public SuccessView() {
    }

    public static void selectPrint(List<BoardDTO> boardDTOList) {
        for (BoardDTO boardDTO : boardDTOList) {
            System.out.println(boardDTO.toString());
        }
    }

    public static void selectByNoPrint(BoardDTO boardDTO) {
        System.out.println(boardDTO.toString());
    }

    public static void messagePrint(String message) {
        System.out.println(message);
    }

    public static void selectReplyPrint(BoardDTO boardDTO) {
        System.out.println(boardDTO);
        System.out.println("--- 댓글 개수 : " + boardDTO.getRepliesList().size() + "개 ---");
        for (ReplyDTO replyDTO : boardDTO.getRepliesList()) {
            System.out.println("     >>" + replyDTO);
        }
    }
}
