package boardExam;

import jdbc.ex0228.dao.DbProperties;

import java.sql.*;

public class DbUtil {
    // 로드
    static {
        try {
            Class.forName(DbProperties.DRIVER_NAME); // 오라클 드라이버를 찾음
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    //연결
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PWD);
        return con;
    }

    //닫기 - DDL 또는 DML인 경우 (create, insert, update, delete 인경우)
    public static void dbClose(Connection con, Statement st) {
        try {
            if (st != null) st.close();
            if (con != null) con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //닫기 - Select인 경우 )
    public static void dbClose(Connection con, Statement st, ResultSet rs) {
        try {
            if (rs != null) rs.close();
            dbClose(con, st);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
