package ex0214.setExample;

import java.util.HashSet;
import java.util.Set;

public class MemberSetExam {
    Set<Member> set = new HashSet<Member>();

    public MemberSetExam() {
        set.add(new Member("희정", 10, "서울"));
        set.add(new Member("나영", 13, "대구"));
        set.add(new Member("희정", 12, "서울")); // 객체가 새로 생성되어 중복체크되지 않고 추가됨

        Member m = new Member("수빈", 15, "부산");
        set.add(m);
        set.add(m); // 중복체크되어 추가 되지 않음
        System.out.println("저장된 개수 :" + set.size());
    }

    public static void main(String[] args) {
        new MemberSetExam();
    }
}
