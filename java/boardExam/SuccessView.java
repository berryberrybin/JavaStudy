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
}
