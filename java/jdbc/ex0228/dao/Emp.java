package jdbc.ex0228.dao;

public class Emp {
    private int empno;
    private String ename;
    private String job;
    private int sal;
    private String hiredate; //DB에서는 date타입이지만 string으로 받아도 됨

    public Emp() {
    }

    public Emp(int empno, String ename, String job, int sal) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
    }

    public Emp(int empno, String ename, String job, int sal, String hiredate) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.sal = sal;
        this.hiredate = hiredate;
    }

    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public int getSal() {
        return sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("empno=").append(empno);
        sb.append(", ename='").append(ename).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", sal=").append(sal);
        sb.append(", hiredate='").append(hiredate).append('\'');
        return sb.toString();
    }
}
