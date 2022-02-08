package ex0207_문수빈.sample01;

public class FullTime {
    private int empNo;
    private String empName;
    private String job;
    private int mgr;
    private String hiredate;
    private String depName;
    private int salary;
    private int bonus;

    public FullTime() {
    }

    public FullTime(int empNo, String empName, String job, int mgr, String hiredate, String depName, int salary, int bonus) {
        this.empNo = empNo;
        this.empName = empName;
        this.job = job;
        this.mgr = mgr;
        this.hiredate = hiredate;
        this.depName = depName;
        this.salary = salary;
        this.bonus = bonus;
    }

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String geteJob() {
        return job;
    }

    public void seteJob(String job) {
        this.job = job;
    }


    public int getMgr() {
        return mgr;
    }

    public void setMgr(int mgr) {
        this.mgr = mgr;
    }

    public String getHiredate() {
        return hiredate;
    }

    public void setHiredate(String hiredate) {
        this.hiredate = hiredate;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public void message() {
        System.out.println(empName + "사원은 정규직입니다.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("empNo=").append(empNo);
        sb.append(", empName='").append(empName).append('\'');
        sb.append(", job='").append(job).append('\'');
        sb.append(", mgr=").append(mgr);
        sb.append(", hiredate='").append(hiredate).append('\'');
        sb.append(", depName='").append(depName).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", bonus=").append(bonus);
        sb.append('}');
        return sb.toString();
    }
}
