package jdbc.ex0228.dao;

//DB설정 정보를 상수필드로 관리
public interface DbProperties {
    /*public static final*/ String DRIVER_NAME = "oracle.jdbc.driver.OracleDriver";
    String URL = "jdbc:oracle:thin:@192.168.35.153:1521:xe";
    String USER_ID = "c##scott";
    String USER_PWD = "tiger";

}
