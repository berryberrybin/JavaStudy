package ex0215.boardExample.boardService;

import ex0215.boardExample.dto.ArchiveBoard;
import ex0215.boardExample.dto.Board;
import ex0215.boardExample.dto.PhotoBoard;
import ex0215.boardExample.exception.DuplicateException;
import ex0215.boardExample.exception.InexistentException;

import java.util.Map;
import java.util.ResourceBundle;
import java.util.TreeMap;

public class BoardServiceImpl implements BoardService {

    Map<String, Map<String, Board>> allBoardList = new TreeMap<>();
    private static BoardServiceImpl instance = new BoardServiceImpl();

    /**
     * 게시판들의 초기데이터를 로딩
     */
    private BoardServiceImpl() {
        Map<String, Board> archiveMap = new TreeMap<>();
        Map<String, Board> photoMap = new TreeMap<>();

        // 1. ~.properties 파일을 로딩한다.
        ResourceBundle rb = ResourceBundle.getBundle("ex0215/boardExample/boardService/archiveInfo");

        // 2. 읽어온 value의 값을 ,를 기준으로 분리해서 Board객체로 생성
        //    - String에 split(",")메소드 활용
        //    - #key=no,subject,writer,content,date,fileName,fileSize
        for (String key : rb.keySet()) {
            String value = rb.getString(key);
            String v[] = value.split(",");
            Board board = new ArchiveBoard(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], v[5], Integer.parseInt(v[6]));

            // 3. 생성된 Boaorde를 kind 종류에 해당하는 Map에 저장한다.
            archiveMap.put(key, board);
        }

        rb = ResourceBundle.getBundle("ex0215/boardExample/boardService/photoInfo");

        for (String key : rb.keySet()) {
            String value = rb.getString(key);
            String v[] = value.split(",");
            Board board = new PhotoBoard(Integer.parseInt(v[0]), v[1], v[2], v[3], v[4], v[5]);
            photoMap.put(key, board);
        }

        // allBoardList에 3번의 Map을 저장 - allBoardList.put(kind,Map)

        allBoardList.put("archive", archiveMap);
        allBoardList.put("photo", photoMap);

//        System.out.println(allBoardList);
    } // 생성자 끝

//    public static void main(String[] args) {
//        BoardServiceImpl.getInstance();
//    }

    public static BoardServiceImpl getInstance() {
        return instance;
    }

    @Override
    public Map<String, Map<String, Board>> getBoardList() throws InexistentException {
        if (allBoardList == null || allBoardList.isEmpty()) {
            throw new InexistentException("저장된 게시물의 정보가 없습니다.");
        }
        return allBoardList;
    }

    @Override
    public Map<String, Board> getBoardByKind(String kind) throws InexistentException {

        if (!allBoardList.containsKey(kind)) {
            throw new InexistentException(kind + " 유형의 게시판은 존재하지 않습니다.");
        }
        return allBoardList.get(kind);
    }

    @Override
    public Board getBoardByNo(String kind, int no) throws InexistentException {
        String key = String.valueOf(no);
        Board board = getBoardByKind(kind).get(key);
        if (board == null) {
            throw new InexistentException(kind + "유형의 게시판에 " + no + "번호의 게시물은 없습니다.");
        }
        return board;
    }

    @Override
    public void insertBoard(String kind, Board board) throws DuplicateException, InexistentException {
        if (!allBoardList.containsKey(kind)) {
            throw new InexistentException(kind + "유형의 게시판은 오류이므로 등록할 수 없습니다.");
        }
        if (duplicateByNo(kind, board.getNo())) {
            throw new DuplicateException(kind + "유형의 게시판의 " + board.getNo() + " 번호는 중복이므로 등록할 수 없습니다.");
        }
        String key = String.valueOf(board.getNo());
        allBoardList.get(kind).put(key, board);
    }

    @Override
    public boolean duplicateByNo(String kind, int no) {
        return allBoardList.get(kind).containsKey(String.valueOf(no));
    }

    @Override
    public void deleteBoard(String kind, int no) throws InexistentException {

        if (allBoardList.containsKey(kind) && duplicateByNo(kind, no)) {
            getBoardByKind(kind).remove(String.valueOf(no));
        } else {
            throw new InexistentException(kind + "유형의 게시판의 " + no + " 번호 게시물 삭제되지 않았습니다.");
        }
    }

    @Override
    public void updateBoard(Board board, String kind) throws InexistentException {
        if (allBoardList.containsKey(kind) && duplicateByNo(kind, board.getNo())) {
            getBoardByKind(kind).replace(String.valueOf(board.getNo()), board);
            //getBoardByKind(kind).set(String.valueOf(board.getNo())
        } else {
            throw new InexistentException("수정되지 않았습니다.");
        }
    }
}
