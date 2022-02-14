package ex0214.mapExample;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapPractice {

    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(10, "cat");
        map.put(40, "dog");
        map.put(50, "rabbit");
        map.put(30, "lion");


        // map에 있는 모든 key의 정보를 검색한다.
        Set<Integer> set = map.keySet();

        Iterator<Integer> it = set.iterator();
        while (it.hasNext()) {
            Integer key = it.next();
            String value = map.get(key);
            System.out.println(key + " " + value);
        }
        System.out.println("-------개선된 for문---------");

        for (int key : map.keySet()) {
            String value = map.get(key);
            System.out.println(key + " : " + value);
        }

        System.out.println("--------Map.Entry<K,V> 사용하기---------");
        Set<Map.Entry<Integer, String>> entrySet = map.entrySet();
        Iterator<Map.Entry<Integer, String>> iterator = entrySet.iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, String> entry = iterator.next();
            System.out.println(entry.getKey() + " : " + entry.getValue());
        }

        System.out.println("--------Map.Entyr<K,V> 개선된 for문 ");
        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println(entry);
        }
    }
}
