package boardExam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class BoardDAOImpl implements BoardDAO {

    private Properties proFile = DbUtil.getProFile();


    @Override
    public List<BoardDTO> boardSelectAll() throws SQLException {
        List<BoardDTO> boardDTOList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        List<BoardDTO> list = new ArrayList<BoardDTO>();
        String sql = proFile.getProperty("board.selectAll");
        //String sql = "select board_no, subject, writer, content, board_date from board";

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery(); // 실행

            while (rs.next()) {
                BoardDTO dto = new BoardDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                list.add(dto);
//                int board_no = rs.getInt("board_no");
//                String subject = rs.getString("subject");
//                String writer = rs.getString("writer");
//                String content = rs.getString("content");
//                String board_date = rs.getString("board_date");
//
//                BoardDTO boardDTO = new BoardDTO(board_no, subject, writer, content, board_date);
//                boardDTOList.add(boardDTO);
            }
        } finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return list;
    }

    @Override
    public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
        List<BoardDTO> boardDTOList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = proFile.getProperty("board.selectBySubject");
        //String sql = "select * from board where subject like ?";
        try {
            con = DbUtil.getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, "%" + keyWord + "%");

            rs = ps.executeQuery();

            while (rs.next()) {
                int board_no = rs.getInt("board_no");
                String subject = rs.getString("subject");
                String writer = rs.getString("writer");
                String content = rs.getString("content");
                String board_date = rs.getString("board_date");

                BoardDTO boardDTO = new BoardDTO(board_no, subject, writer, content, board_date);
                boardDTOList.add(boardDTO);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return boardDTOList;
    }

    @Override
    public BoardDTO boardSelectByNo(int boardNo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BoardDTO boardDTO = null; // service쪽에서 null인지 물어볼려면 null로 초기화 , =new BoardDTO로 작성하지 않도록 함
        String sql = proFile.getProperty("board.selectByNo");
//        String sql = "select * from board where board_no = ?";

        try {
            con = DbUtil.getConnection();

            ps = con.prepareStatement(sql);
            ps.setInt(1, boardNo);

            rs = ps.executeQuery();

            if (rs.next()) { // primary key 대상으로 하였기 때문에 if문이 더 적합함 (여러번 돌지 못하도록)
                boardDTO = new BoardDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));

//                int board_no = rs.getInt("board_no");
//                String subject = rs.getString("subject");
//                String writer = rs.getString("writer");
//                String content = rs.getString("content");
//                String board_date = rs.getString("board_date");
//
//                boardDTO = new BoardDTO(board_no, subject, writer, content, board_date);
            }
        } finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return boardDTO;
    }

    @Override
    public int boardInsert(BoardDTO boardDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = proFile.getProperty("board.insert");
        // String sql = "insert into board(board_no, subject, writer, content, board_date) values(board_seq.nextval, ? , ? , ? , sysdate)";
        int result = 0;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, boardDTO.getSubject());
            ps.setString(2, boardDTO.getWriter());
            ps.setString(3, boardDTO.getContent());

            result = ps.executeUpdate();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int boardUpdate(BoardDTO boardDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = proFile.getProperty("board.updateByNo");
//        String sql = "update board set content = ? where board_no = ?";
        int result = 0;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, boardDTO.getContent());
            ps.setInt(2, boardDTO.getBoardNo());

            result = ps.executeUpdate();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int boardDelete(int boardNo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = proFile.getProperty("board.deleteByNo");
//        String sql = "delete from board where board_no=?";
        int result = 0;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, boardNo);

            result = ps.executeUpdate();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int replyInsert(ReplyDTO replyDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int result = 0;
        String sql = proFile.getProperty("reply.insert");

        try {
            con = DbUtil.getConnection();

            ps = con.prepareStatement(sql);
            ps.setString(1, replyDTO.getReplyContent());
            ps.setInt(2, replyDTO.getReplyNo());

            result = ps.executeUpdate();

        } finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return result;
    }


    @Override
    public BoardDTO replySelectByParentNo(int boardNo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        BoardDTO boardDTO = null;
        String sql = proFile.getProperty("board.selectByNo"); // select * from board where board_no=?
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, boardNo);
            rs = ps.executeQuery();

            if (rs.next()) {
                boardDTO = new BoardDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4), rs.getString(5));
                //댓글 검색
                List<ReplyDTO> replyList = this.replySelect(con, boardNo);
                boardDTO.setRepliesList(replyList); // 댓글 저장
            }
        } finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return boardDTO;
    }

    // 부모글에 해당하는 댓글 정보 가져오기
    private List<ReplyDTO> replySelect(Connection con, int boardNo) throws SQLException {
        //Connectiond은     replySelectByParentNo() 과 동일하게 사용할 예정이므로 파라미터로 받음
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<ReplyDTO> list = new ArrayList<>();
        String sql = proFile.getProperty("reply.selectByboardNo"); // select * from reply where board_no =?

        try {
            ps = con.prepareStatement(sql);
            ps.setInt(1, boardNo);
            rs = ps.executeQuery();
            while (rs.next()) {
                ReplyDTO reply = new ReplyDTO(rs.getInt(1), rs.getString(2),
                        rs.getInt(3), rs.getString(4));
                list.add(reply);
            }
        } finally {
            DbUtil.dbClose(null, ps, rs); //connection은 닫지 않음 : replySelectByParentNo()에서 닫을 예정
        }
        return list;
    }

}
