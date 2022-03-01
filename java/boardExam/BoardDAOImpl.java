package boardExam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BoardDAOImpl implements BoardDAO {

    @Override
    public List<BoardDTO> boardSelectAll() throws SQLException {
        List<BoardDTO> boardDTOList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select board_no, subject, writer, content, board_date from board";

        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
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
    public List<BoardDTO> boardSelectBySubject(String keyWord) throws SQLException {
        List<BoardDTO> boardDTOList = new ArrayList<>();
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from board where subject like ?";
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
        BoardDTO boardDTO = null;
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from board where board_no = ?";

        try {
            con = DbUtil.getConnection();

            ps = con.prepareStatement(sql);
            ps.setInt(1, boardNo);

            rs = ps.executeQuery();

            while (rs.next()) {
                int board_no = rs.getInt("board_no");
                String subject = rs.getString("subject");
                String writer = rs.getString("writer");
                String content = rs.getString("content");
                String board_date = rs.getString("board_date");

                boardDTO = new BoardDTO(board_no, subject, writer, content, board_date);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps, rs);
        }
        return boardDTO;
    }

    @Override
    public int boardInsert(BoardDTO boardDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into board(board_no, subject, writer, content, board_date) values(board_seq.nextval, ? , ? , ? , sysdate)";
        int result = 0;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, boardDTO.getSubject());
            ps.setString(2, boardDTO.getWriter());
            ps.setString(3, boardDTO.getContent());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int boardUpdate(BoardDTO boardDTO) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "update board set content = ? where board_no = ?";
        int result = 0;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, boardDTO.getContent());
            ps.setInt(2, boardDTO.getBoardNo());

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }

    @Override
    public int boardDelete(int boardNo) throws SQLException {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "delete from board where board_no=?";
        int result = 0;
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, boardNo);

            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps);
        }
        return result;
    }
}
