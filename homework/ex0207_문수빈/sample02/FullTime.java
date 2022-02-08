package ex0207_문수빈.sample02;

public class FullTime extends Employee {
    private int salary;
    private int bonus;

    public FullTime() {
    }

    public FullTime(int empNo, String empName, String job, int mgr, String hiredate, String deptName, int salary, int bonus) {
        // 부모클래스의 생성자를 호출 (생성자구현부 첫줄에서만 가능)
        super(empNo, empName, job, mgr, hiredate, deptName);
        this.salary = salary;
        this.bonus = bonus;
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

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(" | " + salary);
        sb.append(" | " + bonus);
        return sb.toString();
    }

    @Override
    public void message() {
        System.out.println(getEmpName() + " 정규직 사원입니다.");
    }
}
