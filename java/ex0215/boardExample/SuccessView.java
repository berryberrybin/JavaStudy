package ex0215.boardExample;

import ex0215.boardExample.dto.Board;

import java.util.Map;

public class SuccessView {
    public static void printBoard(Map<String, Map<String, Board>> map) {
        for (String key : map.keySet()) {
            Map<String, Board> boardMap = map.get(key);
            System.out.println("--------- " + key + " Board의 모든 게시물 List ---------");

            for (String boardKey : boardMap.keySet()) {
                System.out.print("key = " + boardKey + " [");
                System.out.println(boardMap.get(boardKey) + " ]");
            }
        }
    }

    public static void printBoardByKind(String kind, Map<String, Board> boardMap) {
        System.out.println("---------- " + kind + "유형의 게시물 List---------------");
        for (String boardKey : boardMap.keySet()) {
            System.out.println(boardMap.get(boardKey));
        }
    }

    public static void printBoardByNo(Board board) {
        System.out.println(board);
    }

    public static void printMessage(String message) {
        System.out.println(message);
    }

}
