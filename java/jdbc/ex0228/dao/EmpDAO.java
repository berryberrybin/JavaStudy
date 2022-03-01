package jdbc.ex0228.dao;

import java.sql.*;

public class EmpDAO {
    //사원의 모든 이름을 검색하기 : 로드-연결-실행-닫기
    public void selectNames() {
        //로드 - DBUtil에서 이미 완료됨
        Connection con = null;
        Statement st = null;
        ResultSet rs = null;


        try {
            //연결
            con = DbUtil.getConnection(); // getConnection()을 만들어뒀기 때문에 호출하면 연결 가능

            //실행
            st = con.createStatement();
            rs = st.executeQuery("select ename from emp"); // select인 경우 사용, 세미콜론 붙이면 안됨
            // 만약 select가 아니라 DDL과 DML인 경우 st.executeUpdate() 사용
            while (rs.next()) {
                String ename = rs.getString(1); // 파라미터로 컬럼명이나 인덱스를 넣을 수 있음
                System.out.println(ename);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally { // finally 블록에서 닫기함
            DbUtil.dbClose(con, st, rs);
        }
    }

    // 사원등록
    // insert into emp(empno, ename, job, sal, hiredate) values(8000,'hee','teacher',2000,sysdate)

    public void insert(Emp emp) {
        Connection con = null;
        Statement st = null;
        String sql = "insert into emp(empno, ename, job, sal, hiredate) values("
                + emp.getEmpno() + ",'" + emp.getEname() + "','" + emp.getJob() + "'," + emp.getSal() + ",sysdate)";
        try {
            System.out.println("sql:" + sql);
            con = DbUtil.getConnection();
            st = con.createStatement();
            int result = st.executeUpdate(sql);
            System.out.println("result : " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, st);
        }
    }

    //사원등록-PreparedStatement로 만들기
    public void preparedInsert(Emp emp) {
        Connection con = null;
        PreparedStatement ps = null;
        String sql = "insert into emp(empno, ename, job, sal, hiredate) values( ?, ?, ?, ?, sysdate)";
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);

            //?의 개수만큼 순서대로 setXxx()설정한다.
            ps.setInt(1, emp.getEmpno());
            ps.setString(2, emp.getEname());
            ps.setString(3, emp.getJob());
            ps.setInt(4, emp.getSal());

            int result = ps.executeUpdate();
            System.out.println("result : " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps);
        }
    }

    //전체사원 검색
    //select empno, ename, job, sal , hiredate, from emp
    public void preparedSelectAll() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select empno, ename, job, sal, hiredate from emp";
        try {
            con = DbUtil.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            //컬럼의 정보
            ResultSetMetaData rmd = rs.getMetaData();
            for (int i = 1; i <= rmd.getColumnCount(); i++) {
                String columnName = rmd.getColumnName(i);
                System.out.print(columnName + "\t\t");
            }
            System.out.println("\n---------------------------------------");
            while (rs.next()) {
                int empno = rs.getInt(1);
                String ename = rs.getString(2);
                String job = rs.getString("job");
                int sal = rs.getInt("SAL");
                String hiredate = rs.getString(5);

                Emp emp = new Emp(empno, ename, job, sal, hiredate);
                System.out.println(emp);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbUtil.dbClose(con, ps, rs);
        }

    }

}
