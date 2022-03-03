package boardExam;


import java.io.FileInputStream;
import java.sql.*;
import java.util.Properties;

// 내부에 DbProperties 생성하는 것이 아닌 외부 ~.properties파일 로딩
// 외부의 ~.properties 파일 읽어서 key와 value 분리하는 방법
// - IO 방법 과 ResourceBundle 방법있음
public class DbUtil {

    private static Properties proFile = new Properties();

    // 로드
    static {
        try {
            proFile.load(new FileInputStream("java/resources/dbInfo.properties"));
            proFile.load(new FileInputStream("java/resources/board.properties"));
            Class.forName(proFile.getProperty("driverName"));
            // Class.forName(DbProperties.DRIVER_NAME); // 오라클 드라이버를 찾음
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Properties getProFile() {
        return proFile;
    }

    //연결
    public static Connection getConnection() throws SQLException {
        Connection con = DriverManager.getConnection(

                proFile.getProperty("url"),
                proFile.getProperty("userName"),
                proFile.getProperty("userPass")
        );
        // Connection con = DriverManager.getConnection(DbProperties.URL, DbProperties.USER_ID, DbProperties.USER_PWD);
        return con;
    }


//    public static void main(String[] args) {
//        try {
//            System.out.println("시작--");
//            Connection con = DbUtil.getConnection();
//            System.out.println("con: " + con);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

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
