package ex0211;

import java.util.ArrayList;
import java.util.List;

public class ListMethodExam {
    List<String> list = new ArrayList<String>(5);

    public void addList(String[] args) {
        list.add("test");
        for (String name : args) {
            //list.add(name);
            //list.add(0, name); //0번지에 정보를 계속 추가 (거꾸로 출력하는 결과)
            //list.set(0, name); // 0번지에 있는 정보를 교체
            if (!list.contains(name)) {
                list.add(name);
            }
        }
    }

    public void printList() {
        for (int i = 0; i < list.size(); i++) {
            String s = list.get(i);
            System.out.println(s);
        }
        System.out.println("-----제거--------");
        //list.remove(2);
        list.remove("kim");
        System.out.println("-------제거된 후---------");
        System.out.println(list);
    }

    public static void main(String[] args) {
        ListMethodExam lm = new ListMethodExam();
        lm.addList(args);
        lm.printList();
    }
}
